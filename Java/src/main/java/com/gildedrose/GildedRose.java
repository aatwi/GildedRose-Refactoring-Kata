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

    public String printItemsAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        itemsList.forEach(item -> stringBuilder.append(item.toString()).append("\n"));
        return stringBuilder.toString().trim();
    }

    protected Item itemAt(int index) {
        return itemsList.get(index);
    }
}