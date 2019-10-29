package com.kinbin.core.service;

import com.kinbin.core.model.board.Board;
import com.kinbin.core.model.board.Card;
import com.kinbin.core.model.board.Column;
import com.kinbin.core.model.kinbin.Kinbin;
import org.springframework.stereotype.Component;

@Component
public class GameImpl implements Game {
    private final Kinbin kinbin;
    private final Board board;

    public GameImpl(Kinbin kinbin, Board board) {
        this.kinbin = kinbin;
        this.board = board;
    }

    @Override
    public Kinbin getKinbin() {
        return kinbin;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void addColumn(Column column) {
        board.addColumn(column);
    }

    @Override
    public void addCard(Card card, String column) {
        board.addCard(card, column);
    }

    @Override
    public void makeKinbinPulse() {
        double totalWeight = board.checkWeight();
        kinbin.addWeight(totalWeight);
    }
}