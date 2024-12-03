package com.example.fitneighborapp.messages;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitneighborapp.R;

import java.util.ArrayList;
import java.util.List;

public class MessagesActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private MessageAdapter adapter;
    private List<Messages> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);  // Link to XML layout

        // Initialize RecyclerView and other views
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        // Set up the RecyclerView with adapter and layout manager
        messageList = new ArrayList<>();
        adapter = new MessageAdapter(messageList);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(adapter);

        // Send button click listener
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageContent = editTextMessage.getText().toString();
                if (!messageContent.isEmpty()) {
                    messageList.add(new Messages("You", messageContent, System.currentTimeMillis()));
                    adapter.notifyItemInserted(messageList.size() - 1);
                    editTextMessage.setText("");  // Clear the input field
                    recyclerViewMessages.scrollToPosition(messageList.size() - 1);  // Scroll to bottom
                }
            }
        });
    }
}
