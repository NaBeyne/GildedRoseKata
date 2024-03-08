package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(!item.name.equals(SULFURAS)) {
                if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASSES)) {
                    if (isQualityLowerThanMaxValue(item)) {
                        increaseQuality(item);

                        if (item.name.equals(BACKSTAGE_PASSES) && isQualityLowerThanMaxValue(item)) {
                            if (item.sellIn < 11) {
                                increaseQuality(item);
                            }

                            if (item.sellIn < 6) {
                                increaseQuality(item);
                            }
                        }
                    }
                } else {
                    if (isQualityHigherThanMinValue(item)) {
                        decreaseQuality(item);
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (isExpired(item)) {
                    if (item.name.equals(AGED_BRIE)) {
                        if (isQualityLowerThanMaxValue(item)) {
                            increaseQuality(item);
                        }
                    } else {
                        if (item.name.equals(BACKSTAGE_PASSES)) {
                            item.quality = 0;
                        } else {
                            if (isQualityHigherThanMinValue(item)) {
                                decreaseQuality(item);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isQualityHigherThanMinValue(Item item) {
        return item.quality > MIN_QUALITY;
    }

    private boolean isQualityLowerThanMaxValue(Item item) {
        return item.quality < MAX_QUALITY;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }
}
