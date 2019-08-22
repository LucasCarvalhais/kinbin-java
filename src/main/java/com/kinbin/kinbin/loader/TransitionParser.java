package com.kinbin.kinbin.loader;

import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.CardType;
import com.kinbin.kinbin.core.model.Transition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransitionParser {
    private String[] columnHeaders;

    public void parseColumnHeaders(String line) {
        columnHeaders = line.split(",");
    }

    public String[] getColumnsHeaders() {
        return columnHeaders;
    }

    public Card extractCard(String line) {
        String[] informations = line.split(",");
        String id = informations[0];
        CardType cardType = parseCardType(informations[informations.length-1]);
        return new Card(id, cardType);
    }

    private CardType parseCardType(String information) {
        if (information.equals("Story")) {
            return CardType.STORY;
        }
        if (information.equals("Bug")) {
            return CardType.DEFECT;
        }
        if (information.equals("Spike")) {
            return CardType.SPIKE;
        }
        if (information.equals("Task")) {
            return CardType.TECH_DEBT;
        }
        return null;
    }

    public List<Transition> extractTransitions(String line) throws ParseException {
        String[] informations = line.split(",");
        List<Transition> transitions = new ArrayList<>();

        Card card = extractCard(line);
        String columnFrom = "None";
        for (int i = 3; i < informations.length - 1; i++) {
            if (!informations[i].equals("")) {
                String columnTo = columnHeaders[i];
                Date timestamp = new SimpleDateFormat("yyyy-MM-dd").parse(informations[i]);
                Transition transition =
                        new Transition(card, columnFrom, columnTo, timestamp);
                transitions.add(transition);
                columnFrom = columnTo;
            }
        }

        return transitions;
    }
}
