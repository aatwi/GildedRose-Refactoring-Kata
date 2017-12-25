package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemBuilder.anItemBuilder;
import static org.fest.assertions.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void
    the_quality_of_any_other_item_is_never_above_50() {
        assertQualityOfGildedRose(anItemBuilder().name("Other Item")
                        .sellInDate(5)
                        .quality(50),
                49);
    }

    @Test
    public void
    the_quality_of_other_items_decreases_by_2_when_sell_date_is_less_than_zero() {
        assertQualityOfGildedRose(anItemBuilder().name("Other Items")
                        .sellInDate(0)
                        .quality(10),
                8);
    }

    @Test
    public void
    the_quality_of_any_other_item_is_never_below_0() {
        assertQualityOfGildedRose(anItemBuilder().name("Other Item")
                        .sellInDate(0)
                        .quality(0),
                0);
    }


    @Test
    public void
    the_sell_date_of_any_other_item_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name("Other Item")
                        .sellInDate(5)
                        .quality(50),
                4);
    }

    void assertSellInDateOfGildedRose(ItemBuilder item, int expected) {
        Item[] items = new Item[]{item.build()};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.itemAt(0).sellIn).isEqualTo(expected);
    }

    void assertQualityOfGildedRose(ItemBuilder item, int expected) {
        Item[] items = new Item[]{item.build()};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.itemAt(0).quality).isEqualTo(expected);
    }

}
