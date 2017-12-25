package com.gildedrose;

public final class Conjured extends ItemVisitable {

    protected static final String CONJURED = "Conjured Mana Cake";

    public Conjured(int sellIn, int quality) {
        super(CONJURED, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
