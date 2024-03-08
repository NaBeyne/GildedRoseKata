package com.gildedrose;

public class AgedBrie extends ItemWrapper{

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQualityAndSellIn() {
        if (isQualityLowerThanMaxValue()) {
            if (isSellInDateOrLater()) {
                increaseQualityWithAmount(2);
            }
            else {
                increaseQuality();
            }
        }

        decreaseSellIn();
        correctQuality();
    }
}
