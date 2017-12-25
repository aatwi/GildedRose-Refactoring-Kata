package com.gildedrose;

public final class OtherItem extends Item implements Visitable {

    public OtherItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
