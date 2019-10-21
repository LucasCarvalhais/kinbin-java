package com.kinbin.core.service;

import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.model.kinbin.KinbinImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameServiceTest {

    @Test
    public void shouldGetKinbin() {
        Kinbin kinbin = new KinbinImpl();
        GameService gameService = new GameService(kinbin);
        assertThat(gameService.getKinbin(), is(kinbin));
    }

}
