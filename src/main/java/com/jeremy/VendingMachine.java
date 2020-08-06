package com.jeremy;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Item> items = new ArrayList<>();
    private double sales = 0;

    public ArrayList<Item> getInventory() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getSales() {
        return this.sales;
    }

    public void purchase(String itemName) {
        items.forEach(item -> {
            if (item.itemName == itemName) {
                this.sales += item.price;
            }
        });
    }
}
