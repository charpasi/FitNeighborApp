package com.example.fitneighborapp.home;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fitneighborapp.R;
import com.example.fitneighborapp.challenges.ChallengesActivity;
import com.example.fitneighborapp.streak.StreakActivity;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder> {

    private List<String> pageTitles;
    private Context context;
    public HomePageAdapter(List<String> pageTitles, Context context) {
        this.pageTitles = pageTitles;
        this.context = context;
    }

    @NonNull
    @Override
    public HomePageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ongoing_challenges, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_check_progress, parent, false);
        }
        return new HomePageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewHolder holder, int position) {
        String title = pageTitles.get(position);
        holder.cardText.setText(title);
    }

    @Override
    public int getItemCount() {
        return pageTitles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class HomePageViewHolder extends RecyclerView.ViewHolder {
        TextView cardText;

        public HomePageViewHolder(View itemView) {
            super(itemView);
            cardText = itemView.findViewById(R.id.cardText);

            itemView.setOnClickListener(v -> {
                if (getAdapterPosition() == 0) {
                    context.startActivity(new Intent(context, ChallengesActivity.class));
                } else {
                    context.startActivity(new Intent(context, StreakActivity.class));
                }
            });
        }
    }
}
