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

    @Override
    public void onClickCreatePantryItem(Context context, String name, int quantity, float weight) {
        DatabaseHelper databaseHelper(context);
        databaseHelper.addOne(name, quantity, weight);
    }

    @Override
    public void onClickReadPantryItem() {

    }

    @Override
    public void onClickUpdatePantryItem() {

    }

    @Override
    public void onClickDeletePantryItem() {

    }

    @Override
    public void showAllPantryItems(Context context) {
        DatabaseHelper databaseHelper(context);
        databaseHelper.getAll();
    }
}
