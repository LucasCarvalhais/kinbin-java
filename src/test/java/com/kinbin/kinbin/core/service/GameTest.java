package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.model.Kinbin;
import com.kinbin.kinbin.core.model.Mood;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void shouldGetKinbinStatus() {
        Game game = new Game(new Kinbin());

        Map<String, Object> expectedAttributies = new HashMap();
        expectedAttributies.put("fortune", 250.0);
        expectedAttributies.put("energy", 50.0);
        expectedAttributies.put("weight", 50.0);
        expectedAttributies.put("mood", Mood.NEUTRAL);

        assertThat(game.getKinbinAttributies(), is(expectedAttributies));
    }

}
