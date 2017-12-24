package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.GildedRose.*;
import static com.gildedrose.ItemBuilder.anItemBuilder;
import static org.fest.assertions.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_with_time() {
        assertQualityOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(5)
                        .quality(10),
                11);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases() {
        assertQualityOfGildedRose(anItemBuilder().name(SULFURAS)
                        .sellInDate(5)
                        .quality(10),
                10);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases_even_when_sell_date_is_over() {
        assertQualityOfGildedRose(anItemBuilder().name(SULFURAS)
                        .sellInDate(-1)
                        .quality(10),
                10);
    }

    @Test
    public void
    the_quality_of_AgedBrie_is_never_above_50() {
        assertQualityOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(5)
                        .quality(50),
                50);
    }

    @Test
    public void
    the_quality_of_Sulfuras_is_never_above_50() {
        assertQualityOfGildedRose(anItemBuilder().name(SULFURAS)
                        .sellInDate(5)
                        .quality(50),
                50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_greater_than_11() {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(15)
                        .quality(50),
                50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_between_6_and_11() {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(10)
                        .quality(49),
                50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_between_0_and_6() {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(4)
                        .quality(48),
                50);
    }

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
    the_quality_of_backstage_increase_by_2_when_sell_date_is_between_6_and_10() {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(7)
                        .quality(5),
                7);
    }

    @Test
    public void
    the_quality_of_backstage_increases_by_3_when_sell_date_is_between_0_and_6() {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(5)
                        .quality(5),
                8);
    }

    @Test
    public void
    the_quality_of_backstage_drops_to_zero_after_concert() {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(0)
                        .quality(5),
                0);
    }

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_by_2_when_sell_date_is_less_than_zero() {
        assertQualityOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(0)
                        .quality(10),
                12);
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
    the_sell_date_of_Sulfuras_never_decreases() {
        assertSellInDateOfGildedRose(anItemBuilder().name(SULFURAS)
                        .sellInDate(5)
                        .quality(10),
                5);
    }

    @Test
    public void
    the_sell_date_of_AgedBrie_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(5)
                        .quality(50),
                4);
    }

    @Test
    public void
    the_sell_date_of_Concert_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(5)
                        .quality(50),
                4);
    }

    @Test
    public void
    the_sell_date_of_any_other_item_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name("Other Item")
                        .sellInDate(5)
                        .quality(50),
                4);
    }

    private void assertSellInDateOfGildedRose(ItemBuilder item, int expected) {
        Item[] items = new Item[]{item.build()};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.itemAt(0).sellIn).isEqualTo(expected);
    }

    private void assertQualityOfGildedRose(ItemBuilder item, int expected) {
        Item[] items = new Item[]{item.build()};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.itemAt(0).quality).isEqualTo(expected);
    }

}
