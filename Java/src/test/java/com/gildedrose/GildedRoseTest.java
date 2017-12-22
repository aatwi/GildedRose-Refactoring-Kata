package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Ignore
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_with_time() {
        Item[] agedBrie = new Item[] {new Item("Aged Brie", 5, 10)};
        GildedRose gildedRose = new GildedRose(agedBrie);
        gildedRose.updateQuality();
        assertEquals(11, gildedRose.items[0].quality);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros",5, 10)};
        GildedRose gildedRose = new GildedRose(sulfuras);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].quality);
    }

    @Test
    public void
    the_sell_date_of_Sulfuras_never_decreases() {
        Item[] sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros",5, 10)};
        GildedRose gildedRose = new GildedRose(sulfuras);
        gildedRose.updateQuality();
        assertEquals(5, gildedRose.items[0].sellIn);
    }

}
