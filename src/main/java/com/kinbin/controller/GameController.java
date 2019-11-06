package com.kinbin.controller;

import com.kinbin.core.model.board.*;
import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.service.Game;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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
    public ModelAndView kinbinPage() {
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

    // to get key and token for tests: https://trello.com/app-key
    @GetMapping("/trello")
    public ModelAndView trello(@RequestParam String key, @RequestParam String token) {
        ModelAndView modelAndView = new ModelAndView("trello");

        try
        {
            String boardsJson = httpGet("members/me/boards", key, token);
            ArrayList<Object> boards = new JSONParser(boardsJson).parseArray();
            LinkedHashMap<String, Object> boardMap = (LinkedHashMap<String, Object>) boards.get(1);
            String boardId = boardMap.get("id").toString();

            Board board = new BoardImpl();

            String listsPath = String.format("boards/%s/lists", boardId);
            String listsJson = httpGet(listsPath, key, token);
            ArrayList<Object> lists = new JSONParser(listsJson).parseArray();

            for (Object listItem: lists)
            {
                LinkedHashMap<String, Object> listMap = (LinkedHashMap<String, Object>) listItem;
                String listId = listMap.get("id").toString();

                Column column = new Replenishment();

                String cardsPath = String.format("lists/%s/cards", listId);
                String cardsJson = httpGet(cardsPath, key, token);
                ArrayList<Object> cards = new JSONParser(cardsJson).parseArray();

                for (Object cardItem: cards)
                {
                    LinkedHashMap<String, Object> cardMap = (LinkedHashMap<String, Object>) cardItem;
                    String cardId = cardMap.get("id").toString();

                    CardType type = CardType.OTHER;
                    ArrayList<Object> cardLabels = (ArrayList<Object>)cardMap.get("labels");

                    for (Object labelItem: cardLabels)
                    {
                        LinkedHashMap<String, Object> labelMap = (LinkedHashMap<String, Object>) labelItem;
                        String name = labelMap.get("name").toString().toLowerCase();

                        switch (name)
                        {
                            case "story": type = CardType.STORY; break;
                            case "defect": type = CardType.DEFECT; break;
                            case "spike": type = CardType.SPIKE; break;
                            case "techdebt": type = CardType.TECH_DEBT; break;
                        }

                        if (type != CardType.OTHER)
                            break;
                    }

                    Card card = new Card(cardId, type);
                    column.addCard(card);
                }

                board.addColumn(column);
            }

            modelAndView.addObject("board", board);

        }
        catch (Exception e)
        {
            modelAndView.addObject("error", e.getMessage());
        }

        modelAndView.addObject("test", "test");

        return modelAndView;
    }

    private String httpGet(String path, String key, String token) throws IOException {
        String site = "https://api.trello.com/1/%s?key=%s&token=%s";
        URL url = new URL(String.format(site, path, key, token));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();
        return content.toString();
    }
}
