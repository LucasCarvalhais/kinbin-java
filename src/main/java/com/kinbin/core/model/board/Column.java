package com.kinbin.core.model.board;

import java.util.List;

public abstract class Column {

    protected List<Card> cards;

    public abstract double affectWeight();

}
