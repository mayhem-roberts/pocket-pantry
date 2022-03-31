/**********************************************************************
 PANTRYITEM Class
 This class is used to create an object to hold data for a pantry item
 read from the database. It can also be used to create an object to be
 updated in the database.

 To Do:
 1. Functions in the Presenter interface pertaining to recipes are
 stubs.
 2. The unit of weight needs to be decided
 **********************************************************************/
package com.example.pocketpantry;

public class PantryItem {
    //database id
    private int _id;

    //the name of the item
    private String name;

    //the quantity of the item
    private int quantity;

    //the weight of the item, unit not yet defined
    private float weight;

    //non-default constructor
    public PantryItem(int _id, String name, int quantity, float weight) {
        this._id = _id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }
    //id accessor
    public int get_id() {
        return _id;
    }

    //id mutator
    public void set_id(int _id) {
        this._id = _id;
    }

    //name accessor
    public String getName() {
        return name;
    }

    //name mutator
    public void setName(String name) {
        this.name = name;
    }

    //quantity accessor
    public int getQuantity() {
        return quantity;
    }

    //quantity mutator
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //weight accessor
    public float getWeight() {
        return weight;
    }

    //weight mutator
    public void setWeight(float weight) {
        this.weight = weight;
    }
}
