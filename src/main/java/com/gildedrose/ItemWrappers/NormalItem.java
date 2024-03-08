package com.gildedrose.ItemWrappers;

import com.gildedrose.Item;

public class NormalItem extends ItemWrapper {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void updateQualityAndSellIn() {
        if (isQualityHigherThanMinValue()) {
            if (isSellInDateOrLater()) {
                decreaseQualityWithAmount(2);
            } else {
                decreaseQuality();
            }
        }

        decreaseSellIn();
        correctQuality();
    }
}
