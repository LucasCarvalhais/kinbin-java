package com.kinbin.core.service;

import com.kinbin.core.model.board.Board;
import com.kinbin.core.model.kinbin.KinbinImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameService implements Game {
    private final KinbinImpl kinbin;
    private final Board board;

    public GameService(KinbinImpl kinbin, Board board) {
        this.kinbin = kinbin;
        this.board = board;
    }

    public Map<String, Object> getKinbinAttributies() {
        Map<String, Object> attributies = new HashMap();

        attributies.put("fortune", kinbin.getFortune());
        attributies.put("energy", kinbin.getEnergy());
        attributies.put("weight", kinbin.getWeight());
        attributies.put("mood", kinbin.getMood());

        return attributies;
    }

    public KinbinImpl getKinbin() {
        return kinbin;
    }
}
