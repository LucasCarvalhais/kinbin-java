package com.kinbin.core.service;

import com.kinbin.core.model.board.BoardImpl;
import com.kinbin.core.model.kinbin.KinbinImpl;
import com.kinbin.core.model.kinbin.Mood;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameServiceTest {

    @Test
    public void shouldGetKinbinStatus() {
        GameService game = new GameService(new KinbinImpl(), new BoardImpl(null, null));

        Map<String, Object> expectedAttributies = new HashMap();
        expectedAttributies.put("fortune", 250.0);
        expectedAttributies.put("energy", 50.0);
        expectedAttributies.put("weight", 50.0);
        expectedAttributies.put("mood", Mood.NEUTRAL);

        assertThat(game.getKinbinAttributies(), is(expectedAttributies));
    }

}
