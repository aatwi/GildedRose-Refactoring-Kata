package com.gildedrose;

import static org.fest.assertions.Assertions.assertThat;

public final class GildedRoseTestHelper {

    public static void assertSellInDate(ItemBuilder item, int expected) {
        Item[] items = new Item[]{item.build()};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.itemAt(0).sellIn).isEqualTo(expected);
    }

    public static void assertQuality(ItemBuilder item, int expected) {
        Item[] items = new Item[]{item.build()};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.itemAt(0).quality).isEqualTo(expected);
    }
}
