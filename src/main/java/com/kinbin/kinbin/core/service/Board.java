package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.exception.CardNotFoundException;
import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.Column;
import com.kinbin.kinbin.core.model.Kinbin;

import java.util.Map;

public class Board {

    private final Kinbin kinbin;
    private final Map<String, Column> columns;

    public Board(Map<String, Column> columns, Kinbin kinbin) {
        this.columns = columns;
        this.kinbin = kinbin;
    }

    public Map<String, Column> getColumns() {
        return columns;
    }

    public Kinbin getKinbin() {
        return kinbin;
    }

    public void addNewCard(Card card, String column) {
        columns.get(column).addCard(card);
    }

    public void transition(int cardNumber, String columnFrom, String columnTo) throws CardNotFoundException {
        Card card = columns.get(columnFrom).removeCard(cardNumber);
        columns.get(columnTo).addCard(card);
    }

    public void pulse() {
        for (Column column : columns.values()) {
            if (column.isReplenishment()) {
                if (column.getCards().isEmpty()) {
                    kinbin.decreaseWeight(0.05);
                }
                if (column.getCards().size() >= column.getLimit()) {
                    kinbin.increaseWeight(0.05);
                }
            }
        }
    }
}
