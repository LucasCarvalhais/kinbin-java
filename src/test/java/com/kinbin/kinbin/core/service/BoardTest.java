package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.exception.CardNotFoundException;
import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.CardType;
import com.kinbin.kinbin.core.model.Column;
import com.kinbin.kinbin.core.model.Kinbin;
import org.junit.Before;
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

    Board board;

    @Before
    public void setUp() {
        Map<String, Column> columns = initializeColumns();
        Kinbin kinbin = new Kinbin();
        board = new Board(columns, kinbin);
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

    @Test
    public void shouldInitializeBoardWithSevenColumns() {
        assertThat(board.getColumns().size(), is(7));
    }

    @Test
    public void shouldAddNewCardsInBacklog() {
        board.addNewCard(new Card(1, CardType.STORY), BACKLOG);
        assertThat(board.getColumns().get(BACKLOG).getCards().size(), is(1));
    }

    @Test
    public void shouldTransferFromBacklogToInQuality() throws CardNotFoundException {
        board.addNewCard(new Card(1, CardType.STORY), BACKLOG);
        board.transition(1, BACKLOG, IN_ANALYST);
        assertThat(board.getColumns().get(BACKLOG).getCards().size(), is(0));
        assertThat(board.getColumns().get(IN_ANALYST).getCards().size(), is(1));
    }
}
