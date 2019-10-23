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
    public void shouldIncrease0point1kgIfWorkStageIsEmpty() {
        WorkStage workStage = new WorkStage();
        double expectedWeight = 0.1;
        assertThat(workStage.affectWeight(), is(expectedWeight));
    }

    @Test
    public void shouldDecrease0point1KgIfWorkStageHasAtLeastOneCard() {
        WorkStage workStage = new WorkStage();
        workStage.addCard(new Card("test", CardType.STORY));
        double expectedWeight = -0.1;
        assertThat(workStage.affectWeight(), is(expectedWeight));
    }

    @Test
    public void shouldDecrease0point1KgIfWorkStageHasCardsEqualsToLimit() {
        WorkStage workStage = new WorkStage();
        workStage.setLimit(5);
        for (int i = 0; i < 5; i++) {
            workStage.addCard(new Card("test", CardType.STORY));
        }
        double expectedWeight = -0.1;
        assertThat(workStage.affectWeight(), is(expectedWeight));
    }

    @Test
    public void shouldDecrease0point5KgIfWorkStageHasCardsMoreThanLimit() {
        WorkStage workStage = new WorkStage();
        workStage.setLimit(5);
        for (int i = 0; i < 6; i++) {
            workStage.addCard(new Card("test", CardType.STORY));
        }

        double expectedWeight = -0.5;
        assertThat(workStage.affectWeight(), is(expectedWeight));

    }

}
