package com.kinbin.core.model.board;

import java.util.ArrayList;
import java.util.List;

public class WorkStage extends Column {

    public WorkStage() {
        super("Work Stage");
        cards = new ArrayList<>();
    }

    @Override
    public double affectWeight() {
        return 0.1;
    }

}
