package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Concert.CONCERT;
import static com.gildedrose.ItemBuilder.anItemBuilder;

public class ConcertTest extends GildedRoseTest {

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_greater_than_11() {
        assertQualityOfConcert(15, 50, 50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_between_6_and_11() {
        assertQualityOfConcert(10, 49, 50);
    }

    @Test
    public void
    the_quality_of_Concert_is_never_above_50_when_sell_date_is_between_0_and_6() {
        assertQualityOfConcert(4, 48, 50);
    }

    @Test
    public void
    the_quality_of_backstage_increase_by_2_when_sell_date_is_between_6_and_10() {
        assertQualityOfConcert(7, 5, 7);
    }

    @Test
    public void
    the_quality_of_backstage_increases_by_3_when_sell_date_is_between_0_and_6() {
        assertQualityOfConcert(5, 5, 8);
    }

    @Test
    public void
    the_quality_of_backstage_drops_to_zero_after_concert() {
        assertQualityOfConcert(0, 5, 0);
    }

    @Test
    public void
    the_sell_date_of_Concert_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(5)
                        .quality(50),
                4);
    }

    private void assertQualityOfConcert(int sellInDate, int quality, int expectedQuality) {
        assertQualityOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(sellInDate)
                        .quality(quality),
                expectedQuality);
    }
}
