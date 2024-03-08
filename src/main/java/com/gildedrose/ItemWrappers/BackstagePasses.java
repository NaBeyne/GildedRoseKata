package com.gildedrose.ItemWrappers;

import com.gildedrose.Item;

public class BackstagePasses extends ItemWrapper {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQualityAndSellIn() {
        if (isSellInDateOrLater()) {
            item.quality = 0;
        } else if (isQualityLowerThanMaxValue()) {
            if (sellInMoreThan10Days()) {
                increaseQuality();
            } else if (sellInMoreThan5Days()) {
                increaseQualityWithAmount(2);
            } else {
                increaseQualityWithAmount(3);
            }
        }

        decreaseSellIn();
        correctQuality();
    }

    private boolean sellInMoreThan10Days() {
        return item.sellIn > 10;
    }

    private boolean sellInMoreThan5Days() {
        return item.sellIn > 5;
    }
}
