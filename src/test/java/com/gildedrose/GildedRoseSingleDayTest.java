package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseSingleDayTest{

    GildedRoseTestHelper helper = new GildedRoseTestHelper();

    @Test
    void normalItemUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("foo", 9, 15);
        assertEquals("foo", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void normalExpiredItemUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("foo", 0, 15);
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void itemQualityNotNegativeTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("foo", 0, 0);
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Aged Brie", 9, 15);
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void agedBrieExpiredUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Aged Brie", 0, 15);
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);
    }

    @Test
    void agedBrieQualityNotLargerThanFiftyTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Aged Brie", 0, 50);
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurasUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePassesUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Backstage passes to a TAFKAL80ETC concert", 11, 5);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void backstagePassesUpdateQuality10DaysTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 5);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void backstagePassesUpdateQuality5DaysTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void backstagePassesExpiredUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 43);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
