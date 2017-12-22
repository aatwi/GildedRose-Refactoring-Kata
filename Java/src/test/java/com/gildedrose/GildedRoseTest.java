package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Ignore
    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_with_time() {
        Item[] agedBrie = new Item[]{new Item("Aged Brie", 5, 10)};
        GildedRose gildedRose = new GildedRose(agedBrie);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(11);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 10)};
        GildedRose gildedRose = new GildedRose(sulfuras);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isEqualTo(10);
    }

    @Test
    public void
    the_sell_date_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros",5, 10)};
        GildedRose gildedRose = new GildedRose(sulfuras);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].sellIn).isEqualTo(5);
    }

    @Test
    public void
    the_quality_of_any_item_is_never_above_50() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 5, 50),
                new Item("Sulfuras, Hand of Ragnaros", 5, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                new Item("Other Item", 5, 50)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[1].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[2].quality).isLessThanOrEqualTo(50);
        assertThat(gildedRose.items[3].quality).isLessThanOrEqualTo(50);
    }

    @Test
    public void
    the_quality_of_any_item_is_never_below_0() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 5, 0),
                new Item("Sulfuras, Hand of Ragnaros", 5, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0),
                new Item("Other Item", 5, 0)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0].quality).isGreaterThanOrEqualTo(0);
        assertThat(gildedRose.items[1].quality).isGreaterThanOrEqualTo(0);
        assertThat(gildedRose.items[2].quality).isGreaterThanOrEqualTo(0);
        assertThat(gildedRose.items[3].quality).isGreaterThanOrEqualTo(0);
    }

}
