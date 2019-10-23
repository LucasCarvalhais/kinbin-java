package com.kinbin.core.model.board;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardImplTest {

    BoardImpl board;

    @Before
    public void setUp() {
        board = new BoardImpl();
    }

    @Test
    public void shouldSendWeightUpdateTargetWhenPulseOccurs() {
        WorkStage workStage = new WorkStage();
        board.addColumn(workStage);
        assertThat(board.getColumns(), is(Arrays.asList(workStage)));
        assertThat(workStage.getCards(), is(Collections.EMPTY_LIST));

        assertThat(board.checkWeight(), is(0.1));
    }

    @Test
    public void shouldAddCardInAnExistingColumn() {
        Column workStage = new WorkStage();
        board.addColumn(workStage);

        Card card = new Card("1", CardType.STORY);
        board.addCard(card, "Work Stage");
        assertThat(board.getColumns().get(0).getCards().get(0), is(card));
    }

}
