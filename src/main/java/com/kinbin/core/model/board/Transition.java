package com.kinbin.core.model.board;

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

    public Card getCard() {
        return card;
    }

    public String getColumnFrom() {
        return columnFrom;
    }

    public String getColumnTo() {
        return columnTo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[Card: " + card.getId() + " " + card.getCardType() + "\n" +
                "ColumnFrom: " + columnFrom + "\n" +
                "ColumnTo: " + columnTo + "\n" +
                "Timestamp: " + timestamp + "]\n";
    }
}
