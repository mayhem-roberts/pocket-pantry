package com.example.pocketpantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class PantryAddView extends AppCompatActivity {
    private Button addButton;
    private ImageButton backButton;
    private TextView quantity, weight;
    private Presenter presenter;
    private Spinner pantryItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_add_view);
        addButton = findViewById(R.id.pantryAddButtton);
        backButton = findViewById(R.id.backButton2);
        quantity = findViewById(R.id.quantity).getText();
        weight = findViewById(R.id.weight);
        pantryItem = findViewById(R.id.pantryItems);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantryAddView.this,PantryView.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickCreatePantryItem(PantryAddView.this, pantryItem, quantity, weight);
            }
        });
    }
}