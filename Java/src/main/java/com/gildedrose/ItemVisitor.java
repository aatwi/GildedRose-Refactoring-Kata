package com.gildedrose;

public class ItemVisitor implements Visitor {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int MIN_SELL_IN_DATE = 0;

    @Override
    public void visit(AgedBrie agedBrie) {
        increaseQuality(agedBrie);

        decrementSellInDate(agedBrie);

        if (sellDateHasPassed(agedBrie)) {
            increaseQuality(agedBrie);
        }
    }

    @Override
    public void visit(Sulfuras sulfuras) {
    }

    @Override
    public void visit(Concert concert) {
        increaseQuality(concert);

        if (sellDateIsLessThan(concert, 11)) {
            increaseQuality(concert);
            if (sellDateIsLessThan(concert, 6)) {
                increaseQuality(concert);
            }
        }

        decrementSellInDate(concert);

        if (sellDateHasPassed(concert)) {
            concert.quality = MIN_QUALITY;
        }
    }

    @Override
    public void visit(OtherItem otherItem) {
        decrementQuality(otherItem);

        decrementSellInDate(otherItem);

        if (sellDateHasPassed(otherItem)) {
            decrementQuality(otherItem);
        }
    }

    private boolean sellDateHasPassed(Item item) {
        return sellDateIsLessThan(item, MIN_SELL_IN_DATE);
    }

    private boolean sellDateIsLessThan(Item item, int days) {
        return item.sellIn < days;
    }

    private void decrementQuality(OtherItem otherItem) {
        if (otherItem.quality > MIN_QUALITY) {
            otherItem.quality = otherItem.quality - 1;
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
