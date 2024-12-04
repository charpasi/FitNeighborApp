package com.example.fitneighborapp.messages;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitneighborapp.NavBar;
import com.example.fitneighborapp.R;
import com.example.fitneighborapp.data.AppDatabase;
import com.example.fitneighborapp.data.MessageDao;

import java.util.ArrayList;
import java.util.List;

public class MessagesActivity extends NavBar {

    private RecyclerView recyclerViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private MessageAdapter adapter;
    private List<Messages> messageList;
    private Spinner spinnerChatSelection;
    private String currentChatSelection = "Team";  // Default chat selection
    private AppDatabase appDatabase;
    private MessageDao messageDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        setupBottomNavigation(R.id.nav_messages);

        // Initialize views
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        spinnerChatSelection = findViewById(R.id.spinnerChatSelection);

        // Set up the RecyclerView with adapter and layout manager
        messageList = new ArrayList<>();
        adapter = new MessageAdapter(messageList);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(adapter);

        // Initialize Room database and DAO
        appDatabase = AppDatabase.getInstance(this);
        messageDao = appDatabase.messageDao();

        // Create an array of options for the spinner (Team, Town, State)
        String[] chatOptions = {"Team", "Town", "State"};

        // Set up the adapter to populate the spinner with the options
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, chatOptions);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChatSelection.setAdapter(adapterSpinner);

        // Spinner item selection listener
        spinnerChatSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                currentChatSelection = parentView.getItemAtPosition(position).toString();
                // Show a Toast message for testing
                Toast.makeText(MessagesActivity.this, "Chat switched to: " + currentChatSelection, Toast.LENGTH_SHORT).show();
                loadMessagesForSelectedChat();  // Load messages based on the selected chat type
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No action needed here
            }
        });

        // Send button click listener
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageContent = editTextMessage.getText().toString();
                if (!messageContent.isEmpty()) {
                    Messages newMessage = new Messages("You", messageContent, System.currentTimeMillis(), currentChatSelection);
                    new InsertMessageAsyncTask().execute(newMessage);  // Insert message in background thread
                    editTextMessage.setText("");  // Clear the input field
                    recyclerViewMessages.scrollToPosition(messageList.size() - 1);  // Scroll to bottom
                }
            }
        });

        // Load initial messages (for default chat type, e.g., "Team")
        loadMessagesForSelectedChat();
    }

    // AsyncTask to handle database insert in background
    private class InsertMessageAsyncTask extends AsyncTask<Messages, Void, Messages> {

        @Override
        protected Messages doInBackground(Messages... messages) {
            messageDao.insertMessage(messages[0]);  // Insert the message into the database
            return messages[0];  // Return the message back to the UI thread
        }

        @Override
        protected void onPostExecute(Messages message) {
            // After inserting, update the message list on the main thread
            messageList.add(message);  // Add the newly inserted message
            adapter.notifyItemInserted(messageList.size() - 1);  // Notify adapter
            recyclerViewMessages.scrollToPosition(messageList.size() - 1);  // Scroll to bottom
        }
    }

    // Load messages based on the selected chat type
    private void loadMessagesForSelectedChat() {
        // Clear the existing messages
        messageList.clear();

        // Query the database for messages based on the selected chat type
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Messages> messages = messageDao.getMessagesForChat(currentChatSelection);

                // Debugging: Log the number of messages loaded
                Log.d("MessagesActivity", "Messages loaded: " + messages.size());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        messageList.addAll(messages);  // Add fetched messages to the list
                        adapter.notifyDataSetChanged();  // Notify adapter that data has changed
                    }
                });
            }
        }).start();  // Make sure the thread runs
    }
}
