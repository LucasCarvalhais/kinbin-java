package com.kinbin.kinbin.loader;

import com.kinbin.kinbin.core.model.Card;
import com.kinbin.kinbin.core.model.CardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransitionParser {
    private List<String> columnHeaders;

    public void parseColumnHeaders(String line) {
        columnHeaders = Arrays.asList(line.split(","));
    }

    public List<String> getColumnsHeaders() {
        return columnHeaders;
    }

    public Card extractCard(String line) {
        String[] informations = line.split(",");
        String id = informations[0];
        CardType cardType = parseCardType(informations[informations.length-1]);
        return new Card(id, cardType);
    }

    private CardType parseCardType(String information) {
        switch (information) {
            case "Story":
                return CardType.STORY;
            case "Bug":
                return CardType.DEFECT;
            case "Spike":
                return CardType.SPIKE;
            case "Task":
                return CardType.TECH_DEBT;
            default:
                return null;
        }
    }
}
