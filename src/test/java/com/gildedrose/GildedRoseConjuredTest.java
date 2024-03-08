package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseConjuredTest {

    GildedRoseTestHelper helper = new GildedRoseTestHelper();

    @Test
    void conjuredNormalItemUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured foo", 9, 15);
        assertEquals("Conjured foo", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void conjuredExpiredNormalItemUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured foo", 0, 15);
        assertEquals("Conjured foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void conjuredAgedBrieUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured Aged Brie", 9, 15);
        assertEquals("Conjured Aged Brie", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);
    }

    @Test
    void conjuredSulfurasUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals("Conjured Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void conjuredBackstagePassesUpdateQualityTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured Backstage passes to a TAFKAL80ETC concert", 11, 5);
        assertEquals("Conjured Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void conjuredBackstagePassesUpdateQuality10DaysTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured Backstage passes to a TAFKAL80ETC concert", 10, 5);
        assertEquals("Conjured Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void conjuredBackstagePassesUpdateQuality5DaysTest() {
        GildedRose app = helper.updateQualityAndGetGildedRose("Conjured Backstage passes to a TAFKAL80ETC concert", 5, 5);
        assertEquals("Conjured Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
}
