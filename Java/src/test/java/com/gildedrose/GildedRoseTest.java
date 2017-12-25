package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.GildedRoseTestHelper.assertQuality;
import static com.gildedrose.GildedRoseTestHelper.assertSellInDate;
import static com.gildedrose.ItemBuilder.anItemBuilder;

public class GildedRoseTest {

    @Test
    public void
    the_quality_of_any_other_item_is_never_above_50() {
        assertQualityOfAnItem(5, 50, 49);
    }


    @Test
    public void
    the_quality_of_other_items_decreases_by_2_when_sell_date_is_less_than_zero() {
        assertQualityOfAnItem(0, 10, 8);
    }

    @Test
    public void
    the_quality_of_any_other_item_is_never_below_0() {
        assertQualityOfAnItem(0, 0, 0);
    }

    @Test
    public void
    the_sell_date_of_any_other_item_decreases_by_one() {
        assertSellInDate(anItemBuilder().name("Other Item")
                .sellInDate(5)
                .quality(50), 4);
    }

    private void assertQualityOfAnItem(int sellInDate, int quality, int expectedQuality) {
        assertQuality(anItemBuilder().name("Other Items")
                        .sellInDate(sellInDate)
                        .quality(quality),
                expectedQuality);
    }
}
