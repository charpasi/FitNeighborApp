package com.example.fitneighborapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitneighborapp.challenges.ChallengesActivity;
import com.example.fitneighborapp.messages.MessagesActivity;
import com.example.fitneighborapp.streak.StreakActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class NavBar extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupBottomNavigation(int selectedItemId) {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the selected item for the current page
        bottomNavigationView.setSelectedItemId(selectedItemId);

        // Set up navigation listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                if (selectedItemId != R.id.nav_home) {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); // Avoid multiple instances
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
                return true;

            } else if (id == R.id.nav_messages) {
                if (selectedItemId != R.id.nav_messages) {
                    Intent intent = new Intent(this, MessagesActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
                return true;

            } else if (id == R.id.nav_activity) {
                // Replace with actual activity navigation
                return true;

            } else if (id == R.id.nav_streak) {
                if (selectedItemId != R.id.nav_streak) {
                    Intent intent = new Intent(this, StreakActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
                return true;

            } else if (id == R.id.nav_challenge) {
                if (selectedItemId != R.id.nav_challenge) {
                    Intent intent = new Intent(this, ChallengesActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
                return true;

            } else {
                return false;
            }
        });
    }
}