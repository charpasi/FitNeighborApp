package com.example.fitneighborapp;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
//import androidx.annotation.NonNull;

public class MainActivity extends NavBar {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout homePageContainer = findViewById(R.id.homePageContainer);
        View homePage = getLayoutInflater().inflate(R.layout.home_page, homePageContainer, false);
        homePageContainer.addView(homePage);
        setupBottomNavigation(R.id.nav_home);
    }
}
