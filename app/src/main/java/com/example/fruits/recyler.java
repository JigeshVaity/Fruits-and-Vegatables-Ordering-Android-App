package com.example.fruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruits.model.recylermodel;

import java.util.List;

public class recyler extends RecyclerView.Adapter<recyler.ViewHolder> {

    private List<recylermodel> dataList;
    private Context context;

    public recyler(List<recylermodel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viemholder_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recylermodel data = dataList.get(position);

        // Bind data to views
        holder.titleTextView.setText(data.getTitle());
        holder.picImageView.setImageResource(data.getPic());
/*
        // Apply different background colors for the first three items
        if (position < 6) {
            switch (position) {
                case 0:
                    holder.secondLinearLayout.setBackgroundResource(R.drawable.combined_background1);
                    break;
                case 1:
                    holder.secondLinearLayout.setBackgroundResource(R.color.secondItemBackgroundColor);
                    break;
                case 2:
                    holder.secondLinearLayout.setBackgroundResource(R.color.thirdItemBackgroundColor);
                    break;
                case 3:
                    holder.secondLinearLayout.setBackgroundResource(R.color.firstItemBackgroundColor);
                    break;
                case 4:
                    holder.secondLinearLayout.setBackgroundResource(R.color.secondItemBackgroundColor);
                    break;
                case 5:
                    holder.secondLinearLayout.setBackgroundResource(R.color.thirdItemBackgroundColor);
                    break;
            }
        } else {
            // For the rest of the items, set a default background color
            holder.itemView.setBackgroundResource(android.R.color.transparent);
        }*/
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picImageView;
        TextView titleTextView;
        LinearLayout secondLinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize your views here
            picImageView = itemView.findViewById(R.id.pic);
            titleTextView = itemView.findViewById(R.id.title);
            secondLinearLayout = itemView.findViewById(R.id.secondLinearLayout);
        }
    }
}
