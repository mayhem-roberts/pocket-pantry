package com.example.pocketpantry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PantryRecyclerViewAdapter extends RecyclerView.Adapter<PantryRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<PantryItem> pantryItems;

    public PantryRecyclerViewAdapter(Context context, ArrayList<PantryItem> pantryItems) {
        this.context = context;
        this.pantryItems = pantryItems;
    }

    @NonNull
    @Override
    public PantryRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pantry_rv_row, parent, false);
        return new PantryRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PantryRecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views created in pantry_rv_row layout xml file, based on the position of the recycler view
        holder.name.setText(pantryItems.get(position).getName());
        holder.quantity.setText(String.valueOf(pantryItems.get(position).getQuantity()));
        holder.weight.setText(String.valueOf(pantryItems.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return pantryItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, quantity, weight;

        // kind of like the onCreate method, it gravs the views from the pantry_rv_row layout xml file
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            quantity = itemView.findViewById(R.id.item_quantity);
            weight = itemView.findViewById(R.id.item_weight);
        }
    }
}
