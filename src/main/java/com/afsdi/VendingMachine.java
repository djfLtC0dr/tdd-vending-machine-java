package com.afsdi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private Map<String, Item> items = new HashMap<>();
    private double sales = 0;
    private double deposited = 0;
    private double cashOnHand = 10;

    public Map<String, Item> getInventory() {
        return items;
    }

    public void addItem(Item item) {
        String key = "A" + (items.size() + 1);
        items.put(key, item);
    }

    public double getSales() {
        return this.sales;
    }

    public void purchase(String code) {
        if (items.containsKey(code)) {
            if (items.get(code).getPrice() <= this.deposited) {
                this.sales += items.get(code).getPrice();
                this.deposited -= items.get(code).getPrice();
            } else {
                throw new IllegalArgumentException("Not enough deposited for this purchase");
            }
        }else {
            throw new IllegalArgumentException("Entered code is not valid");
        }
    }

    public ArrayList<String> getSalesList() {
        ArrayList<String> itemizedList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.##");
        items.forEach((k, v) -> {
            String formattedPrice = df.format(v.getPrice());
            itemizedList.add(String.format("%s - $%s", v.getItemName(), formattedPrice));
        });
        return itemizedList;
    }

    public void deposit(double deposit) {
        this.deposited += deposit;
    }

    public double getDeposited() {
        return this.deposited;
    }

    public double getChange() {
        double change = this.deposited;
        this.deposited = 0;
        return change;
    }

    public boolean canMakeChange() {
        if (this.deposited > this.cashOnHand) {
            return false;
        } else {
            return true;
        }
    }
}
