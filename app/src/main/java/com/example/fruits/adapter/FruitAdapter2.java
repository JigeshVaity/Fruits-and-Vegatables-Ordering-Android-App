package com.example.fruits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fruits.model.FruitModel;
import com.example.fruits.R;
import com.example.fruits.cart.ShowDetailFragment;

import java.util.List;

public class FruitAdapter2 extends RecyclerView.Adapter<FruitAdapter2.ViewHolder> {
    private List<FruitModel> dataList;
    private Context context;

    public FruitAdapter2(List<FruitModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FruitModel data = dataList.get(position);

        // Bind data to views
        holder.title.setText(data.getTitle());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(data.getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.picImageView);
        String priceTxt = "₹ " + String.valueOf(data.getFee());
        holder.priceTxt.setText(priceTxt);
        holder.weight.setText(data.getWeight());

        // Additional bindings if needed
        holder.linearcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && position < dataList.size()) {
                    FruitModel selectedFood = dataList.get(position);
                    if (selectedFood != null) {
                        // Create a new instance of ShowDetailFragment with the selected FoodDomain
                        ShowDetailFragment showDetailFragment = ShowDetailFragment.newInstance(selectedFood);

                        // Use FragmentTransaction to display the fragment
                        FragmentTransaction fragmentTransaction = ((AppCompatActivity) holder.itemView.getContext()).getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, showDetailFragment); // Use your container view id
                        fragmentTransaction.addToBackStack(null); // Add to the back stack if needed
                        fragmentTransaction.commit();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picImageView;
        TextView title;
        TextView priceTxt;
        TextView weight;

        LinearLayout linearcat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize your views here
            picImageView = itemView.findViewById(R.id.img1);
            title = itemView.findViewById(R.id.titletext);
            priceTxt = itemView.findViewById(R.id.pricetext);
            weight = itemView.findViewById(R.id.weighttext);

            linearcat = itemView.findViewById(R.id.linearcat);
        }
    }
}

