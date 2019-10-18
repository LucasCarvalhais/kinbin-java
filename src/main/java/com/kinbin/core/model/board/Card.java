package com.kinbin.core.model.board;

public class Card {

    private final String id;
    private final CardType cardType;

    public Card(String id, CardType cardType) {
        this.id = id;
        this.cardType = cardType;
    }

    public String getId() {
        return id;
    }

    public CardType getCardType() {
        return cardType;
    }
}
