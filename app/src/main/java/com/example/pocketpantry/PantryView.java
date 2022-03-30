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
import java.util.List;

public class PantryView extends AppCompatActivity {
    private Button addButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_view);

        addButton = findViewById(R.id.pantryAddButtton);
        backButton = findViewById(R.id.backButton);

        // pantry recyclerview
        RecyclerView recyclerView = findViewById(R.id.pantryRecyclerView);
        Presenter presenter = new Presenter(PantryView.this);
        // set up adapter AFTER setUpPantryItemModels
        PantryRecyclerViewAdapter adapter = new PantryRecyclerViewAdapter(this, presenter.showAllPantryItems());
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
}
