package com.example.workshop.ui.fun.foodScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.workshop.R;

public class RecyclerViewVerticalListAdapter extends RecyclerView.Adapter<RecyclerViewVerticalListAdapter.foodViewHolder> {
    private List<FoodsModel> foodsList;
    Context context;

    public RecyclerViewVerticalListAdapter(List<FoodsModel> foodsModelList, Context context) {
        this.foodsList = foodsModelList;
        this.context = context;
    }

    @Override
    public foodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View foodLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        foodViewHolder foodViewHolder = new foodViewHolder(foodLayoutView);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(foodViewHolder holder, final int position) {
        holder.foodImageView.setImageResource(foodsList.get(position).getFoodImage());
        holder.foodTextView.setText(foodsList.get(position).getFoodName());
        holder.foodsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = foodsList.get(position).getFoodName();
                Toast.makeText(context, foodName + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }


    public class foodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodTextView;
        ConstraintLayout foodsLayout;

        public foodViewHolder(View view) {
            super(view);
            foodImageView = view.findViewById(R.id.food_image_view);
            foodTextView = view.findViewById(R.id.food_name_text_view);
            foodsLayout = view.findViewById(R.id.foods_layout);
        }
    }
}