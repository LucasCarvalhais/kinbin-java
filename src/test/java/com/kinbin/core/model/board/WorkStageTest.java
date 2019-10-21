package com.kinbin.core.model.board;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WorkStageTest {

    @Test
    public void shouldInitializeWithEmptyCardList() {
        WorkStage workStage = new WorkStage();
        assertThat(workStage.getCards(), is(Collections.EMPTY_LIST));
    }
    
    @Test
    public void shouldDecrease0point1kgIfWorkStageIsEmpty() {
        WorkStage workStage = new WorkStage();
        double expectedWeight = 0.1;
        assertThat(workStage.affectWeight(), is(expectedWeight));
    }

}
