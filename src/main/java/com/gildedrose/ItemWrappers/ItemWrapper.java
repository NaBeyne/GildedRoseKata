package com.gildedrose.ItemWrappers;

import com.gildedrose.Item;

import static com.gildedrose.ItemWrapperCreator.CONJURED;

public abstract class ItemWrapper {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    final Item item;
    int conjuredMultiplier = 1;

    protected ItemWrapper(Item item) {
        this.item = item;

        if (item.name.split(" ")[0].equals(CONJURED)) {
            this.conjuredMultiplier = 2;
        }
    }

    boolean isQualityHigherThanMinValue() {
        return item.quality > MIN_QUALITY;
    }

    boolean isQualityLowerThanMaxValue() {
        return item.quality < MAX_QUALITY;
    }

    boolean isSellInDateOrLater() {
        return item.sellIn <= 0;
    }

    void increaseQuality() {
        increaseQualityWithAmount(1);
    }

    void increaseQualityWithAmount(int amount) {
        item.quality += (conjuredMultiplier * amount);
    }

    void decreaseQuality() {
        decreaseQualityWithAmount(1);
    }

    void decreaseQualityWithAmount(int amount) {
        item.quality -= (conjuredMultiplier * amount);
    }

    void decreaseSellIn() {
        item.sellIn--;
    }

    void correctQuality() {
        if (item.quality > 50) {
            item.quality = 50;
        } else if (item.quality < 0) {
            item.quality = 0;
        }
    }

    public abstract void updateQualityAndSellIn();
}
