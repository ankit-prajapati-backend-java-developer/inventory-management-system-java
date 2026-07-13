package com.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inventory.Comparators.PriceComparator;
import com.inventory.Comparators.QuantityComparator;
import com.inventory.model.Book;
import com.inventory.model.Clothing;
import com.inventory.model.Electronics;
import com.inventory.model.Item;

public class Main {
    public static void main(String[] args) {
        Electronics e1 = new Electronics("E1", "Laptop", 55000, 5, 24);
        Electronics e2 = new Electronics("E2", "Phone", 25000, 10, 12);
        Electronics e3 = new Electronics("E3", "Tablet", 15000, 15, 8);

        Clothing c1 = new Clothing("C1", "Jeans", 1200, 20, "L");
        Clothing c2 = new Clothing("C2", "T-shirt", 500, 30, "M");

        Book b1 = new Book("B1", "Clean Code", 800, 15, "Robert Martin");
        Book b2 = new Book("B2", "Effective Java", 900, 8, "Joshua Bloch");

        List<Item> items = new ArrayList<>();
        items.add(e1);
        items.add(e2);
        items.add(c1);
        items.add(c2);
        items.add(b1);
        items.add(b2);

        Collections.sort(items);

        for (Item item : items) {
            System.out.println(item);
        }

        System.out.println("--------------------------------");

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        electronicsInventory.addItem(e1);
        electronicsInventory.addItem(e2);
        electronicsInventory.addItem(e3);
        System.out.println("Get Item of id E1: " + electronicsInventory.getItem("E1"));
        System.out.println("Get All Items: " + electronicsInventory.getAllItems());

        electronicsInventory.removeItem("E1");
        System.out.println("Get All Items after removing E1: " + electronicsInventory.getAllItems());

        System.out.println("--------------------------------");
        System.out.println("Recently Viewed (max 10):");
        System.out.println("--------------------------------");

        RecentlyViewedItem<Item> inventory = new RecentlyViewedItem<>();

        // 12 items — oldest 2 should drop off
        Item[] viewed = {
            new Electronics("V1", "View-1", 100, 1, 6),
            new Electronics("V2", "View-2", 200, 1, 6),
            new Electronics("V3", "View-3", 300, 1, 6),
            new Clothing("V4", "View-4", 400, 1, "S"),
            new Clothing("V5", "View-5", 500, 1, "M"),
            new Clothing("V6", "View-6", 600, 1, "L"),
            new Book("V7", "View-7", 700, 1, "Author A"),
            new Book("V8", "View-8", 800, 1, "Author B"),
            new Book("V9", "View-9", 900, 1, "Author C"),
            new Electronics("V10", "View-10", 1000, 1, 12),
            new Electronics("V11", "View-11", 1100, 1, 12),
            new Electronics("V12", "View-12", 1200, 1, 12)
        };

        for (Item item : viewed) {
            inventory.addRecentlyViewedItem(item);
        }

        List<Item> recent = inventory.getRecentlyViewedItems();
        System.out.println("Size: " + recent.size()); // expect 10
        for (Item item : recent) {
            System.out.println(item.getName());
        }
        // expect View-12 ... View-3 (newest first); View-1 and View-2 removed

        System.out.println("--------------------------------");

        Order order = new Order();
        order.addOrder(new Order("O1", true));
        order.addOrder(new Order("O2", false));
        order.addOrder(new Order("O3", true));
        order.processOrder();
        System.out.println("Remaining orders: " + order.getOrderPriorityQueueSize());
        Order next = order.getOrderPriorityQueue().peek();
        System.out.println("Next up: " + next.getOrderId() + " express=" + next.isExpress());

        System.out.println("--------------------------------");
        System.out.println("Sorting & Filtering:");
        System.out.println("--------------------------------");

        Inventory<Item> allInventory = new Inventory<>();
        allInventory.addItem(e1);
        allInventory.addItem(e2);
        allInventory.addItem(e3);
        allInventory.addItem(c1);
        allInventory.addItem(c2);
        allInventory.addItem(b1);
        allInventory.addItem(b2);
        allInventory.addItem(new Electronics("E4", "Out of stock cable", 200, 0, 6));

        List<Item> byPrice = new ArrayList<>(allInventory.getAllItems());
        byPrice.sort(new PriceComparator());
        System.out.println("Sorted by price:");
        byPrice.forEach(System.out::println);

        List<Item> byQty = new ArrayList<>(allInventory.getAllItems());
        byQty.sort(new QuantityComparator());
        System.out.println("Sorted by quantity:");
        byQty.forEach(System.out::println);

        System.out.println("Price range 500–2000:");
        allInventory.filterByPriceRange(500, 2000).forEach(System.out::println);

        System.out.println("Available (qty > 0):");
        allInventory.filterByAvailability().forEach(System.out::println);
    }
}
