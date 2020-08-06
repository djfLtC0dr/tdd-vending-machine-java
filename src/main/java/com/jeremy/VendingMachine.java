package com.jeremy;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getInventory() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
