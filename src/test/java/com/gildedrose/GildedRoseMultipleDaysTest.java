package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseMultipleDaysTest {

    @Test
    void multipleUpdateQualityTest() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 10, 36)
        };

        test5Days(items);
        test10Days(items);
        test15Days(items);
    }

    void updateQuality5DaysAndCompareToGivenItems(Item[] itemsToCompare, GildedRose app) {
        for (int i = 0; i < 5; i++) {
            app.updateQuality();
        }

        for (int i = 0; i < app.items.length; i++) {
            assertEquals(itemsToCompare[i].sellIn, app.items[i].sellIn);
            assertEquals(itemsToCompare[i].quality, app.items[i].quality);
        }
    }

    void test5Days(Item[] items) {
        Item[] itemsAfter5Days = new Item[]{
            new Item("+5 Dexterity Vest", 5, 15),
            new Item("Aged Brie", -3, 8),
            new Item("Elixir of the Mongoose", 0, 2),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
            new Item("Conjured Mana Cake", 5, 26)
        };

        updateQuality5DaysAndCompareToGivenItems(itemsAfter5Days, new GildedRose(items));
    }

    void test10Days(Item[] items) {
        Item[] itemsAfter10Days = new Item[]{
            new Item("+5 Dexterity Vest", 0, 10),
            new Item("Aged Brie", -8, 18),
            new Item("Elixir of the Mongoose", -5, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", -5, 0),
            new Item("Conjured Mana Cake", 0, 16)
        };

        updateQuality5DaysAndCompareToGivenItems(itemsAfter10Days, new GildedRose(items));
    }

    void test15Days(Item[] items) {
        Item[] itemsAfter15Days = new Item[]{
            new Item("+5 Dexterity Vest", -5, 0),
            new Item("Aged Brie", -13, 28),
            new Item("Elixir of the Mongoose", -10, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", -5, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", -10, 0),
            new Item("Conjured Mana Cake", -5, 0)
        };

        updateQuality5DaysAndCompareToGivenItems(itemsAfter15Days, new GildedRose(items));
    }
}
