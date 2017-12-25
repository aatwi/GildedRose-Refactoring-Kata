package com.gildedrose;

public final class Sulfuras extends ItemVisitable {

    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(SULFURAS, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
