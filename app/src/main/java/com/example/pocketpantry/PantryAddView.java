package com.example.pocketpantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class PantryAddView extends AppCompatActivity{
    private Button addButton;
    private ImageButton backButton;
    private TextView quantityValue, weightValue;
    private Presenter presenter;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_add_view);
        addButton = findViewById(R.id.pantryAddButtton);
        backButton = findViewById(R.id.backButton2);

        quantityValue = findViewById(R.id.quantity);
        weightValue = findViewById(R.id.weight);

        quantityValue.getText().toString();
        int quantity = Integer.parseInt(String.valueOf(quantityValue));

        weightValue.getText().toString();
        float weight = Float.parseFloat(String.valueOf(weightValue));

        spinner = findViewById(R.id.pantryItems);
        String pantryItem = spinner.getSelectedItem().toString();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.foodItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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