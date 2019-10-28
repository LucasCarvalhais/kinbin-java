package com.kinbin.core.model.board;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReplenishmentTest {

    private Replenishment replenishment;

    @Before
    public void setUp() {
        replenishment = new Replenishment();
    }

    @Test
    public void shouldInitializeWithEmptyCardList() {
        assertThat(replenishment.getCards(), is(Collections.EMPTY_LIST));
    }

    @Test
    public void shouldLose0point25IfReplenishmentIsEmpty() {
        double expectedWeight = -0.25;
        assertThat(replenishment.determineWeight(), is(expectedWeight));
    }

    @Test
    public void shouldGet0point25IfReplenishmentHasLimitExceded() {
        double expectedWeight = 0.25;
        replenishment.setLimit(5);
        addMultipleCards(6);
        assertThat(replenishment.determineWeight(), is(expectedWeight));
    }

    @Test
    public void shouldNotAffectWeightIfLimitIsNotReached() {
        double expectedWeight = 0;
        replenishment.setLimit(5);
        addMultipleCards(3);
        assertThat(replenishment.determineWeight(), is(expectedWeight));
    }

    private void addMultipleCards(int amountOfCards) {
        for (int i = 0; i < amountOfCards; i++) {
            replenishment.addCard(new Card("test", CardType.STORY));
        }
    }

}
