package com.kinbin.controller;

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
        return new ModelAndView("kinbin");
    }

    @GetMapping("/kinbin")
    public KinbinImpl getKinbin() {
        return game.getKinbin();
    }

}
