package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.AgedBrie.AGED_BRIE;
import static com.gildedrose.ItemBuilder.anItemBuilder;

public class AgedBrieTest extends GildedRoseTest {

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_with_time() {
        assertQualityOfAgedBrie(5, 10, 11);
    }

    @Test
    public void
    the_quality_of_AgedBrie_is_never_above_50() {
        assertQualityOfAgedBrie(5, 50, 50);
    }

    @Test
    public void
    the_quality_of_AgedBrie_should_increase_by_2_when_sell_date_is_less_than_zero() {
        assertQualityOfAgedBrie(0, 10, 12);
    }

    @Test
    public void
    the_sell_date_of_AgedBrie_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(5)
                        .quality(50),
                4);
    }

    private void assertQualityOfAgedBrie(int sellInDate, int quality, int expectedQuality) {
        assertQualityOfGildedRose(anItemBuilder().name(AGED_BRIE)
                        .sellInDate(sellInDate)
                        .quality(quality),
                expectedQuality);
    }
}
