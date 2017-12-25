package com.gildedrose;

public final class AgedBrie extends ItemVisitable {

    protected static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
