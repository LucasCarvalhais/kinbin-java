package com.kinbin.core.service;

import com.kinbin.core.model.kinbin.Kinbin;
import org.springframework.stereotype.Component;

@Component
public class GameService implements Game {
    private final Kinbin kinbin;

    public GameService(Kinbin kinbin) {
        this.kinbin = kinbin;
    }

    public Kinbin getKinbin() {
        return kinbin;
    }
}
