package com.inventory.Comparators;

import java.util.Comparator;

import com.inventory.model.Item;

public class PriceComparator implements Comparator<Item> {
        @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
