package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public class ItemVisitor implements Visitor {

    @Override
    public void visit(AgedBrie agedBrie) {
        decrementSellInDate(agedBrie);

        increaseQuality(agedBrie);

        if (agedBrie.sellIn < MIN_SELL_IN_DATE) {
            increaseQuality(agedBrie);
        }
    }

    @Override
    public void visit(Sulfuras sulfuras) {
    }

    @Override
    public void visit(Concert concert) {
        increaseQuality(concert);

        if (concert.sellIn < 11) {
            increaseQuality(concert);
            if (concert.sellIn < 6) {
                increaseQuality(concert);
            }
        }

        decrementSellInDate(concert);

        if (concert.sellIn < MIN_SELL_IN_DATE) {
            concert.quality = 0;
        }
    }

    @Override
    public void visit(OtherItem otherItem) {
        if (otherItem.quality > MIN_QUALITY) {
            otherItem.quality = otherItem.quality - 1;
        }

        decrementSellInDate(otherItem);

        if (otherItem.sellIn < MIN_SELL_IN_DATE) {
            if (otherItem.quality > MIN_QUALITY) {
                otherItem.quality = otherItem.quality - 1;
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementSellInDate(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
