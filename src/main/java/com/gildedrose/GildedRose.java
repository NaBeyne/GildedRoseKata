package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemWrapper wrappedItem;

            String itemName = getItemNameWithoutConjured(item);

            switch (itemName) {
                case AGED_BRIE:
                    wrappedItem = new AgedBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    wrappedItem = new BackstagePasses(item);
                    break;
                case SULFURAS:
                    wrappedItem = new Sulfuras(item);
                    break;
                default:
                    wrappedItem = new NormalItem(item);
                    break;
            }

            wrappedItem.updateQualityAndSellIn();
        }
    }

    private String getItemNameWithoutConjured(Item item) {
        if (item.name.split(" ", 2)[0].equals(CONJURED)) {
            return item.name.split(" ", 2)[1];
        }
        else {
            return item.name;
        }
    }
}
