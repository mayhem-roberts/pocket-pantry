/**********************************************************************
CONTRACT Interface
 This program uses Model View Presenter (MVP) architecture. The purpose
 of this interface is to establish how communication will occur between
 Views-Presenter as well as Presenter-Models.

 This interface contains all the abstract methods of the program. These
 methods will be implemented by the Models, Views, and Presenter
 classes.

 Models:
 DatabaseHelper, PantryItem

 Views:
 MainActivity, PantryView, PantryAddView, and PantryRecyclerView

 Presenter:
 Presenter

 To Do:
 1. The Views need to be refactored and the View interface needs to be
 built out with abstract functions.
 2. Currently, PantryRecyclerView receives an array of PantryItems
 from showAllPantryItems which is technically a breach of MVP.
 3. Functions in the Presenter interface pertaining to recipes are
 stubs.
 4. Views for Recipes need to be created
 5. DatabaseHelper's functions need to be refactored to perform
 database operations for pantry items or recipe items
**********************************************************************/

package com.example.pocketpantry;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public interface Contract {
    interface Model{
        //create new pantry items in the database
        boolean addOne(String name, int quantity, float weight);
        //get all pantry items from the database
        List<PantryItem> getAll();
        //update an item in the database
        void updateItem(PantryItem pantryItem);
        //delete a pantry item in the database
        void deleteItem(int _id);
    }

    interface View{}

    interface Presenter{
        //Event handlers for recipes view
        void onClickCreateRecipe();
        void onClickReadRecipe();
        void onClickUpdateRecipe();
        void onClickDeleteRecipe();
        void showAllRecipes();

        //Event handlers for pantry view
        boolean onClickCreatePantryItem(String name, int quantity, float weight);
        void onClickUpdatePantryItem(PantryItem pantryItem);
        void onClickDeletePantryItem(int _id);
        ArrayList<PantryItem> showAllPantryItems();
    }
}
