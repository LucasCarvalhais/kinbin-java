package com.kinbin.core.model.board;

import java.util.List;

public interface Board {
    void addColumn(Column column);

    double checkWeight();

    List<Column> getColumns();

    void addCard(Card card, String column);
}
