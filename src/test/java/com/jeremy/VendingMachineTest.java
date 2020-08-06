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
    public void addItemChangesInventory(){
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
}
