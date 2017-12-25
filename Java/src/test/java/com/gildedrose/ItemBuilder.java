package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public class ItemBuilder {

    private String name;
    private int sellInDate;
    private int quality;

    public static ItemBuilder anItemBuilder() {
        return new ItemBuilder();
    }

    public ItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder sellInDate(int sellInDate) {
        this.sellInDate = sellInDate;
        return this;
    }

    public ItemBuilder quality(int quality) {
        this.quality = quality;
        return this;
    }

    public Item build() {
        if (name.equals(CONCERT)) {
            return new Concert(sellInDate, quality);
        } else if (name.equals(AGED_BRIE)) {
            return new AgedBrie(sellInDate, quality);
        } else if (name.equals(SULFURAS)) {
            return new Sulfuras(sellInDate, quality);
        }
        return new OtherItem(name, sellInDate, quality);
    }
}
