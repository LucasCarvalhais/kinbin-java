package com.kinbin.core.model.board;

import java.util.ArrayList;
import java.util.List;

public class WorkStage extends Column {

    public WorkStage() {
        super("Work Stage");
    }

    @Override
    public double affectWeight() {
        if (getCards().isEmpty()) {
            return 0.1;
        }
        if (getCards().size() > getLimit() && getLimit() != 0) {
            return -0.5;
        }
        return -0.1;
    }

}
