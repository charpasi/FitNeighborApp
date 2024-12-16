package com.example.fitneighborapp.home;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.fitneighborapp.R;
import java.util.Arrays;
import java.util.List;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        List<String> pageTitles = Arrays.asList("Ongoing Challenges", "Check My Progress");
        HomePageAdapter adapter = new HomePageAdapter(pageTitles, this);
        viewPager.setAdapter(adapter);

    }
}
