package com.inventory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.inventory.model.Item;

public class Wishlist {
    private final Set<Item> wishlist = new HashSet<>();

    public void addToWishlist(Item item) {
        wishlist.add(item);
    }

    public void removeFromWishlist(Item item) {
        wishlist.remove(item);
    }

    public Set<Item> getWishlist() {
        return Collections.unmodifiableSet(wishlist);
    }

    public int size() {
        return wishlist.size();
    }
}
