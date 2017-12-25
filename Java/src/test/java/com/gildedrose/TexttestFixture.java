package com.gildedrose;

import static com.gildedrose.AgedBrie.AGED_BRIE;
import static com.gildedrose.Concert.CONCERT;
import static com.gildedrose.Conjured.CONJURED;
import static com.gildedrose.ItemBuilder.anItemBuilder;
import static com.gildedrose.Sulfuras.SULFURAS;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        GildedRose gildedRoseApp = new GildedRose(initializeItems());

        int days = args.length > 0 ? Integer.parseInt(args[0]) + 1 : 2;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            System.out.println(gildedRoseApp.printItemsAsString());
            System.out.println();
            gildedRoseApp.updateQuality();
        }
    }

    private static Item[] initializeItems() {
        return new Item[]{
                anItemBuilder().name("+5 Dexterity Vest").sellInDate(10).quality(20).build(),
                anItemBuilder().name(AGED_BRIE).sellInDate(2).quality(0).build(),
                anItemBuilder().name("Elixir of the Mongoose").sellInDate(5).quality(7).build(),
                anItemBuilder().name(SULFURAS).sellInDate(0).quality(80).build(),
                anItemBuilder().name(SULFURAS).sellInDate(-1).quality(80).build(),
                anItemBuilder().name(CONCERT).sellInDate(15).quality(20).build(),
                anItemBuilder().name(CONCERT).sellInDate(10).quality(49).build(),
                anItemBuilder().name(CONCERT).sellInDate(5).quality(49).build(),
                anItemBuilder().name(CONJURED).sellInDate(3).quality(6).build()
        };
    }

}
