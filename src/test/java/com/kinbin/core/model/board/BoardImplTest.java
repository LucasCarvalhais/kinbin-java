package com.kinbin.core.model.board;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardImplTest {

    @Test
    public void shouldSendWeightUpdateTargetWhenPulseOccurs() {
        BoardImpl board = new BoardImpl();

        WorkStage workStage = new WorkStage();
        board.addColumn(workStage);
        assertThat(board.getColumns(), is(Arrays.asList(workStage)));
        assertThat(workStage.getCards(), is(Collections.EMPTY_LIST));

        assertThat(board.checkWeight(), is(0.1));
    }

}
