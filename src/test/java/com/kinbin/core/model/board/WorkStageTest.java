package com.kinbin.core.model.board;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WorkStageTest {

    private WorkStage workStage;

    @Before
    public void setUp() {
        workStage = new WorkStage();
    }

    @Test
    public void shouldInitializeWithEmptyCardList() {
        assertThat(workStage.getCards(), is(Collections.EMPTY_LIST));
    }
    
    @Test
    public void shouldIncrease0point1kgIfWorkStageIsEmpty() {
        double expectedWeight = 0.1;
        assertThat(workStage.determineWeight(), is(expectedWeight));
    }

    @Test
    public void shouldDecrease0point1KgIfWorkStageHasOneCard() {
        workStage.setLimit(5);
        workStage.addCard(new Card("test", CardType.STORY));
        double expectedWeight = -0.1;
        assertThat(workStage.determineWeight(), is(expectedWeight));
    }

    @Test
    public void shouldDecrease0point1KgIfWorkStageHasCardsEqualsToLimit() {
        workStage.setLimit(5);
        addMultipleCards(5);
        double expectedWeight = -0.1;
        assertThat(workStage.determineWeight(), is(expectedWeight));
    }

    @Test
    public void shouldDecrease0point5KgIfWorkStageHasCardsMoreThanLimit() {
        workStage.setLimit(5);
        addMultipleCards(6);
        double expectedWeight = -0.5;
        assertThat(workStage.determineWeight(), is(expectedWeight));

    }

    private void addMultipleCards(int amountOfCards) {
        for (int i = 0; i < amountOfCards; i++) {
            workStage.addCard(new Card("test", CardType.STORY));
        }
    }

}
