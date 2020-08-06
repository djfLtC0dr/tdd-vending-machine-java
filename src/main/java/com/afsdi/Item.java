package com.afsdi;

public class Item {
    String itemName = "";
    double price = 0.0;

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }
}
