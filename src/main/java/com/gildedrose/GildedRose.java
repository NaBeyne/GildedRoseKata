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
            if (!item.name.equals(SULFURAS)) {
                if (item.name.equals(AGED_BRIE)) {
                    if (isQualityLowerThanMaxValue(item)) {
                        if (isSellInDateOrLater(item)) {
                            increaseQualityWithAmount(item, 2);
                        }
                        else {
                            increaseQuality(item);
                        }
                    }
                }
                else if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (isSellInDateOrLater(item)) {
                        item.quality = 0;
                    }
                    else if (isQualityLowerThanMaxValue(item)) {
                        if (item.sellIn > 10) {
                            increaseQuality(item);
                        }
                        else if (item.sellIn > 5) {
                            increaseQualityWithAmount(item, 2);
                        }
                        else {
                            increaseQualityWithAmount(item, 3);
                        }
                    }
                }
                else {
                    if (isQualityHigherThanMinValue(item)) {
                        if (isSellInDateOrLater(item)) {
                            decreaseQualityAmount(item, 2);
                        }
                        else {
                            decreaseQuality(item);
                        }
                    }
                }

                correctQuality(item);

                item.sellIn--;
            }
        }
    }

    private boolean isQualityHigherThanMinValue(Item item) {
        return item.quality > MIN_QUALITY;
    }

    private boolean isQualityLowerThanMaxValue(Item item) {
        return item.quality < MAX_QUALITY;
    }

    private boolean isSellInDateOrLater(Item item) {
        return item.sellIn <= 0;
    }

    private void increaseQuality(Item item) {
        increaseQualityWithAmount(item, 1);
    }

    private void increaseQualityWithAmount(Item item, int amount) {
        item.quality += amount;
    }

    private void decreaseQuality(Item item) {
        decreaseQualityAmount(item, 1);
    }

    private void decreaseQualityAmount(Item item, int amount) {
        item.quality -= amount;
    }

    private void correctQuality(Item item) {
        if(item.quality > 50) {
            item.quality = 50;
        }
        else if(item.quality < 0) {
            item.quality = 0;
        }
    }
}
