package com.kinbin.kinbin.core.service;

import com.kinbin.kinbin.core.model.Kinbin;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Game {
    private final Kinbin kinbin;

    public Game(Kinbin kinbin) {
        this.kinbin = kinbin;
    }

    public Map<String, Object> getKinbinAttributies() {
        Map<String, Object> attributies = new HashMap();

        attributies.put("fortune", kinbin.getFortune());
        attributies.put("energy", kinbin.getEnergy());
        attributies.put("weight", kinbin.getWeight());
        attributies.put("mood", kinbin.getMood());

        return attributies;
    }

    public Kinbin getKinbin() {
        return kinbin;
    }
}
