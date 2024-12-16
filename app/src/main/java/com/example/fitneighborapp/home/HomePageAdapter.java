package com.example.fitneighborapp.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitneighborapp.R;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.CardViewHolder> {

    private String[] cards;

    public HomePageAdapter(String[] cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom page layout for ViewPager2
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ongoing_challenges, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.cardTextView.setText(cards[position]);
    }

    @Override
    public int getItemCount() {
        return cards.length;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        TextView cardTextView;

        public CardViewHolder(View itemView) {
            super(itemView);
            cardTextView = itemView.findViewById(R.id.cardText);
        }
    }
}
