package com.kinbin.core.model.board;

import com.kinbin.core.exception.CardNotFoundException;
import com.kinbin.core.model.kinbin.KinbinImpl;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BoardImpl implements Board {

    private final KinbinImpl kinbin;
    private final Map<String, Column> columns;

    public BoardImpl(Map<String, Column> columns, KinbinImpl kinbin) {
        this.columns = columns;
        this.kinbin = kinbin;
    }

    public Map<String, Column> getColumns() {
        return columns;
    }

    public KinbinImpl getKinbin() {
        return kinbin;
    }

    public void addNewCard(Card card, String column) {
        columns.get(column).addCard(card);
    }

    public void transition(String cardId, String columnFrom, String columnTo) throws CardNotFoundException {
        Card card = columns.get(columnFrom).removeCard(cardId);
        columns.get(columnTo).addCard(card);
        addFortuneIfStoryReachFinalColumn(columnTo, card);
    }

    private void addFortuneIfStoryReachFinalColumn(String columnTo, Card card) {
        if (columns.get(columnTo).isEnd() && card.getCardType() == CardType.STORY) {
            kinbin.addFortune(100);
        }
    }

    public void pulse() {
        columns.values().forEach(column -> {
            updateAttributiesForReplenishmentColumn(column);
            updateAttributiesForWorkStageColumn(column);
            updateAttributiesForQueueColumn(column);
        });
    }

    private void updateAttributiesForQueueColumn(Column column) {
        if (column.isQueue()) {
            if (!column.getCards().isEmpty()) {
                kinbin.increasePercentWeight(0.01);
                kinbin.decreasePercentEnergy(0.01);
            }
            determineFortuneForDefectsAndSpikes(column);
        }
    }

    private void updateAttributiesForWorkStageColumn(Column column) {
        if (column.isWorkStage()) {
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
            determineFortuneForDefectsAndSpikes(column);
        }
    }

    private void updateAttributiesForReplenishmentColumn(Column column) {
        if (column.isReplenishment()) {
            if (column.getCards().isEmpty()) {
                kinbin.decreasePercentWeight(0.05);
                kinbin.decreasePercentEnergy(0.05);
            }
            if (column.getCards().size() >= column.getLimit()) {
                kinbin.increasePercentWeight(0.05);
                kinbin.decreasePercentEnergy(0.05);
            }
        }
    }

    private void determineFortuneForDefectsAndSpikes(Column column) {
        column.getCards().forEach(card -> {
            removeFortuneForDefect(card);
            removeFortuneForSpike(card);
        });
    }

    private void removeFortuneForSpike(Card card) {
        if (card.getCardType() == CardType.SPIKE) {
            kinbin.removeFortune(0.5);
        }
    }

    private void removeFortuneForDefect(Card card) {
        if (card.getCardType() == CardType.DEFECT) {
            kinbin.removeFortune(1);
        }
    }
}
