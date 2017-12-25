package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.ItemBuilder.anItemBuilder;

public class AgedBrieTest extends GildedRoseTest {

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
    the_quality_of_AgedBrie_is_never_above_50() {
        assertQualityOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(5)
                        .quality(50),
                50);
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
    the_sell_date_of_AgedBrie_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(5)
                        .quality(50),
                4);
    }
}
