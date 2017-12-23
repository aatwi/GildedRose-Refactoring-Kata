package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.GildedRose.*;
import static org.fest.assertions.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_with_time() {
        Item[] agedBrie = new Item[]{new Item(AGED_BRIE, 5, 10)};
        GildedRose gildedRose = new GildedRose(agedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(11);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{
                new Item(SULFURAS, 5, 10),
                new Item(SULFURAS, -1, 10),
        };
        GildedRose gildedRose = new GildedRose(sulfuras);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(10);
        assertThat(gildedRose.items[1].quality).isEqualTo(10);
    }

    @Test
    public void
    the_sell_date_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item(SULFURAS, 5, 10)};
        GildedRose gildedRose = new GildedRose(sulfuras);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].sellIn).isEqualTo(5);
    }

    @Test
    public void
    the_sell_date_of_any_item_other_than_sulfuras_decreases_by_one() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 5, 50),
                new Item(CONCERT, 5, 48),
                new Item("Other Item", 5, 50)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].sellIn).isLessThanOrEqualTo(4);
        assertThat(gildedRose.items[1].sellIn).isLessThanOrEqualTo(4);
        assertThat(gildedRose.items[2].sellIn).isLessThanOrEqualTo(4);
    }

    @Test
    public void
    the_quality_of_any_item_is_never_above_50() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 5, 50),
                new Item(SULFURAS, 5, 50),
                new Item(CONCERT, 15, 50),
                new Item(CONCERT, 8, 49),
                new Item(CONCERT, 4, 48),
                new Item("Other Item", 5, 50)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[1].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[2].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[3].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[4].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[5].quality).isLessThanOrEqualTo(50);
    }

    @Test
    public void
    the_quality_of_any_item_is_never_below_0() {
        Item[] items = new Item[]{
                new Item(AGED_BRIE, 5, 0),
                new Item(SULFURAS, 5, 0),
                new Item(CONCERT, 5, 0),
                new Item("Other Item", 5, 0)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isGreaterThanOrEqualTo(0);
        assertThat(gildedRose.items[1].quality).isGreaterThanOrEqualTo(0);
        assertThat(gildedRose.items[2].quality).isGreaterThanOrEqualTo(0);
        assertThat(gildedRose.items[3].quality).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void
    the_quality_of_backstage_increase_by_2_when_sell_date_is_between_6_and_10() {
        Item[] items = new Item[]{new Item(CONCERT, 7, 5)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isGreaterThanOrEqualTo(7);
    }

    @Test
    public void
    the_quality_of_backstage_increase_by_2_when_sell_date_is_less_than_6() {
        Item[] items = new Item[]{new Item(CONCERT, 5, 5)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isGreaterThanOrEqualTo(8);
    }

    @Test
    public void
    the_quality_of_backstage_drops_to_zero_after_concert() {
        Item[] items = new Item[]{new Item(CONCERT, 0, 5)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(0);
    }

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_by_2_when_sell_date_is_less_than_zero() {
        Item[] agedBrie = new Item[]{new Item(AGED_BRIE, 0, 10)};
        GildedRose gildedRose = new GildedRose(agedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(12);
    }

    @Test
    public void
    the_quality_of_other_items_decreases_by_2_when_sell_date_is_less_than_zero() {
        Item[] agedBrie = new Item[]{new Item("Other Items", 0, 10)};
        GildedRose gildedRose = new GildedRose(agedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(8);
    }
}
