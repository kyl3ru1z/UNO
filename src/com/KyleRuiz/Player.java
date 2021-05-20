package com.KyleRuiz;

import java.util.ArrayList;

public class Player {
    public ArrayList<Card> hand = new ArrayList<>();
    public int score;
    public int numCards;
    public String name;

    Player(String name) {
        score = 0;
        numCards = 0;
        this.name = name;
    }

    void draw(Deck deck) {
        this.hand.add(deck.topDrawPileCard());
        this.update();
    }

    void removeCard(int i) {
        this.hand.remove(i);
        this.update();
    }

    void update() {
        this.score = 0;
        this.numCards = 0;

        for (int i = 0; i < this.hand.size(); i++) {
            numCards++;
            if (this.hand.get(i).value.equals("picker")) {
                this.score += 20;
            } else if (hand.get(i).value.equals("reverse")) {
                this.score += 20;
            } else if (hand.get(i).value.equals("skip")) {
                this.score += 20;
            } else if (hand.get(i).value.equals("color_changer")) {
                this.score += 50;
            } else if (hand.get(i).value.equals("pick_four")) {
                this.score += 50;
            } else if (Integer.valueOf(hand.get(i).value) >= 0 && Integer.valueOf(hand.get(i).value) <= 9) {
                this.score += Integer.valueOf(hand.get(i).value);
            }
        }
    }
}
