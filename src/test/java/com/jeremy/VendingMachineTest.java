package com.jeremy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {
    @Test
    public void getCurrentStockShowsEmptyByDefault(){
        //Setup
        VendingMachine vendingMachine = new VendingMachine();

        //Execution
        ArrayList<Item> expected = new ArrayList<>();
        ArrayList<Item> actual = vendingMachine.getInventory();

        //Assertions
        assertEquals(expected, actual);
    }

    @Test
    public void addItemChangesInventory() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();

        //Execution
        Item item1 = new Item("Doritos", 0.75);
        vendingMachine.addItem(item1);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        ArrayList<Item> actual = vendingMachine.getInventory();

        //Assertions
        assertEquals(expected, actual);
    }

    @Test
    public void getSalesReturnsZeroByDefault() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();

        //Execution
        double expected = 0;
        double actual = vendingMachine.getSales();

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void getSalesWhenItemsPurchased() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();

        //Execution
        Item item1 = new Item("Doritos", 0.75);
        vendingMachine.addItem(item1);
        vendingMachine.purchase("Doritos");
        double expected = 0.75;
        double actual = vendingMachine.getSales();

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void getListOfItemsForSale() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();
        Item item1 = new Item("Doritos", 0.75);
        Item item2 = new Item("Coke", 1.00);
        vendingMachine.addItem(item1);
        vendingMachine.addItem(item2);

        //Execution
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Doritos - $0.75", "Coke - $1"));
        ArrayList<String> actual = vendingMachine.getSalesList();
        System.out.println(actual);

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void getDepositedMoney() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();

        //Execution
        vendingMachine.deposit(1);
        vendingMachine.deposit(0.5);
        double expected = 1.50;
        double actual = vendingMachine.getDeposited();

        //Assertion
        assertEquals(expected, actual);
    }
}
