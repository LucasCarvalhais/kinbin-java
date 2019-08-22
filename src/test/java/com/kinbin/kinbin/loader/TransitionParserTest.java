package com.kinbin.kinbin.loader;

import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.CardType;
import com.kinbin.kinbin.core.model.Transition;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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

        Card card = transitionParser.extractCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.STORY));
    }

    @Test
    public void shouldExtractDefectCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Bug,";

        Card card = transitionParser.extractCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.DEFECT));
    }

    @Test
    public void shouldExtractSpikeCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Spike,";

        Card card = transitionParser.extractCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.SPIKE));
    }

    @Test
    public void shouldExtractTechDebtCard() {
        String line = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,,2015-12-23," +
                "2016-01-18,Task,";

        Card card = transitionParser.extractCard(line);

        assertThat(card.getId(), is("BKG-1"));
        assertThat(card.getCardType(), is(CardType.TECH_DEBT));
    }

    @Test
    public void shouldParseTransitionsList() throws ParseException {
        String lineHeader = "ID,Link,Name,New,In Analysis,Ready,In Progress,Waiting,Accepted,Done,Type,";
        transitionParser.parseColumnHeaders(lineHeader);
        String lineTransitions = "BKG-1,https://its.it.lan.com/browse/BKG-1,,2015-11-12,,2015-11-20,2015-12-01,," +
                "2015-12-23,2016-01-18,Bug,";

        List<Transition> transitions = transitionParser.extractTransitions(lineTransitions);

        assertThat(transitions.size(), is(5));
    }
}
