package com.kinbin.core.model.board;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardImpl implements Board {

    private List<Column> columns;

    public BoardImpl() {
        this.columns = new ArrayList<>();
    }

    @Override
    public void addColumn(Column column) {
        this.columns.add(column);
    }

    @Override
    public List<Column> getColumns() {
        return columns;
    }

    @Override
    public void addCard(Card card, String columnName) {
        columns.stream().filter(column -> column.getName().equals(columnName))
                .findFirst()
                .ifPresent(column -> column.addCard(card));
    }

    @Override
    public double checkWeight() {
        return columns.stream().mapToDouble(Column::determineWeight).sum();
    }
}
