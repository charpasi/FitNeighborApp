package com.example.fitneighborapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class QuickChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_challenge);

        // Set button click listeners
        findViewById(R.id.button).setOnClickListener(v -> openActivity("Biking Activity"));
        findViewById(R.id.button2).setOnClickListener(v -> openActivity("Walking Activity"));
        findViewById(R.id.button3).setOnClickListener(v -> openActivity("Running Activity"));
    }

    // Navigate to CurrentActivity with the activity type
    private void openActivity(String activityType) {
        //Intent intent = new Intent(this, CurrentActivity.class);
        //intent.putExtra("ACTIVITY_TYPE", activityType); // Pass the activity type
        //startActivity(intent); // Start CurrentActivity
    }
}
