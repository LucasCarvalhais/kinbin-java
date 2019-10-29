package com.kinbin.core.service;

import com.kinbin.core.model.board.BoardImpl;
import com.kinbin.core.model.board.WorkStage;
import com.kinbin.core.model.kinbin.KinbinImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameImplTest {

    @Test
    public void kinbinSHouldPulseAndAffectTheirAttributies() {
        GameImpl gameImpl = new GameImpl(new KinbinImpl(), new BoardImpl());
        gameImpl.addColumn(new WorkStage());

        gameImpl.makeKinbinPulse();
        assertThat(gameImpl.getKinbin().getWeight(), is(50.1));
    }

}
