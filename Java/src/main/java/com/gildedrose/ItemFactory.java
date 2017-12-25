package com.gildedrose;

public final class ItemFactory {

    public static ItemVisitable newItem(Item item) {
        if (item.name.equals(Concert.CONCERT)) {
            return new Concert(item.sellIn, item.quality);
        } else if (item.name.equals(AgedBrie.AGED_BRIE)) {
            return new AgedBrie(item.sellIn, item.quality);
        } else if (item.name.equals(Sulfuras.SULFURAS)) {
            return new Sulfuras(item.sellIn, item.quality);
        } else if (item.name.equals(Conjured.CONJURED)) {
            return new Conjured(item.sellIn, item.quality);
        }
        return new OtherItem(item.name, item.sellIn, item.quality);
    }
}
