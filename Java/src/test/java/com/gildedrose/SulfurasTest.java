package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemBuilder.anItemBuilder;
import static com.gildedrose.Sulfuras.SULFURAS;

public class SulfurasTest extends GildedRoseTest {

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases() {
        assertQualityOfSulfuras(5, 10, 10);
    }

    @Test
    public void
    the_quality_of_Sulfuras_never_decreases_even_when_sell_date_is_over() {
        assertQualityOfSulfuras(-1, 10, 10);
    }

    @Test
    public void
    the_quality_of_Sulfuras_is_never_above_50() {
        assertQualityOfSulfuras(5, 50, 50);
    }

    @Test
    public void
    the_sell_date_of_Sulfuras_never_decreases() {
        assertSellInDateOfGildedRose(anItemBuilder().name(SULFURAS)
                        .sellInDate(5)
                        .quality(10),
                5);
    }

    private void assertQualityOfSulfuras(int sellInDate, int quality, int expectedQuality) {
        assertQualityOfGildedRose(anItemBuilder().name(SULFURAS)
                        .sellInDate(sellInDate)
                        .quality(quality),
                expectedQuality);
    }
}
