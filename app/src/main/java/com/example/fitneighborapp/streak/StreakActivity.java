package com.example.fitneighborapp.streak;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.fitneighborapp.NavBar;
import com.example.fitneighborapp.R;

import java.util.Calendar;

public class StreakActivity extends NavBar {

    private TextView streakCountText;
    private ViewPager2 quotePager;
    private int streakCount = 0;  // Default streak count, can be dynamically updated.
    private String[] motivationalQuotes = {
            "Keep pushing forward!",
            "You're doing great!",
            "One day at a time!",
            "Stay strong, you're almost there!",
            "Success is the sum of small efforts!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaks);  // Ensure the layout file name matches

        streakCountText = findViewById(R.id.streakCountText);
        quotePager = findViewById(R.id.quotePager);

        setupBottomNavigation(R.id.nav_streak);

        // Set up streak count
        SharedPreferences sharedPreferences = getSharedPreferences("streaksPrefs", MODE_PRIVATE);
        int lastCompletionDay = sharedPreferences.getInt("lastCompletionDay", -1);

        // Calculate streak count based on the last activity completion date.
        streakCount = calculateStreak(lastCompletionDay);
        streakCountText.setText("Streak: " + streakCount + " Days");

        // Set up ViewPager for motivational quotes
        QuoteAdapter quoteAdapter = new QuoteAdapter(motivationalQuotes);
        quotePager.setAdapter(quoteAdapter);
    }

    // Function to calculate streak
    private int calculateStreak(int lastCompletionDay) {
        int currentDay = getCurrentDayOfYear();
        if (lastCompletionDay == -1 || currentDay != lastCompletionDay + 1) {
            return 0; // reset streak if not consecutive
        }
        return currentDay - lastCompletionDay;
    }

    private int getCurrentDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    // Example method to update streak when the user completes a task
    public void onTaskCompleted() {
        SharedPreferences sharedPreferences = getSharedPreferences("streaksPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int currentDay = getCurrentDayOfYear();
        editor.putInt("lastCompletionDay", currentDay);
        editor.apply();  // Save the completion day to SharedPreferences

        // Now recalculate the streak count
        streakCount = calculateStreak(sharedPreferences.getInt("lastCompletionDay", -1));
        streakCountText.setText("Streak: " + streakCount + " Days");
    }
}
