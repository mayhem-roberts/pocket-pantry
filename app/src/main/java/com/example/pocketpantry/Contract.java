

package com.example.pocketpantry;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public interface Contract {
    interface View{}

    interface Model{
        //CRUD for recipes
        void createRecipe();
        void readRecipe();
        void updateRecipe();
        void deleteRecipe();

        //get all recipes
        void getAllRecipes();

        //CRUD for pantry items
        void createPantryItem();
        void readPantryItem();
        void updatePantryItem();
        void deletePantryItem();

        //get all pantry items
        void getAllPantryItems();
    }

    interface DatabaseModel{
        //create
        boolean addOne(String name, int quantity, float weight);
        //read
        List<PantryItem> getAll();
        //update
        void updateItem(PantryItem pantryItem);
        //delete
        void deleteItem(int _id);
    }

    interface Presenter{
        //Event handlers for recipes view
        void onClickCreateRecipe();
        void onClickReadRecipe();
        void onClickUpdateRecipe();
        void onClickDeleteRecipe();
        void showAllRecipes();

        //Event handlers for pantry view
        boolean onClickCreatePantryItem(Context context, String name, int quantity, float weight);
        void onClickReadPantryItem();
        void onClickUpdatePantryItem(Context context, PantryItem pantryItem);
        void onClickDeletePantryItem(Context context, int _id);
        ArrayList<PantryItem> showAllPantryItems(Context context);
    }
}
