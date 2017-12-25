package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Conjured.CONJURED;
import static com.gildedrose.ItemBuilder.anItemBuilder;

public class ConjuredTest {

    @Test
    public void
    the_quality_of_conjured_decreases_twice_as_fast() {
        assertQualityOfConjured(4, 10, 8);
    }

    @Test
    public void
    the_quality_of_conjured_decreases_4_times_after_the_sell_date_is_passed() {
        assertQualityOfConjured(0, 10, 6);
    }

    @Test
    public void
    the_quality_of_conjured_is_never_below_0() {
        assertQualityOfConjured(0, 1, 0);
    }

    @Test
    public void
    the_sell_date_of_Conjured_decreases_by_one() {
        GildedRoseTestHelper.assertSellInDate(anItemBuilder().name(CONJURED)
                .sellInDate(5)
                .quality(50), 4);
    }

    private void assertQualityOfConjured(int sellInDate, int quality, int expectedQuality) {
        GildedRoseTestHelper.assertQuality(anItemBuilder().name(CONJURED)
                .sellInDate(sellInDate)
                .quality(quality), expectedQuality);
    }
}
