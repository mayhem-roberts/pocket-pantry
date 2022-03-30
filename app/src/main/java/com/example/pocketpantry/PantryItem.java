package com.example.pocketpantry;

public class PantryItem {

    private int _id;
    private String name;
    private int quantity;
    private float weight;

    public PantryItem(int _id, String name, int quantity, float weight) {
        this._id = _id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
