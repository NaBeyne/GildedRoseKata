package com.gildedrose;

import com.gildedrose.ItemWrappers.*;

public class ItemWrapperCreator {

    public static final String CONJURED = "Conjured";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final Item item;

    public ItemWrapperCreator(Item item) {
        this.item = item;
    }

    public ItemWrapper getWrappedItem() {
        String itemName = getItemNameWithoutConjured(item);

        switch (itemName) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            case SULFURAS:
                return new Sulfuras(item);
            default:
                return new NormalItem(item);
        }
    }

    private String getItemNameWithoutConjured(Item item) {
        if (item.name.split(" ", 2)[0].equals(CONJURED)) {
            return item.name.split(" ", 2)[1];
        } else {
            return item.name;
        }
    }
}
