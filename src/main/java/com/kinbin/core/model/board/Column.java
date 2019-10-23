package com.kinbin.core.model.board;

import java.util.List;

public abstract class Column {

    protected List<Card> cards;
    private String name;

    public Column(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract double affectWeight();

}
