package com.KyleRuiz;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> drawPile = new ArrayList<>();
    public ArrayList<Card> discardPile = new ArrayList<>();
    public String[] deckColor = {"red", "yellow", "green", "blue", "wild"};
    public String[] deckValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "picker", "reverse", "skip", "color_changer", "pick_four"};

    Deck() {
        this.build();
        this.shuffle();
    }

    public void build() {
        for (int i = 0; i < deckColor.length-1; i++) {
            for (int j = 0; j < deckValue.length-2; j++) {
                this.drawPile.add(new Card(deckColor[i], deckValue[j]));
            }
        }

        for (int i = 0; i < deckColor.length-1; i++) {
            for (int j = 1; j < deckValue.length-2; j++) {
                this.drawPile.add(new Card(deckColor[i], deckValue[j]));
            }
        }

        for (int i = 0; i < 4; i++) {
            this.drawPile.add(new Card(deckColor[4], deckValue[14]));
            this.drawPile.add(new Card(deckColor[4], deckValue[13]));
        }
    }

    public void shuffle() {
        Collections.shuffle(this.drawPile);
    }

    public Card topDrawPileCard() {
        // basically a pop function
        Card topCard = new Card(this.drawPile.get(drawPile.size()-1).color, this.drawPile.get(drawPile.size()-1).value);
        this.drawPile.remove(drawPile.size()-1);
        return topCard;
    }
}
