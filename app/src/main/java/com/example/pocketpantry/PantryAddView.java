package com.example.pocketpantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PantryAddView extends AppCompatActivity{
    private static final String TAG = "PantryAddView";

    private Button addButton;
    private ImageButton backButton;
    private EditText quantityValue, weightValue;
    private Presenter presenter;
    private Spinner itemSpinner;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_add_view);

        addButton = findViewById(R.id.addItemButton);
        backButton = findViewById(R.id.backButton2);
        quantityValue = findViewById(R.id.quantity);
        weightValue = findViewById(R.id.weight);

        // populate spinner with food items
        itemSpinner = (Spinner) findViewById(R.id.pantryItems);
        items = getResources().getStringArray(R.array.foodItems);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantryAddView.this,PantryView.class);
                startActivity(intent);
            }
        });

    }

    public void startThread(View view) {
        PantryRunnable runnable = new PantryRunnable();
        new Thread(runnable).start();
    }
    public void stopThread(View view) {

    }

    class PantryRunnable implements Runnable {
        @Override
        public void run() {
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String quantityString = quantityValue.getText().toString();
                    int quantity = Integer.parseInt(String.valueOf(quantityString));
                    //Log.d(TAG, "quantity: " + quantity);

                    String weightString = weightValue.getText().toString();
                    float weight = Float.parseFloat(String.valueOf(weightString));
                    //Log.d(TAG, "weight: " + weight);

                    itemSpinner = findViewById(R.id.pantryItems);
                    String pantryItem = itemSpinner.getSelectedItem().toString();
                    System.out.println(pantryItem);

                    Log.d(TAG, "PantryAddView.this: " + PantryAddView.this + ", pantryItem: " + pantryItem + ", quantity: " + quantity + ", weight: " + weight);

                    presenter = new Presenter();

                    boolean success = presenter.onClickCreatePantryItem(PantryAddView.this, pantryItem, quantity, weight);

                    Toast.makeText(PantryAddView.this, "Success = "+success, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}