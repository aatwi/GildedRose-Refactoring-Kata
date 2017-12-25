package com.gildedrose;

import static com.gildedrose.GildedRose.SULFURAS;

public final class Sulfuras extends Item implements Visitable {

    public Sulfuras(int sellIn, int quality) {
        super(SULFURAS, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
