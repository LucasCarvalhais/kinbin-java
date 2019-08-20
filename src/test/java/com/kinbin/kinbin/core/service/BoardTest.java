package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.exception.CardNotFoundException;
import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.CardType;
import com.kinbin.kinbin.core.model.Column;
import com.kinbin.kinbin.core.model.Kinbin;
import org.assertj.core.util.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    public static final String BACKLOG = "Backlog";
    public static final String IN_ANALYST = "In Analyst";
    public static final String READ_FOR_DEVELOPMENT = "Read for Development";
    public static final String DEVELOPMENT = "Development";
    public static final String IN_QUALITY_ANALYST = "In Quality Analyst";
    public static final String ACCEPTED = "Accepted";
    public static final String DONE = "Done";
    public static final String COLUMN_TEST = "Column Test";

    private Board board;

    private Board initializeStandardBoard() {
        Map<String, Column> columns = initializeColumns();
        return new Board(columns, new Kinbin());
    }

    private Map<String, Column> initializeColumns() {
        Column backlog = new Column(BACKLOG);
        backlog.setAsStart();
        backlog.setAsQueue();

        Column inAnalyst = new Column(IN_ANALYST);
        inAnalyst.isQueue();

        Column readyForDev = new Column(READ_FOR_DEVELOPMENT);
        readyForDev.setAsReplenishment();
        readyForDev.setAsQueue();
        readyForDev.setLimit(5);

        Column development = new Column(DEVELOPMENT);
        development.setAsWorkStage();

        Column inQA = new Column(IN_QUALITY_ANALYST);
        inQA.isQueue();

        Column accepted = new Column(ACCEPTED);
        accepted.isWorkStage();
        accepted.isQueue();

        Column done = new Column(DONE);
        done.setAsEnd();

        Map<String, Column> columns = new HashMap<>();
        columns.put(BACKLOG, backlog);
        columns.put(IN_ANALYST, inAnalyst);
        columns.put(READ_FOR_DEVELOPMENT, readyForDev);
        columns.put(DEVELOPMENT, development);
        columns.put(IN_QUALITY_ANALYST, inQA);
        columns.put(ACCEPTED, accepted);
        columns.put(DONE, done);
        return columns;
    }

    private Board initializeBoardWithReplanishmentColumn() {
        Column column = new Column(COLUMN_TEST);
        column.setAsReplenishment();
        column.setLimit(4);
        Map<String, Column> columns = Maps.newHashMap(COLUMN_TEST, column);
        return new Board(columns, new Kinbin());
    }

    private Board initializeBoardWithWorkStageColumn() {
        Column column = new Column(COLUMN_TEST);
        column.setAsWorkStage();
        Map<String, Column> columns = Maps.newHashMap(COLUMN_TEST, column);
        return new Board(columns, new Kinbin());
    }

    @Test
    public void shouldInitializeBoardWithSevenColumns() {
        board = initializeStandardBoard();
        assertThat(board.getColumns().size(), is(7));
    }

    @Test
    public void shouldAddNewCardsInBacklog() {
        board = initializeStandardBoard();
        board.addNewCard(new Card(1, CardType.STORY), BACKLOG);
        assertThat(board.getColumns().get(BACKLOG).getCards().size(), is(1));
    }

    @Test
    public void shouldTransferFromBacklogToInAnalyst() throws CardNotFoundException {
        board = initializeStandardBoard();
        board.addNewCard(new Card(1, CardType.STORY), BACKLOG);

        board.transition(1, BACKLOG, IN_ANALYST);

        assertThat(board.getColumns().get(BACKLOG).getCards().size(), is(0));
        assertThat(board.getColumns().get(IN_ANALYST).getCards().size(), is(1));
    }

    @Test
    public void shouldRemove0point05PercentOfWeightIfReplanishmentColumnIsEmpty() {
        Board boardWithReplenishmentColumn = initializeBoardWithReplanishmentColumn();

        double previousWeight = boardWithReplenishmentColumn.getKinbin().getWeight();
        boardWithReplenishmentColumn.pulse();

        double actualWeight = boardWithReplenishmentColumn.getKinbin().getWeight();
        double expectedWeight = previousWeight - previousWeight*(0.05/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldNotAddNorRemoveWeightIfReplanishmentColumnIfLimitIsNotReached() {
        Board boardWithReplenishmentColumn = initializeBoardWithReplanishmentColumn();
        Card card = new Card(1, CardType.STORY);
        boardWithReplenishmentColumn.addNewCard(card, COLUMN_TEST);

        double previousWeight = boardWithReplenishmentColumn.getKinbin().getWeight();
        boardWithReplenishmentColumn.pulse();

        double actualWeight = boardWithReplenishmentColumn.getKinbin().getWeight();
        assertThat(actualWeight, is(previousWeight));
    }

    @Test
    public void shouldIncrease0point05PercentOfWeightIfLimitIsReached() {
        Board boardWithReplenishmentColumn = initializeBoardWithReplanishmentColumn();
        boardWithReplenishmentColumn.addNewCard(new Card(1, CardType.STORY), COLUMN_TEST);
        boardWithReplenishmentColumn.addNewCard(new Card(2, CardType.DEFECT), COLUMN_TEST);
        boardWithReplenishmentColumn.addNewCard(new Card(3, CardType.SPIKE), COLUMN_TEST);
        boardWithReplenishmentColumn.addNewCard(new Card(4, CardType.TECH_DEBT), COLUMN_TEST);

        double previousWeight = boardWithReplenishmentColumn.getKinbin().getWeight();
        boardWithReplenishmentColumn.pulse();

        double actualWeight = boardWithReplenishmentColumn.getKinbin().getWeight();
        double expectedWeight = previousWeight + previousWeight*(0.05/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldIncreaseWeightIfWorkStageIsEmpty() {
        Board boardWithWorkStageColumn = initializeBoardWithWorkStageColumn();

        double previousWeight = boardWithWorkStageColumn.getKinbin().getWeight();
        boardWithWorkStageColumn.pulse();

        double actualWeight = boardWithWorkStageColumn.getKinbin().getWeight();
        double expectedWeight = previousWeight + previousWeight*(0.01/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldDecreaseWeightIfWorkStageHasOneOrMoreCards() {
        Board boardWithWorkStage = initializeBoardWithWorkStageColumn();
        boardWithWorkStage.addNewCard(new Card(1, CardType.STORY), COLUMN_TEST);
        boardWithWorkStage.addNewCard(new Card(2, CardType.DEFECT), COLUMN_TEST);
        boardWithWorkStage.addNewCard(new Card(3, CardType.SPIKE), COLUMN_TEST);
        boardWithWorkStage.addNewCard(new Card(4, CardType.TECH_DEBT), COLUMN_TEST);

        double previousWeight = boardWithWorkStage.getKinbin().getWeight();
        boardWithWorkStage.pulse();

        double actualWeight = boardWithWorkStage.getKinbin().getWeight();
        double expectedWeight = previousWeight - previousWeight * ((0.01/100)*4);
        assertThat(actualWeight, is(expectedWeight));
    }
}
