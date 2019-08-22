package com.kinbin.kinbin.core.model;

import com.kinbin.kinbin.core.exception.CardNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private final String name;
    private boolean replenishment;
    private boolean workStage;
    private boolean queue;
    private boolean start;
    private boolean end;
    private List<Card> cards;
    private int limit;

    public Column(String name) {
        this.name = name;
        replenishment = false;
        workStage = false;
        queue = false;
        start = false;
        end = false;
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getAmountOfCards() {
        return cards.size();
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public boolean isReplenishment() {
        return replenishment;
    }

    public void setAsReplenishment() {
        replenishment = true;
    }

    public boolean isWorkStage() {
        return workStage;
    }

    public void setAsWorkStage() {
        workStage = true;
    }

    public boolean isQueue() {
        return queue;
    }

    public void setAsQueue() {
        queue = true;
    }

    public boolean isStart() {
        return start;
    }

    public void setAsStart() {
        start = true;
    }

    public boolean isEnd() {
        return end;
    }

    public void setAsEnd() {
        end = true;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(String cardId) throws CardNotFoundException {
        Card card = findCard(cardId);
        cards.remove(card);
        return card;
    }

    private Card findCard(String cardId) throws CardNotFoundException {
        return cards.stream()
                .filter(card -> card.getId().equals(cardId))
                .findFirst()
                .orElseThrow(CardNotFoundException::new);
    }
}
