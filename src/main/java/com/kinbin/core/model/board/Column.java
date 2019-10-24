package com.kinbin.core.model.board;

import java.util.ArrayList;
import java.util.List;

public abstract class Column {

    private List<Card> cards;
    private String name;
    private int limit;

    public Column(String name) {
        this.name = name;
        cards = new ArrayList<>();
        limit = 0;
    }

    public String getName() {
        return name;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract double determineWeight();

}
