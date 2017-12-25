package com.gildedrose;

public interface Visitor {

    void visit(AgedBrie agedBrie);

    void visit(Sulfuras sulfuras);

    void visit(Concert concert);

    void visit(OtherItem otherItem);

    void visit(Conjured conjured);
}
