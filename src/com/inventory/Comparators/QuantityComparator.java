package com.inventory.Comparators;



import java.util.Comparator;

import com.inventory.model.Item;

public class QuantityComparator implements Comparator<Item> {
    @Override
public int compare(Item o1, Item o2) {
    return Double.compare(o1.getQuantity(), o2.getQuantity());
}
}