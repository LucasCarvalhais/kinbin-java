package com.kinbin.core.model.board;

public class WorkStage extends Column {

    public static final double WEIGHT_IF_WORK_STAGE_IS_EMPTY = 0.1;
    public static final double WEIGHT_IF_NUMBER_OF_CARDS_IS_WITHIN_LIMIT = -0.1;
    public static final double WEIGHT_IF_NUMBER_OF_CARDS_OVERCOMES_LIMIT = -0.5;

    public WorkStage() {
        super("Work Stage");
    }

    @Override
    public double determineWeight() {
        return (getCards().isEmpty()) ? WEIGHT_IF_WORK_STAGE_IS_EMPTY
                : (getCards().size() <= getLimit())
                    ? WEIGHT_IF_NUMBER_OF_CARDS_IS_WITHIN_LIMIT
                    : WEIGHT_IF_NUMBER_OF_CARDS_OVERCOMES_LIMIT;
    }

}
