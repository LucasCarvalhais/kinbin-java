package com.kinbin.kinbin.core.model;

import com.kinbin.kinbin.core.exception.CardNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ColumnTest {

    @Rule
    public ExpectedException expection = ExpectedException.none();

    Column column;

    @Before
    public void setUp() {
        column = new Column("Column Test");
    }

    @Test
    public void shouldInitializeColumn() {
        assertThat(column.getName(), is("Column Test"));
    }

    @Test
    public void shouldSetColumnAsReplenishment() {
        assertFalse(column.isReplenishment());
        column.setAsReplenishment();
        assertTrue(column.isReplenishment());
    }

    @Test
    public void shouldSetColumnAsWorkStage() {
        assertFalse(column.isWorkStage());
        column.setAsWorkStage();
        assertTrue(column.isWorkStage());
    }

    @Test
    public void shouldSetColumnAsQueue() {
        assertFalse(column.isQueue());
        column.setAsQueue();
        assertTrue(column.isQueue());
    }

    @Test
    public void shouldSetColumnAsStart() {
        assertFalse(column.isStart());
        column.setAsStart();
        assertTrue(column.isStart());
    }

    @Test
    public void shouldSetColumnAsEnd() {
        assertFalse(column.isEnd());
        column.setAsEnd();
        assertTrue(column.isEnd());
    }

    @Test
    public void cardListShouldBeEmpty() {
        assertThat(column.getCards(), is(Collections.EMPTY_LIST));
    }

    @Test
    public void shouldAddCard() {
        Card card = new Card("1", CardType.STORY);
        column.addCard(card);
        assertThat(column.getCards(), is(Arrays.asList(card)));
    }

    @Test
    public void shouldRemoveCard() throws CardNotFoundException {
        Card card = new Card("2", CardType.DEFECT);
        column.addCard(card);
        Card removedCard = column.removeCard("2");
        assertThat(column.getCards(), is(Collections.EMPTY_LIST));
        assertThat(removedCard, is(card));
    }

    @Test
    public void shouldThrowExceptionIfCardIsNotFound() throws CardNotFoundException {
        expection.expect(CardNotFoundException.class);
        column.removeCard("3");
    }

}
