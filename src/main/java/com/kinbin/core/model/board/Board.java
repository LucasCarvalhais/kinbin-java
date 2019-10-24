package com.kinbin.core.model.board;

import java.util.List;

public interface Board {

    void addColumn(Column column);
    List<Column> getColumns();

    void addCard(Card card, String column);

    double checkWeight();
}
