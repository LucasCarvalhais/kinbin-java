package com.kinbin.controller;

import com.kinbin.core.model.board.Board;
import com.kinbin.core.model.board.Column;
import com.kinbin.core.model.board.WorkStage;
import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.service.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.StringUtils.capitalize;

@RestController
public class GameController {

    private Game game;

    public GameController(Game game) {
        this.game = game;
        Column workStage = new WorkStage();
        this.game.addColumn(workStage);
    }

    @GetMapping("/")
    public ModelAndView kinbinpage() {
        ModelAndView modelAndView = new ModelAndView("kinbin");
        Kinbin kinbin = game.getKinbin();
        Board board = game.getBoard();

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
        modelAndView.addObject("columns", board.getColumns());

        return modelAndView;
    }

    @GetMapping("/kinbin")
    public Kinbin getKinbin() {
        return game.getKinbin();
    }

    @GetMapping("/pulse")
    public void pulseKinbin(HttpServletResponse response) throws IOException {
        game.makeKinbinPulse();
        response.sendRedirect("/");
    }

}
