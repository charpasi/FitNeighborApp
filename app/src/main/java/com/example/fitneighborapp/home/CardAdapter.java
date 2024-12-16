package com.example.fitneighborapp.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitneighborapp.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final int[] images; // Array of drawable resource IDs
    private final Context context; // Activity context
    private final Class<?>[] targetActivities; // Array of target activities

    // Constructor
    public CardAdapter(Context context, int[] images, Class<?>[] targetActivities) {
        this.context = context;
        this.images = images;
        this.targetActivities = targetActivities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the image resource
        holder.imageView.setImageResource(images[position]);

        // Set click listener to navigate to the relevant activity
        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, targetActivities[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    // ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
