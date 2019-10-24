package com.kinbin.core.service;

import com.kinbin.core.model.board.BoardImpl;
import com.kinbin.core.model.board.WorkStage;
import com.kinbin.core.model.kinbin.KinbinImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameServiceTest {

    @Test
    public void kinbinSHouldPulseAndAffectTheirAttributies() {
        GameService gameService = new GameService(new KinbinImpl(), new BoardImpl());
        gameService.addColumn(new WorkStage());

        gameService.makeKinbinPulse();
        assertThat(gameService.getKinbin().getWeight(), is(50.1));
    }

}
