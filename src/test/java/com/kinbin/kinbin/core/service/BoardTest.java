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
    public static final String IN_ANALYSIS = "In Analysis";
    public static final String READY = "Ready";
    public static final String IN_PROGRESS = "In Progress";
    public static final String WAITING = "Waiting";
    public static final String ACCEPTED = "Accepted";
    public static final String DONE = "Done";
    public static final String COLUMN_TEST = "Column Test";

    private Board board;

    private Map<String, Column> initializeColumns() {
        Column backlog = new Column(BACKLOG);
        backlog.setAsStart();
        backlog.setAsQueue();

        Column inAnalysis = new Column(IN_ANALYSIS);
        inAnalysis.setAsQueue();

        Column ready = new Column(READY);
        ready.setAsReplenishment();
        ready.setAsQueue();
        ready.setLimit(5);

        Column inProgress = new Column(IN_PROGRESS);
        inProgress.setAsWorkStage();

        Column waiting = new Column(WAITING);
        waiting.isQueue();

        Column accepted = new Column(ACCEPTED);
        accepted.isWorkStage();
        accepted.isQueue();

        Column done = new Column(DONE);
        done.setAsEnd();

        Map<String, Column> columns = new HashMap<>();
        columns.put(BACKLOG, backlog);
        columns.put(IN_ANALYSIS, inAnalysis);
        columns.put(READY, ready);
        columns.put(IN_PROGRESS, inProgress);
        columns.put(WAITING, waiting);
        columns.put(ACCEPTED, accepted);
        columns.put(DONE, done);
        return columns;
    }

    private Board initializeStandardBoard() {
        Map<String, Column> columns = initializeColumns();
        return new Board(columns, new Kinbin());
    }

    private Board initializeBoardWithReplenishmentColumn() {
        Column column = new Column(COLUMN_TEST);
        column.setAsReplenishment();
        column.setLimit(4);
        Map<String, Column> columns = Maps.newHashMap(COLUMN_TEST, column);
        return new Board(columns, new Kinbin());
    }

    private Board initializeBoardWithWorkStageColumn() {
        Column column = new Column(COLUMN_TEST);
        column.setAsWorkStage();
        column.setLimit(4);
        Map<String, Column> columns = Maps.newHashMap(COLUMN_TEST, column);
        return new Board(columns, new Kinbin());
    }

    private Board initializeBoardWithQueueColumn() {
        Column column = new Column(COLUMN_TEST);
        column.setAsQueue();
        Map<String, Column> columns = Maps.newHashMap(COLUMN_TEST, column);
        return new Board(columns, new Kinbin());
    }

    private Board initializeBoardWithEndColumn() {
        Column column = new Column(COLUMN_TEST);
        column.setAsEnd();
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

        board.addNewCard(new Card("1", CardType.STORY), BACKLOG);

        assertThat(board.getColumns().get(BACKLOG).getAmountOfCards(), is(1));
    }

    @Test
    public void shouldTransferFromBacklogToInAnalysis() throws CardNotFoundException {
        board = initializeStandardBoard();
        board.addNewCard(new Card("1", CardType.STORY), BACKLOG);

        board.transition("1", BACKLOG, IN_ANALYSIS);

        assertThat(board.getColumns().get(BACKLOG).getAmountOfCards(), is(0));
        assertThat(board.getColumns().get(IN_ANALYSIS).getAmountOfCards(), is(1));
    }

    @Test
    public void shouldDecreaseWeightIfReplenishmentColumnIsEmpty() {
        board = initializeBoardWithReplenishmentColumn();

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        double expectedWeight = previousWeight - previousWeight*(0.05/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldNotAffectWeightIfReplenishmentColumnHasLimitNotReached() {
        board = initializeBoardWithReplenishmentColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        assertThat(actualWeight, is(previousWeight));
    }

    @Test
    public void shouldIncreaseWeightIfLimitInReplenishmentIsReached() {
        board = initializeBoardWithReplenishmentColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("2", CardType.DEFECT), COLUMN_TEST);
        board.addNewCard(new Card("3", CardType.SPIKE), COLUMN_TEST);
        board.addNewCard(new Card("4", CardType.TECH_DEBT), COLUMN_TEST);

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        double expectedWeight = previousWeight + previousWeight*(0.05/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldIncreaseWeightIfWorkStageIsEmpty() {
        board = initializeBoardWithWorkStageColumn();

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        double expectedWeight = previousWeight + previousWeight*(0.01/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldDecreaseWeightIfWorkStageHasOneOrMoreCards() {
        board = initializeBoardWithWorkStageColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("2", CardType.DEFECT), COLUMN_TEST);
        board.addNewCard(new Card("3", CardType.SPIKE), COLUMN_TEST);
        board.addNewCard(new Card("4", CardType.TECH_DEBT), COLUMN_TEST);

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        double expectedWeight = previousWeight - (previousWeight * ((0.01/100))*4);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldNotAffectWeightIfQueueColumnIsEmpty() {
        board = initializeBoardWithQueueColumn();

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        assertThat(actualWeight, is(previousWeight));
    }

    @Test
    public void shouldIncreaseWeightIfQueueColumnIsNotEmpty() {
        board = initializeBoardWithQueueColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("2", CardType.SPIKE), COLUMN_TEST);

        double previousWeight = board.getKinbin().getWeight();
        board.pulse();

        double actualWeight = board.getKinbin().getWeight();
        double expectedWeight = previousWeight + previousWeight*(0.01/100);
        assertThat(actualWeight, is(expectedWeight));
    }

    @Test
    public void shouldDecreaseEnergyIfReplenishmentIsEmpty() {
        board = initializeBoardWithReplenishmentColumn();

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        double expectedEnergy = previousEnergy - previousEnergy*(0.05/100);
        assertThat(actualEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldNotAffectEnergyIfReplenishmentLimitIsNotReached() {
        board = initializeBoardWithReplenishmentColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("3", CardType.SPIKE), COLUMN_TEST);

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        assertThat(actualEnergy, is(previousEnergy));
    }

    @Test
    public void shouldDecreaseEnergyIfReplenishmentHasLimitReached() {
        board = initializeBoardWithReplenishmentColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("2", CardType.DEFECT), COLUMN_TEST);
        board.addNewCard(new Card("3", CardType.SPIKE), COLUMN_TEST);
        board.addNewCard(new Card("4", CardType.TECH_DEBT), COLUMN_TEST);

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        double expectedEnergy = previousEnergy - previousEnergy*(0.05/100);
        assertThat(actualEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldDecreaseEnergyIfWorkStageIsEmpty() {
        board = initializeBoardWithWorkStageColumn();

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        double expectedEnergy = previousEnergy - previousEnergy * (0.01/100);
        assertThat(actualEnergy, is(expectedEnergy));
    }

    @Test
    public void shouldIncreaseEnergyIfWorkStageIsNotEmptyAndNotReachLimit() {
        board = initializeBoardWithWorkStageColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("2", CardType.SPIKE), COLUMN_TEST);

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        double expectedEneergy = previousEnergy + previousEnergy*((0.01/100)*2);
        assertThat(actualEnergy, is(expectedEneergy));
    }

    @Test
    public void shouldDecreaseStronglyEnergyIfLimitInWorkStageIsReached() {
        board = initializeBoardWithWorkStageColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);
        board.addNewCard(new Card("2", CardType.DEFECT), COLUMN_TEST);
        board.addNewCard(new Card("3", CardType.SPIKE), COLUMN_TEST);
        board.addNewCard(new Card("4", CardType.TECH_DEBT), COLUMN_TEST);

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        double expectedEneergy = previousEnergy - previousEnergy*(0.5/100);
        assertThat(actualEnergy, is(expectedEneergy));
    }

    @Test
    public void shouldNotAffectEnergyIfQueueIsNEmpty() {
        board = initializeBoardWithQueueColumn();

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        assertThat(actualEnergy, is(previousEnergy));
    }

    @Test
    public void shouldDecreaseEnergyIfQueueIsNotEmpty() {
        board = initializeBoardWithQueueColumn();
        board.addNewCard(new Card("1", CardType.STORY), COLUMN_TEST);

        double previousEnergy = board.getKinbin().getEnergy();
        board.pulse();

        double actualEnergy = board.getKinbin().getEnergy();
        double expectedEneergy = previousEnergy - previousEnergy*(0.01/100);
        assertThat(actualEnergy, is(expectedEneergy));
    }

    @Test
    public void shouldRemove1FromFortuneIfDefectsAreInWorkStage() {
        board = initializeBoardWithWorkStageColumn();
        board.addNewCard(new Card("1", CardType.DEFECT), COLUMN_TEST);

        double previousFortune = board.getKinbin().getFortune();
        board.pulse();

        double actualFortune = board.getKinbin().getFortune();
        double expectedFortune = previousFortune - 1;
        assertThat(actualFortune, is(expectedFortune));
    }

    @Test
    public void shouldRemove1FromFortuneIfDefectsAreInQueue(){
        board = initializeBoardWithQueueColumn();
        board.addNewCard(new Card("1", CardType.DEFECT), COLUMN_TEST);

        double previousFortune = board.getKinbin().getFortune();
        board.pulse();

        double actualFortune = board.getKinbin().getFortune();
        double expectedFortune = previousFortune - 1;
        assertThat(actualFortune, is(expectedFortune));
    }

    @Test
    public void shouldRemove5centsFromFortuneIfSpikeIsInWorkStage() {
        board = initializeBoardWithWorkStageColumn();
        board.addNewCard(new Card("1", CardType.SPIKE), COLUMN_TEST);

        double previousFortune = board.getKinbin().getFortune();
        board.pulse();

        double actualFortune = board.getKinbin().getFortune();
        double expectedFortune = previousFortune - 0.5;
        assertThat(actualFortune, is(expectedFortune));
    }

    @Test
    public void shouldRemove5centsFromFortuneIfSpikeIsInQueue() {
        board = initializeBoardWithQueueColumn();
        board.addNewCard(new Card("1", CardType.SPIKE), COLUMN_TEST);

        double previousFortune = board.getKinbin().getFortune();
        board.pulse();

        double actualFortune = board.getKinbin().getFortune();
        double expectedFortune = previousFortune - 0.5;
        assertThat(actualFortune, is(expectedFortune));
    }

    @Test
    public void shouldAdd100ToFortuneIfCardReachDone() throws CardNotFoundException {
        board = initializeStandardBoard();
        board.addNewCard(new Card("2", CardType.STORY), ACCEPTED);

        double previousFortune = board.getKinbin().getFortune();
        board.transition("2", ACCEPTED, DONE);
        double actualFortune = board.getKinbin().getFortune();

        double expectedFortune = previousFortune + 100;
        assertThat(actualFortune, is(expectedFortune));


    }
}
