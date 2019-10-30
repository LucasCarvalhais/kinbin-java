package com.kinbin.core.model.board;

public class Replenishment extends Column {

    public static final double WEIGHT_IF_REPLENISHMENT_IS_EMPTY = -0.25;
    public static final double WEIGHT_IF_LIMIT_IS_EXCEEDED = 0.25;
    public static final int WEIGHT_IF_LIMIT_IS_NOT_EXCEEDED = 0;

    public Replenishment() {
        super("Replenishment");
    }

    @Override
    public double determineWeight() {
        return (getCards().isEmpty())
                ? WEIGHT_IF_REPLENISHMENT_IS_EMPTY
                : (getCards().size() >= getLimit())
                    ? WEIGHT_IF_LIMIT_IS_EXCEEDED
                    : WEIGHT_IF_LIMIT_IS_NOT_EXCEEDED;
    }
}
