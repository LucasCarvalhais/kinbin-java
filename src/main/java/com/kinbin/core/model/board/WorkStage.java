package com.kinbin.core.model.board;

public class WorkStage extends Column {

    public WorkStage() {
        super("Work Stage");
    }

    @Override
    public double determineWeight() {
        return (getCards().isEmpty()) ? 0.1
                : (getCards().size() <= getLimit()) ? -0.1 : -0.5;
    }

}
