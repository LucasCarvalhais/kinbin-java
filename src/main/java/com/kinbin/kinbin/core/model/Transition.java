package com.kinbin.kinbin.core.model;

import java.util.Date;

public class Transition {
    private final Card card;
    private final String columnFrom;
    private final String columnTo;
    private final Date timestamp;

    public Transition(Card card, String columnFrom, String columnTo, Date timestamp) {
        this.card = card;
        this.columnFrom = columnFrom;
        this.columnTo = columnTo;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "[Card: " + card.getId() + " " + card.getCardType() + "\n" +
                "ColumnFrom: " + columnFrom + "\n" +
                "ColumnTo: " + columnTo + "\n" +
                "Timestamp: " + timestamp + "]\n";
    }
}
