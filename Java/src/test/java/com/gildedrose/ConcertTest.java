package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Concert.CONCERT;
import static com.gildedrose.ItemBuilder.anItemBuilder;

public class ConcertTest extends GildedRoseTest {

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
    the_sell_date_of_Concert_decreases_by_one() {
        assertSellInDateOfGildedRose(anItemBuilder().name(CONCERT)
                        .sellInDate(5)
                        .quality(50),
                4);
    }
}
