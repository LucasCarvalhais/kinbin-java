package com.kinbin.kinbin.controller;

import com.kinbin.kinbin.core.model.Kinbin;
import com.kinbin.kinbin.core.service.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class KinbinController {

    Game game;

    public KinbinController(Game game) {
        this.game = game;
    }

    @GetMapping("/")
    public ModelAndView kinbinpage() {
        return new ModelAndView("kinbin");
    }

    @GetMapping("/kinbin")
    public Kinbin getKinbin() {
        return game.getKinbin();
    }

}
