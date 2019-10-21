package com.kinbin.controller;

import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.model.kinbin.KinbinImpl;
import com.kinbin.core.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GameController {

    GameService game;

    public GameController(GameService game) {
        this.game = game;
    }

    @GetMapping("/")
    public ModelAndView kinbinpage() {
        ModelAndView modelAndView = new ModelAndView("kinbin");
        Kinbin kinbin = game.getKinbin();

        modelAndView.addObject("name", kinbin.getName());
        if (kinbin.isAlive()) {
            modelAndView.addObject("status", "Alive");
        } else {
            modelAndView.addObject("status", "Dead");
        }

        return modelAndView;
    }

    @GetMapping("/kinbin")
    public KinbinImpl getKinbin() {
        return game.getKinbin();
    }

}
