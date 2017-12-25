package com.gildedrose;

import static com.gildedrose.GildedRose.CONCERT;

public final class Concert extends ItemVisitable {

    public Concert(int sellIn, int quality) {
        super(CONCERT, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
