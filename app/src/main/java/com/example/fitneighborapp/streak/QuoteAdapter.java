package com.example.fitneighborapp.streak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitneighborapp.R;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {

    private String[] quotes;

    public QuoteAdapter(String[] quotes) {
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom page layout for ViewPager2
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.page_layout, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.quoteTextView.setText(quotes[position]);
    }

    @Override
    public int getItemCount() {
        return quotes.length;
    }

    public static class QuoteViewHolder extends RecyclerView.ViewHolder {

        TextView quoteTextView;

        public QuoteViewHolder(View itemView) {
            super(itemView);
            // Reference to the TextView in the custom layout
            quoteTextView = itemView.findViewById(R.id.quoteText);
        }
    }
}
