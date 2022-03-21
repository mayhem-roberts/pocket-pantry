/**********************************************************************
CONTRACT Interface
This interface contains all the methods to be implemented by the
 Model, View, and Presenter classes.

 TO DO:
 1. These functions all still need their return types and parameters
 finalized. What will each function return and what data will they be
 receiving?

 This information will come from four sources:
    -the text API that will give the user a drop down list of items
     for selecting pantry items
    -the Shared Preferences contract
    -the front-end contract

 2. Will we need any other methods?
**********************************************************************/

package com.example.pocketpantry;

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
        public List<PantryItem> getAll();
        public boolean addOne(String name, int quantity, float weight);
    }

    interface Presenter{
        //Event handlers for recipes view
        void onClickCreateRecipe();
        void onClickReadRecipe();
        void onClickUpdateRecipe();
        void onClickDeleteRecipe();
        void showAllRecipes();

        //Event handlers for pantry view
        void onClickCreatePantryItem();
        void onClickReadPantryItem();
        void onClickUpdatePantryItem();
        void onClickDeletePantryItem();
        void showAllPantryItems();
    }
}
