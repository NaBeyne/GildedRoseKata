package com.gildedrose.ItemWrappers;

import com.gildedrose.Item;

public class Sulfuras extends ItemWrapper {

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void updateQualityAndSellIn() {
        // Quality and sellin of Sulfuras never change
    }
}
