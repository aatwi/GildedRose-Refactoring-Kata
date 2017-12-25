package com.gildedrose;

public interface Visitor {

    public void visit(AgedBrie agedBrie);

    public void visit(Sulfuras sulfuras);

    public void visit(Concert concert);

    public void visit(OtherItem otherItem);

}
