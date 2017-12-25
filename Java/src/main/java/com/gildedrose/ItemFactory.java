package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public final class ItemFactory {

    public static ItemVisitable newItem(Item item) {
        if (item.name.equals(CONCERT)) {
            return new Concert(item.sellIn, item.quality);
        } else if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie(item.sellIn, item.quality);
        } else if (item.name.equals(SULFURAS)) {
            return new Sulfuras(item.sellIn, item.quality);
        }
        return new OtherItem(item.name, item.sellIn, item.quality);
    }
}
