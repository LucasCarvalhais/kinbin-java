package com.kinbin.core.model.board;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardImpl implements Board {

    private List<Column> columns;

    public BoardImpl() {
        this.columns = new ArrayList();
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public double checkWeight() {
        double totalWeight = 0;
        for (Column column : columns) {
            totalWeight += column.affectWeight();
        }
        return totalWeight;
    }
}
