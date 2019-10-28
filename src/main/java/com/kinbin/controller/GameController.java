package com.kinbin.controller;

import com.kinbin.core.model.board.*;
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

    public static final int LIMIT_COLUMN = 5;
    public static final String ALIVE = "Alive";
    public static final String DEAD = "Dead";
    public static final String DEFAULT_ID = "default_id";
    public static final String WORK_STAGE = "Work Stage";
    public static final String REPLENISHMENT = "Replenishment";
    private Game game;

    public GameController(Game game) {
        this.game = game;
        setUpColumns();
    }

    private void setUpColumns() {
        Column replenishment = new Replenishment();
        replenishment.setLimit(LIMIT_COLUMN);
        this.game.addColumn(replenishment);
    }

    @GetMapping("/")
    public ModelAndView kinbinpage() {
        ModelAndView modelAndView = new ModelAndView("kinbin");
        Kinbin kinbin = game.getKinbin();
        Board board = game.getBoard();

        String moodString = capitalize(kinbin.getMood().toString().toLowerCase());
        String status = (kinbin.isAlive()) ? ALIVE : DEAD;

        modelAndView.addObject("name", kinbin.getName());
        modelAndView.addObject("status", status);
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

    @GetMapping("/addCard")
    public void addCard(HttpServletResponse response) throws IOException {
        Card card = new Card(DEFAULT_ID, CardType.STORY);
        game.addCard(card, REPLENISHMENT);
        response.sendRedirect("/");
    }

}
