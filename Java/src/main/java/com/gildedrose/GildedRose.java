package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public final class GildedRose {

    private final List<ItemVisitable> itemsList = new ArrayList<>();

    public GildedRose(Item[] items) {
        for (Item item : items) {
            itemsList.add(ItemFactory.newItem(item));
        }
    }

    public void updateQuality() {
        ItemVisitor itemVisitor = new ItemVisitor();
        itemsList.forEach(item -> item.accept(itemVisitor));
    }

    public Item itemAt(int index) {
        return itemsList.get(index);
    }
}