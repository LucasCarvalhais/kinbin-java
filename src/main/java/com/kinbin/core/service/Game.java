package com.kinbin.core.service;

import com.kinbin.core.model.board.Column;
import com.kinbin.core.model.board.WorkStage;
import com.kinbin.core.model.kinbin.Kinbin;

public interface Game {

    Kinbin getKinbin();

    void addColumn(Column column);

    void makeKinbinPulse();
}
