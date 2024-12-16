package com.example.fitneighborapp.challenges;

import android.os.Bundle;

import com.example.fitneighborapp.NavBar;
import com.example.fitneighborapp.R;

public class ChallengesActivity extends NavBar {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_challenge); // Your layout file
        setupBottomNavigation(R.id.nav_challenge);
    }
}
