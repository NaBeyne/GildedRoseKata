package com.gildedrose;

import com.gildedrose.ItemWrappers.ItemWrapper;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemWrapper wrappedItem = new ItemWrapperCreator(item).getWrappedItem();
            wrappedItem.updateQualityAndSellIn();
        }
    }
}
