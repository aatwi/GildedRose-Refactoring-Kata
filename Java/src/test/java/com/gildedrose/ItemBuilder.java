package com.gildedrose;

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

    public ItemVisitable build() {
        return ItemFactory.newItem(new Item(name, sellInDate, quality));
    }
}
