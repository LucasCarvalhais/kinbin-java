package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.exception.CardNotFoundException;
import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.CardType;
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

    public void transition(String cardId, String columnFrom, String columnTo) throws CardNotFoundException {
        Card card = columns.get(columnFrom).removeCard(cardId);
        columns.get(columnTo).addCard(card);
    }

    public void pulse() {
        for (Column column : columns.values()) {
            if (column.isReplenishment()) {
                updateKinbinIfReplenishmentColumnIsEmpty(column);
                updateKinbinIfReplenishmentColumnHasLimitReached(column);
            }

            if (column.isWorkStage()) {
                updateKinbinForWorkStageColumn(column);
                evaluateFortuneIfThereAreDefectsOrSpikes(column);
            }

            if (column.isQueue()) {
                updateKinbinIfQueueColumnIsNotEmpty(column);
            }

            if (column.isEnd()) {
                evaluateCardsInDone(column);
            }
        }
    }

    private void evaluateCardsInDone(Column column) {
        for (Card card : column.getCards()) {
            if (card.getCardType() == CardType.STORY) {
                kinbin.addFortune(100);
            }
            if (card.getCardType() == CardType.DEFECT) {
                kinbin.addFortune(50);
            }
        }
    }

    private void updateKinbinIfQueueColumnIsNotEmpty(Column column) {
        if (!column.getCards().isEmpty()) {
            kinbin.increasePercentWeight(0.01);
            kinbin.decreasePercentEnergy(0.01);
        }
    }

    private void evaluateFortuneIfThereAreDefectsOrSpikes(Column column) {
        for (Card card : column.getCards()) {
            if (card.getCardType() == CardType.DEFECT) {
                kinbin.removeFortune(200);
            }
            if (card.getCardType() == CardType.SPIKE) {
                kinbin.removeFortune(100);
            }
        }
    }

    private void updateKinbinForWorkStageColumn(Column column) {
        if (column.getCards().isEmpty()) {
            kinbin.increasePercentWeight(0.01);
            kinbin.decreasePercentEnergy(0.01);
        } else {
            kinbin.decreasePercentWeight(0.01 * column.getAmountOfCards());
            if (column.getAmountOfCards() >= column.getLimit()) {
                kinbin.decreasePercentEnergy(0.5);
            } else {
                kinbin.increasePercentEnergy(0.01 * column.getAmountOfCards());
            }
        }
    }

    private void updateKinbinIfReplenishmentColumnHasLimitReached(Column column) {
        if (column.getCards().size() >= column.getLimit()) {
            kinbin.increasePercentWeight(0.05);
            kinbin.decreasePercentEnergy(0.05);
        }
    }

    private void updateKinbinIfReplenishmentColumnIsEmpty(Column column) {
        if (column.getCards().isEmpty()) {
            kinbin.decreasePercentWeight(0.05);
            kinbin.decreasePercentEnergy(0.05);
        }
    }
}
