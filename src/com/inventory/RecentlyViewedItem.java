package com.inventory;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


import com.inventory.model.Item;

public class RecentlyViewedItem<T extends Item> {
    private static final int MAX_RECENTLY_VIEWED = 10;
    private LinkedList<Item> recentlyViewed;

    RecentlyViewedItem() {
        this.recentlyViewed = new LinkedList<>();
    }

      /**
     * Newest at front (addFirst). Oldest at back.
     * Caps at 10 via removeLast.
     */
      public void addRecentlyViewedItem(Item item) {
        recentlyViewed.remove(item); // avoid dupes if viewed again
        recentlyViewed.addFirst(item);
        if (recentlyViewed.size() > MAX_RECENTLY_VIEWED) {
            recentlyViewed.removeLast(); // drop oldest
        }
    }

    public List<Item> getRecentlyViewedItems() {
        return new ArrayList<>(recentlyViewed);
    }
}
