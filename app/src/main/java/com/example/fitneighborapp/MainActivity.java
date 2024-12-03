package com.example.fitneighborapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitneighborapp.messages.MessagesActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set up navigation listener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Already on Home page, do nothing
                return true;

            } else if (id == R.id.nav_messages) {
                // Navigate to MessagesActivity
                Intent intent = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(intent);
                return true;

            } else if (id == R.id.nav_activity) {
                // Navigate to ActivityActivity (if implemented)
                // Intent intent = new Intent(MainActivity.this, ActivityActivity.class);
                // startActivity(intent);
                return true;

            } else if (id == R.id.nav_streak) {
                // Navigate to StreakActivity (if implemented)
                // Intent intent = new Intent(MainActivity.this, StreakActivity.class);
                // startActivity(intent);
                return true;

            } else if (id == R.id.nav_challenge) {
                // Navigate to ChallengeActivity (if implemented)
                // Intent intent = new Intent(MainActivity.this, ChallengeActivity.class);
                // startActivity(intent);
                return true;

            } else {
                return false;
            }
        });
    }
}
