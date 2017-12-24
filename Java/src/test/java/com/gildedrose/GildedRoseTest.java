package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.GildedRose.*;
import static org.fest.assertions.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_with_time() {
        Item[] agedBrie = new Item[]{new Item(AGED_BRIE, 5, 10)};
        assertQualityOfGildedRose(agedBrie, 11);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item(SULFURAS, 5, 10)};
        assertQualityOfGildedRose(sulfuras, 10);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases_even_when_sell_date_is_over() {
        Item[] sulfuras = new Item[]{new Item(SULFURAS, -1, 10)};
        assertQualityOfGildedRose(sulfuras, 10);
    }

    @Test
    public void
    the_quality_of_AgedBrie_is_never_above_50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 5, 50)};
        assertQualityOfGildedRose(items, 50);
    }

    @Test
    public void
    the_quality_of_Sulfuras_is_never_above_50() {
        Item[] items = new Item[]{new Item(SULFURAS, 5, 50)};
        assertQualityOfGildedRose(items, 50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_greater_than_11() {
        Item[] items = new Item[]{new Item(CONCERT, 15, 50)};
        assertQualityOfGildedRose(items, 50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_between_6_and_11() {
        Item[] items = new Item[]{new Item(CONCERT, 10, 49)};
        assertQualityOfGildedRose(items, 50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_between_0_and_6() {
        Item[] items = new Item[]{new Item(CONCERT, 4, 48)};
        assertQualityOfGildedRose(items, 50);
    }

    @Test
    public void
    the_quality_of_any_other_item_is_never_above_50() {
        Item[] items = new Item[]{new Item("Other Item", 5, 50)};
        assertQualityOfGildedRose(items, 49);
    }

    @Test
    public void
    the_quality_of_backstage_increase_by_2_when_sell_date_is_between_6_and_10() {
        Item[] items = new Item[]{new Item(CONCERT, 7, 5)};
        assertQualityOfGildedRose(items, 7);
    }

    @Test
    public void
    the_quality_of_backstage_increases_by_3_when_sell_date_is_between_0_and_6() {
        Item[] items = new Item[]{new Item(CONCERT, 5, 5)};
        assertQualityOfGildedRose(items, 8);
    }

    @Test
    public void
    the_quality_of_backstage_drops_to_zero_after_concert() {
        Item[] items = new Item[]{new Item(CONCERT, 0, 5)};
        assertQualityOfGildedRose(items, 0);
    }

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_by_2_when_sell_date_is_less_than_zero() {
        Item[] agedBrie = new Item[]{new Item(AGED_BRIE, 0, 10)};
        assertQualityOfGildedRose(agedBrie, 12);
    }

    @Test
    public void
    the_quality_of_other_items_decreases_by_2_when_sell_date_is_less_than_zero() {
        Item[] agedBrie = new Item[]{new Item("Other Items", 0, 10)};
        assertQualityOfGildedRose(agedBrie, 8);
    }

    @Test
    public void
    the_quality_of_any_other_item_is_never_below_0() {
        Item[] items = new Item[]{new Item("Other Item", 0, 0)};
        assertQualityOfGildedRose(items, 0);
    }

    @Test
    public void
    the_sell_date_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item(SULFURAS, 5, 10)};
        assertSellInDateOfGildedRose(sulfuras, 5);
    }

    @Test
    public void
    the_sell_date_of_AgedBrie_decreases_by_one() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 5, 50)};
        assertSellInDateOfGildedRose(items, 4);
    }

    @Test
    public void
    the_sell_date_of_Concert_decreases_by_one() {
        Item[] items = new Item[]{new Item(CONCERT, 5, 50)};
        assertSellInDateOfGildedRose(items, 4);
    }

    @Test
    public void
    the_sell_date_of_any_other_item_decreases_by_one() {
        Item[] items = new Item[]{new Item("Other Item", 5, 50)};
        assertSellInDateOfGildedRose(items, 4);
    }

    private void assertSellInDateOfGildedRose(Item[] items, int expected) {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].sellIn).isEqualTo(expected);
    }

    private void assertQualityOfGildedRose(Item[] items, int expected) {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(expected);
    }
}
