package com.example.fruits.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.fruits.model.FruitModel;
import com.example.fruits.R;
import com.example.fruits.cart.ShowDetailFragment;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder> {

    SearchFragment context;
    ArrayList<FruitModel> arrayList;
    private ArrayList<FruitModel> originalList;
    private ArrayList<FruitModel> filteredList;
    LayoutInflater layoutInflater;

    public SearchAdapter(SearchFragment context, ArrayList<FruitModel> arrayList) {
        this.context = context;
        this.originalList = arrayList;
        this.filteredList = new ArrayList<>(arrayList);
        layoutInflater = LayoutInflater.from(context.requireContext());
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        FruitModel currentFood = filteredList.get(position);

        holder.foodname.setText(currentFood.getTitle());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(currentFood.getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.img);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && position < filteredList.size()) {
                    FruitModel selectedFood = filteredList.get(position);
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
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(originalList);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (FruitModel food : originalList) {
                if (food.getTitle().toLowerCase().contains(lowerCaseQuery)) {
                    filteredList.add(food);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView foodname;
        ImageView img;
        CardView card;
        TextView size;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            foodname = itemView.findViewById(R.id.txt);
            img = itemView.findViewById(R.id.productimg);
            card = itemView.findViewById(R.id.cardviewitem);

        }
    }
}
