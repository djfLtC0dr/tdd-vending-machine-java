package com.jeremy;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Item> items = new ArrayList<>();
    private double sales = 0;
    private double deposited = 0;

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

    public ArrayList<String> getSalesList() {
        ArrayList<String> itemizedList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.##");
        for (Item item : items) {
            String formattedPrice = df.format(item.getPrice());
            itemizedList.add(String.format("%s - $%s", item.getItemName(), formattedPrice));
        }
        return itemizedList;
    }

    public void deposit(double deposit) {
        this.deposited += deposit;
    }

    public double getDeposited() {
        return this.deposited;
    }
}
