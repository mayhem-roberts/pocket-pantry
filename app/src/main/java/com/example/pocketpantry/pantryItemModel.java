package com.example.pocketpantry;

public class pantryItemModel {
    String name;
    String quantity;
    String weight;


    public pantryItemModel(String name, String quantity, String weight) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getWeight() {
        return weight;
    }
}
