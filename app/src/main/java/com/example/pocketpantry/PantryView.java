package com.example.pocketpantry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class PantryView extends AppCompatActivity {
    private Button addButton;
    private ImageButton backButton;

    // pantry recyclerview
    ArrayList<pantryItemModel> pantryItemModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_view);

        addButton = findViewById(R.id.pantryAddButtton);
        backButton = findViewById(R.id.backButton);

        // pantry recyclerview
        RecyclerView recyclerView = findViewById(R.id.pantryRecyclerView);
        setUpPantryItemModels();//set up models
        // set up adapter AFTER setUpPantryItemModels
        PantryRecyclerViewAdapter adapter = new PantryRecyclerViewAdapter(this, pantryItemModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantryView.this, PantryAddView.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantryView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // pantry recyclerview
    private  void setUpPantryItemModels() {
        String[] itemNames = ;
        String[] itemQuantities = ;
        String[] itemweights = ;

        for (int i = 0; i<itemNames.length; i++) {
            pantryItemModels.add(new pantryItemModel(itemNames[i], itemQuantities[i], itemweights[i]));
        }
    }
}
