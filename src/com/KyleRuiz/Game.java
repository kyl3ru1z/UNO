package com.KyleRuiz;

import java.util.ArrayList;

public class Game {

    public Deck deck;

    public Player mainPlayer;
    public Player bot1;
    public Player bot2;
    public Player bot3;

    public int currentPlayer;

    public String validColor;
    public String validValue;

    public enum gameDirection {CLOCKWISE, COUNTERCLOCKWISE}
    public gameDirection direction;
    public ArrayList<Player> players;

    int cardIndex;

    public Game(String name) {
        deck = new Deck();
        mainPlayer = new Player(name);
        bot1 = new Player("Bot 1");
        bot2 = new Player("Bot 2");
        bot3 = new Player("Bot 3");
        currentPlayer = 0;
        validColor = "";
        validValue = "";
        players = new ArrayList<>();
        players.add(mainPlayer);
        players.add(bot1);
        players.add(bot2);
        players.add(bot3);

        direction = gameDirection.CLOCKWISE;
    }
}
