/**********************************************
 *
 * Pantry Add view allows you to choose from a drop down list of baking items,
 * using a spinner you can select the desired item.
 *
 * Also prompts you for the quantity and weight, when the add item button is pressed
 * the item, quantity, and weight is added to the pantry database and is displayed on
 * the pantry view.
 *
 **********************************************/
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
    private Button addButton, backButton;

    private EditText quantityValue, weightValue;
    private Presenter presenter;
    private Spinner itemSpinner;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_add_view);

        // add item, back button, quantity and weight variables found by id
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

        // onClick listener for back button, change activity to home view
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantryAddView.this,PantryView.class);
                startActivity(intent);
            }
        });

        // onClick listener for add item button, add item selected from spinner, quantity and weight to database
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

<<<<<<< HEAD
            }
        });
    }

=======
                String quantityString = quantityValue.getText().toString();
                int quantity = Integer.parseInt(String.valueOf(quantityString));

                String weightString = weightValue.getText().toString();
                float weight = Float.parseFloat(String.valueOf(weightString));
>>>>>>> develop

    @Override
    public void run() {
        String quantityString = quantityValue.getText().toString();
        int quantity = Integer.parseInt(String.valueOf(quantityString));
        //Log.d(TAG, "quantity: " + quantity);

<<<<<<< HEAD
        String weightString = weightValue.getText().toString();
        float weight = Float.parseFloat(String.valueOf(weightString));
        //Log.d(TAG, "weight: " + weight);

        itemSpinner = findViewById(R.id.pantryItems);
        String pantryItem = itemSpinner.getSelectedItem().toString();
        System.out.println(pantryItem);

        Log.d(TAG, "PantryAddView.this: " + PantryAddView.this + ", pantryItem: " + pantryItem + ", quantity: " + quantity + ", weight: " + weight);

        presenter = new Presenter();
=======
                Presenter presenter = new Presenter(PantryAddView.this);

                boolean success = presenter.onClickCreatePantryItem(pantryItem, quantity, weight);

                Toast.makeText(PantryAddView.this, success ? "Item added to Pantry" : "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
>>>>>>> develop

        boolean success = presenter.onClickCreatePantryItem(PantryAddView.this, pantryItem, quantity, weight);

        Toast.makeText(PantryAddView.this, "Success = "+success, Toast.LENGTH_SHORT).show();
    }
}