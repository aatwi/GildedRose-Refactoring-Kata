package com.gildedrose;

public abstract class ItemVisitable extends Item {
    public ItemVisitable(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    abstract void accept(Visitor visitor);
}
