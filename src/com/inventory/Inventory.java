package com.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

import com.inventory.model.Item;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item) {
        items.put(item.getId(), item);
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public T getItem(String id) {
        return items.get(id);
    }

    public Collection<T> getAllItems() {
        return new ArrayList<>(items.values());
    }

  
}
