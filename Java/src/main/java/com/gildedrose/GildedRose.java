package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public final class GildedRose {

    protected static final String AGED_BRIE = "Aged Brie";
    protected static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    protected static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;
    protected static final int MIN_SELL_IN_DATE = 0;

    private final List<ItemVisitable> itemsList = new ArrayList<>();

    public GildedRose(Item[] items) {
        for (Item item : items) {
            itemsList.add(ItemFactory.newItem(item));
        }
    }

    public void updateQuality() {
        ItemVisitor itemVisitor = new ItemVisitor();
        itemsList.forEach(item -> item.accept(itemVisitor));
    }

    public Item itemAt(int index) {
        return itemsList.get(index);
    }
}