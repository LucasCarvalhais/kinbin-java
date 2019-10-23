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

    public abstract double affectWeight();



}
