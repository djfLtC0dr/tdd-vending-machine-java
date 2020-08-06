package com.afsdi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendingMachineTest {
    @Test
    public void getCurrentStockShowsEmptyByDefault(){
        //Setup
        VendingMachine vendingMachine = new VendingMachine();

        //Execution
        Map<String, Item> expected = new HashMap<>();
        Map<String, Item> actual = vendingMachine.getInventory();

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
        Map<String, Item> expected = new HashMap<>();
        expected.put("A1", item1);
        Map<String, Item> actual = vendingMachine.getInventory();

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
        vendingMachine.deposit(1);

        //Execution
        Item item1 = new Item("Doritos", 0.75);
        vendingMachine.addItem(item1);
        vendingMachine.purchase("A1");
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
        double expected = 1.5;
        double actual = vendingMachine.getDeposited();

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void throwsExceptionForInvalidCodeForPurchase() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();
        String expected = "Entered code is not valid";

        //Execution
        Exception actual = assertThrows(IllegalArgumentException.class, () -> vendingMachine.purchase(("A5")));

        //Assertion
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void throwsExceptionForInsufficientFundsForPurchase() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();
        String expected = "Not enough deposited for this purchase";
        vendingMachine.deposit(0.5);
        Item item1 = new Item("Doritos", 0.75);
        vendingMachine.addItem(item1);

        //Execution
        Exception actual = assertThrows(IllegalArgumentException.class, () -> vendingMachine.purchase(("A1")));

        //Assertion
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void getChangeWhenSalesComplete() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.deposit(1);

        //Execution
        Item item1 = new Item("Doritos", 0.75);
        vendingMachine.addItem(item1);
        vendingMachine.purchase("A1");
        double expected = 0.25;
        double actual = vendingMachine.getChange();

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void machineCannotMakeChange() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.deposit(20);

        //Execution
        boolean expected = false;
        boolean actual = vendingMachine.canMakeChange();

        //Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void machineCanMakeChange() {
        //Setup
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.deposit(5);

        //Execution
        boolean expected = true;
        boolean actual = vendingMachine.canMakeChange();

        //Assertion
        assertEquals(expected, actual);
    }
}
