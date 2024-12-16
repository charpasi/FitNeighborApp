package com.example.fitneighborapp.challenges;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.compose.ui.node.ViewAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fitneighborapp.NavBar;
import com.example.fitneighborapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ChallengesActivity extends NavBar {

    private LinearLayout formLayout; // Form layout
    private EditText distanceInput;
    private Spinner unitSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        setupBottomNavigation(R.id.nav_challenge);


        int[] layouts = {
                R.layout.quick_challenge,
                R.layout.current_challenges,
                R.layout.completed_challenges
        };

        ViewPager2 viewPager = findViewById(R.id.viewPager2);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
