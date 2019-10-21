package com.kinbin.controller;

import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.service.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.util.StringUtils.capitalize;

@RestController
public class GameController {

    Game game;

    public GameController(Game game) {
        this.game = game;
    }

    @GetMapping("/")
    public ModelAndView kinbinpage() {
        ModelAndView modelAndView = new ModelAndView("kinbin");
        Kinbin kinbin = game.getKinbin();

        String moodString = capitalize(kinbin.getMood().toString().toLowerCase());

        modelAndView.addObject("name", kinbin.getName());
        if (kinbin.isAlive()) {
            modelAndView.addObject("status", "Alive");
        } else {
            modelAndView.addObject("status", "Dead");
        }
        modelAndView.addObject("age", kinbin.getAge());
        modelAndView.addObject("mood", moodString);
        modelAndView.addObject("weight", kinbin.getWeight());
        modelAndView.addObject("energy", kinbin.getEnergy());
        modelAndView.addObject("fortune", kinbin.getFortune());

        return modelAndView;
    }

    @GetMapping("/kinbin")
    public Kinbin getKinbin() {
        return game.getKinbin();
    }

}
