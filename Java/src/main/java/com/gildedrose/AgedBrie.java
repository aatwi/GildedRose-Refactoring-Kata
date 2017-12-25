package com.gildedrose;

import static com.gildedrose.GildedRose.AGED_BRIE;

public final class AgedBrie extends Item implements Visitable {

    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
