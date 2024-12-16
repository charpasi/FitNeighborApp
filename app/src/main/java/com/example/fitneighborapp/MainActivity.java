package com.example.fitneighborapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

import com.example.fitneighborapp.home.CardAdapter;
import com.example.fitneighborapp.home.HomePageAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
//import androidx.annotation.NonNull;

public class MainActivity extends NavBar {
    private TextView clockTextView;
    private final Handler handler = new Handler();
    private Runnable timeUpdater;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2 viewPager = findViewById(R.id.imageViewPager);

        int[] images = {
                R.drawable.stepcounter,
                R.drawable.milescounter,
                R.drawable.pointscounter
        };

        HomePageAdapter adapter = new HomePageAdapter(this, images);
        viewPager.setAdapter(adapter);

        ViewPager2 cardPager = findViewById(R.id.viewPager);
        int[] images2 = {
                R.drawable.ongoingchallenges,
                R.drawable.newmessages,
        };

        CardAdapter adapter2 = new CardAdapter(this, images2);
        cardPager.setAdapter(adapter2);

        clockTextView = findViewById(R.id.clock);

        startClock();

        setupBottomNavigation(R.id.nav_home);
    }
    private void startClock() {
        timeUpdater = new Runnable() {
            @Override
            public void run() {
                String currentTime = new SimpleDateFormat("h:mm a", Locale.getDefault()).format(new Date());

                clockTextView.setText(currentTime);

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(timeUpdater);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timeUpdater != null) {
            handler.removeCallbacks(timeUpdater);
        }
    }
}
