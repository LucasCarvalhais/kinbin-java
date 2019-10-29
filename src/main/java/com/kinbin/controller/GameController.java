package com.kinbin.controller;

import ch.qos.logback.classic.db.names.ColumnName;
import com.kinbin.core.model.board.*;
import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.service.Game;
import org.springframework.web.bind.annotation.*;
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
    private Game game;

    public GameController(Game game) {
        this.game = game;
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

    @GetMapping("/add_card_form")
    public ModelAndView addCardForm() {
        return new ModelAndView("add_card_form");
    }

    @GetMapping("/add_card")
    public void addCard(HttpServletResponse response,
                        @RequestParam(name = "column-name") String columnName) throws IOException {
        Card card = new Card(DEFAULT_ID, CardType.STORY);
        game.addCard(card, columnName);
        response.sendRedirect("/");
    }

    @GetMapping("/add_column_form")
    public ModelAndView addColumnForm() {
        return new ModelAndView("add_column_form");
    }

    @GetMapping("/add_column")
    public void addColumn(HttpServletResponse response,
                          @RequestParam(name = "column-type") String columnType) throws IOException {
        if (columnType.equals("replenishment")) {
            game.getBoard().addColumn(new Replenishment());
        } else if (columnType.equals("work-stage")) {
            game.getBoard().addColumn(new WorkStage());
        }
        response.sendRedirect("/");
    }

}
