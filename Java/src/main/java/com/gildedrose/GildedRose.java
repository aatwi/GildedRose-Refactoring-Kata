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
        for (Item item : itemsList) {
            if (!item.name.equals(AGED_BRIE) && !item.name.equals(CONCERT)) {
                if (item.quality > MIN_QUALITY) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(CONCERT)) {
                        if (item.sellIn < 11) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < MIN_SELL_IN_DATE) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(CONCERT)) {
                        if (item.quality > MIN_QUALITY) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public Item itemAt(int index) {
        return itemsList.get(index);
    }
}