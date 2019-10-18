package com.kinbin.loader;

import com.kinbin.core.model.board.Card;
import com.kinbin.core.model.board.CardType;
import com.kinbin.core.model.board.Transition;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TransitionParserTest {

    TransitionParser transitionParser;

    @Before
    public void setUp() {
        transitionParser = new TransitionParser();
    }

    @Test
    public void shouldParseColumnHeaders() {
        String line = "ID,Link,Name,New,In Analysis,Ready,In Progress,Waiting,Accepted,Done,Type,";

        transitionParser.parseColumnHeaders(line);

        assertThat(transitionParser.getColumnsHeaders().length, is(11));
    }

    @Test
    public void shouldExtractStoryCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Story,";

        Card card = transitionParser.parseCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.STORY));
    }

    @Test
    public void shouldExtractDefectCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Bug,";

        Card card = transitionParser.parseCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.DEFECT));
    }

    @Test
    public void shouldExtractSpikeCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Spike,";

        Card card = transitionParser.parseCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.SPIKE));
    }

    @Test
    public void shouldExtractTechDebtCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Task,";

        Card card = transitionParser.parseCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.TECH_DEBT));
    }

    @Test
    public void shouldParseTransitionsList() throws ParseException {
        String lineHeader = "ID,Link,Name,New,In Analysis,Ready,In Progress,Waiting,Accepted,Done,Type,";
        transitionParser.parseColumnHeaders(lineHeader);
        String lineTransitions = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,," +
                "2015-12-23,2016-01-18,Bug,";

        List<Transition> transitions = transitionParser.parseTransitions(lineTransitions);

        assertThat(transitions.size(), is(5));
    }

    @Test
    public void shouldParseFile() throws ParseException {
        List<String> fileTest = Arrays.asList(
                "ID,Link,Name,New,In Analysis,Ready,In Progress,Waiting,Accepted,Done,Type,",
                "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23,2016-01-18,Bug,",
                "BKG-2,https://its.it.lan.com/browse/BKG-2,,2015-11-10,,2015-11-17,2015-11-17,,2015-11-18,2015-11-20,Bug,"
        );

        List<Transition> expectedTransitions = new ArrayList<>();
        expectedTransitions.add(new Transition(
                new Card("BKG-1", CardType.DEFECT),
                "None",
                "New",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-12")));
        expectedTransitions.add(new Transition(
                new Card("BKG-1", CardType.DEFECT),
                "New",
                "Ready",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-20")));
        expectedTransitions.add(new Transition(
                new Card("BKG-1", CardType.DEFECT),
                "Ready",
                "In Progress",
                new SimpleDateFormat("yyyy" + "-MM-dd").parse("2015-12-01")));
        expectedTransitions.add(new Transition(
                new Card("BKG-1", CardType.DEFECT),
                "In Progress",
                "Accepted",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-12-23")));
        expectedTransitions.add(new Transition(
                new Card("BKG-1", CardType.DEFECT),
                "Accepted",
                "Done",
                new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-18")));
        expectedTransitions.add(new Transition(
                new Card("BKG-2", CardType.DEFECT),
                "None",
                "New",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-10")));
        expectedTransitions.add(new Transition(
                new Card("BKG-2", CardType.DEFECT),
                "New",
                "Ready",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-17")));
        expectedTransitions.add(new Transition(
                new Card("BKG-2", CardType.DEFECT),
                "Ready",
                "In Progress",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-17")));
        expectedTransitions.add(new Transition(
                new Card("BKG-2", CardType.DEFECT),
                "In Progress",
                "Accepted",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-18")));
        expectedTransitions.add(new Transition(
                new Card("BKG-2", CardType.DEFECT),
                "Accepted",
                "Done",
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-20")));

        List<Transition> output = transitionParser.parse(fileTest);

        assertEquals(expectedTransitions.size(), output.size());
        for (int i = 0; i < expectedTransitions.size(); i++) {
            assertEquals(expectedTransitions.get(i).getCard().getId(), output.get(i).getCard().getId());
            assertEquals(expectedTransitions.get(i).getColumnFrom(), output.get(i).getColumnFrom());
            assertEquals(expectedTransitions.get(i).getColumnTo(), output.get(i).getColumnTo());
            assertEquals(expectedTransitions.get(i).getTimestamp(), output.get(i).getTimestamp());
        }
    }
}
