package com.example.pocketpantry;

import android.content.Context;

public class Presenter implements Contract.Presenter{

    //the 'model' object will be used to call all
    // methods from the 'Model' contract
    private Contract.Model model;

    @Override
    public void onClickCreateRecipe() {

    }

    @Override
    public void onClickReadRecipe() {

    }

    @Override
    public void onClickUpdateRecipe() {

    }

    @Override
    public void onClickDeleteRecipe() {

    }

    @Override
    public void showAllRecipes() {

    }

    public void onClickCreatePantryItem(Context context, String name, int quantity, float weight) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.addOne(name, quantity, weight);
    }

    @Override
    public void onClickReadPantryItem() {

    }

    public void onClickUpdatePantryItem(Context context, PantryItem pantryItem) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.updateItem(pantryItem);
    }

    public void onClickDeletePantryItem(Context context, int _id) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.deleteItem(_id);
    }

    public void showAllPantryItems(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.getAll();
    }
}
