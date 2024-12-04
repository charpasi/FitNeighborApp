package com.example.fitneighborapp;

import android.content.Intent;
import android.os.Bundle;
//import androidx.annotation.NonNull;

public class MainActivity extends NavBar {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation(R.id.nav_home);
    }
}
