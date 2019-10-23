package com.kinbin.core.service;

import com.kinbin.core.model.board.Board;
import com.kinbin.core.model.board.Card;
import com.kinbin.core.model.board.Column;
import com.kinbin.core.model.board.WorkStage;
import com.kinbin.core.model.kinbin.Kinbin;

public interface Game {

    Kinbin getKinbin();

    void addColumn(Column column);

    void makeKinbinPulse();

    Board getBoard();

    void addCard(Card card, String column);
}
