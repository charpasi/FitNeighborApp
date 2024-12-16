package com.example.fitneighborapp.home;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.fitneighborapp.R;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        String[] cardTitles = {"Ongoing Challenges", "Check My Progress"};
        HomePageAdapter adapter = new HomePageAdapter(cardTitles);
        viewPager.setAdapter(adapter);

    }
}
