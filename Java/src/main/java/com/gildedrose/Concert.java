package com.gildedrose;

public final class Concert extends ItemVisitable {

    protected static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public Concert(int sellIn, int quality) {
        super(CONCERT, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
