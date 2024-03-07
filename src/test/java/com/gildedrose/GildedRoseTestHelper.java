package com.gildedrose;

class GildedRoseTestHelper {
    GildedRose updateQualityAndGetGildedRose(String itemName, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }
}
