package com.gildedrose;

import static com.gildedrose.GildedRose.MAX_QUALITY;
import static com.gildedrose.GildedRose.MIN_SELL_IN_DATE;

public class ItemVisitor implements Visitor {

    @Override
    public void visit(AgedBrie agedBrie) {
        if (agedBrie.quality < MAX_QUALITY) {
            agedBrie.quality = agedBrie.quality + 1;
        }
        agedBrie.sellIn = agedBrie.sellIn - 1;

        if (agedBrie.sellIn < MIN_SELL_IN_DATE) {
            if (agedBrie.quality < MAX_QUALITY) {
                agedBrie.quality = agedBrie.quality + 1;
            }
        }
    }

    @Override
    public void visit(Sulfuras sulfuras) {

    }

    @Override
    public void visit(Concert concert) {

    }

    @Override
    public void visit(OtherItem otherItem) {

    }
}
