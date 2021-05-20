package com.KyleRuiz;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GameMenu extends JFrame implements ActionListener {
    JButton cardButton1;
    JButton cardButton2;
    JButton cardButton3;
    JButton cardButton4;
    JButton cardButton5;
    JButton cardButton6;
    JButton cardButton7;
    JButton cardButton8;
    JButton cardButton9;
    JButton cardButton10;
    JButton cardButton11;
    JButton cardButton12;
    JButton cardButton13;
    JButton cardButton14;

    JLabel playerNameLabel;
    JLabel activityPanelLabel;
    JTextArea activityTextArea;
    JScrollPane activityScrollPane;
    JLabel playersPanelLabel;
    JLabel statusPanelLabel;
    JTextArea playersTextArea;
    JScrollPane playersScrollPane;
    JTextArea statusTextArea;
    JScrollPane statusScrollPane;

    JLabel discardLabel;
    JPanel panel;
    JButton[] buttons;
    JButton applyButton;
    JButton drawButton;

    Game game;
    Timer timer;
    boolean applyPressed;
    boolean drawPressed;

    public GameMenu(String name) {
        cardButton1 = new JButton();
        cardButton2 = new JButton();
        cardButton3 = new JButton();
        cardButton4 = new JButton();
        cardButton5 = new JButton();
        cardButton6 = new JButton();
        cardButton7 = new JButton();
        cardButton8 = new JButton();
        cardButton9 = new JButton();
        cardButton10 = new JButton();
        cardButton11 = new JButton();
        cardButton12 = new JButton();
        cardButton13 = new JButton();
        cardButton14 = new JButton();

        buttons = new JButton[14];
        buttons[0] = cardButton1;
        buttons[1] = cardButton2;
        buttons[2] = cardButton3;
        buttons[3] = cardButton4;
        buttons[4] = cardButton5;
        buttons[5] = cardButton6;
        buttons[6] = cardButton7;
        buttons[7] = cardButton8;
        buttons[8] = cardButton9;
        buttons[9] = cardButton10;
        buttons[10] = cardButton11;
        buttons[11] = cardButton12;
        buttons[12] = cardButton13;
        buttons[13] = cardButton14;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("UNO");
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBounds(0, 0, 1920, 1080);
        panel.setLayout(null);

        applyButton = new JButton();
        applyButton.setFocusPainted(false);
        applyButton.addActionListener(this);
        applyButton.setText("Apply Card");
        applyButton.setForeground(Color.WHITE);
        applyButton.setBackground(Color.GRAY);
        applyButton.setBorder(new LineBorder(Color.WHITE));
        applyButton.setFont(new Font("Arial Black", Font.PLAIN, 30));
        applyButton.setBounds(1920-370, 10, 350, 50);

        JPanel cardPanel = new JPanel();
        cardPanel.setBounds(0, 1080-300, 1920, 300);
        cardPanel.setBackground(Color.GRAY);
        cardPanel.setLayout(null);

        JPanel activityPanel = new JPanel();
        activityPanel.setBounds(5, 5, 350, 770);
        activityPanel.setBackground(Color.GRAY);
        activityPanel.setLayout(null);

        JPanel playersPanel = new JPanel();
        playersPanel.setBounds(1920-370, 5, 350, 770/2);
        playersPanel.setBackground(Color.GRAY);
        playersPanel.setLayout(null);

        JPanel statusPanel = new JPanel();
        statusPanel.setBounds(1920-370, (770/2)+10, 350, (770/2)-5);
        statusPanel.setBackground(Color.GRAY);
        statusPanel.setLayout(null);

        playerNameLabel = new JLabel();
        playerNameLabel.setText(name + "'s Hand");
        playerNameLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setBounds(5, 10, 500, 50);

        activityPanelLabel = new JLabel();
        activityPanelLabel.setText("Activity Panel");
        activityPanelLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
        activityPanelLabel.setForeground(Color.WHITE);
        activityPanelLabel.setBounds(350/2-140, 0, 350, 50);

        playersPanelLabel = new JLabel();
        playersPanelLabel.setText("Players");
        playersPanelLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
        playersPanelLabel.setForeground(Color.WHITE);
        playersPanelLabel.setBounds(350/2-55, 0, 350, 50);

        statusPanelLabel = new JLabel();
        statusPanelLabel.setText("Status");
        statusPanelLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
        statusPanelLabel.setForeground(Color.WHITE);
        statusPanelLabel.setBounds(350/2-55, 0, 350, 50);


        discardLabel = new JLabel();
        discardLabel.setBounds((1920/2), 100, 390, 546);

        drawButton = new JButton();
        drawButton.setFocusPainted(false);
        drawButton.addActionListener(this);
        drawButton.setBackground(Color.WHITE);
        drawButton.setBounds((1920/2)-420, 100, 390, 546);
        drawButton.setIcon(new ImageIcon("large/card_back_alt_large.png"));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        drawButton.setBorder(emptyBorder);


        activityTextArea = new JTextArea();
        activityTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        activityTextArea.setEditable(false);
        activityTextArea.setLineWrap(true);
        activityTextArea.setWrapStyleWord(true);
        activityTextArea.setText(" -" + " Welcome to UNO! This panel will show every move a player makes.");

        activityScrollPane = new JScrollPane(activityTextArea);
        activityScrollPane.setBounds(7, 50, 335, 710);

        playersTextArea = new JTextArea();
        playersTextArea.setFont(new Font("Arial", Font.PLAIN, 26));
        playersTextArea.setEditable(false);
        playersTextArea.setLineWrap(true);
        playersTextArea.setWrapStyleWord(true);

        playersScrollPane = new JScrollPane(playersTextArea);
        playersScrollPane.setBounds(7, 50, 335, (710/2)-30);

        statusTextArea = new JTextArea();
        statusTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        statusTextArea.setEditable(false);
        statusTextArea.setLineWrap(true);
        statusTextArea.setWrapStyleWord(true);

        statusScrollPane = new JScrollPane(statusTextArea);
        statusScrollPane.setBounds(7, 50, 335, (710/2)-35);

        for (int i = 0; i < 14; i++) {
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            buttons[i].setBounds(136*i, 70, 130, 182);
        }

        panel.add(cardPanel);
        panel.add(activityPanel);
        panel.add(playersPanel);
        panel.add(statusPanel);
        for (int i = 0; i < 14; i++) {
            cardPanel.add(buttons[i]);
        }
        panel.add(discardLabel);
        panel.add(drawButton);
        playersPanel.add(playersPanelLabel);
        playersPanel.add(playersScrollPane);
        cardPanel.add(playerNameLabel);
        cardPanel.add(applyButton);
        statusPanel.add(statusPanelLabel);
        statusPanel.add(statusScrollPane);
        activityPanel.add(activityPanelLabel);
        activityPanel.add(activityScrollPane);
        this.add(panel);
        this.repaint();

        game = new Game(name);
        applyPressed = false;
        drawPressed = false;
        timer = new Timer(4000, (e)->tick());

        dealCards();
        startDiscardPile();
        startTurn();
        updateCardImage();
        updatePlayersTextArea();
        updateStatusTextArea();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cardButton1) {
            game.cardIndex = 0;
        } else if (e.getSource() == cardButton2) {
            game.cardIndex = 1;
        } else if (e.getSource() == cardButton3) {
            game.cardIndex = 2;
        } else if (e.getSource() == cardButton4) {
            game.cardIndex = 3;
        } else if (e.getSource() == cardButton5) {
            game.cardIndex = 4;
        } else if (e.getSource() == cardButton6) {
            game.cardIndex = 5;
        } else if (e.getSource() == cardButton7) {
            game.cardIndex = 6;
        } else if (e.getSource() == cardButton8) {
            game.cardIndex = 7;
        } else if (e.getSource() == cardButton9) {
            game.cardIndex = 8;
        } else if (e.getSource() == cardButton10) {
            game.cardIndex = 9;
        } else if (e.getSource() == cardButton11) {
            game.cardIndex = 10;
        } else if (e.getSource() == cardButton12) {
            game.cardIndex = 11;
        } else if (e.getSource() == cardButton13) {
            game.cardIndex = 12;
        } else if (e.getSource() == cardButton14) {
            game.cardIndex = 13;
        } else if (e.getSource() == applyButton) {
            applyPressed = true;
            if (((game.validColor.equals("any") && game.validValue.equals("any")) ||game.mainPlayer.hand.get(game.cardIndex).color.equals(game.validColor) || game.mainPlayer.hand.get(game.cardIndex).value.equals(game.validValue) || game.mainPlayer.hand.get(game.cardIndex).color.equals("wild"))) {
                activityTextArea.append("\n - " + game.mainPlayer.name + " has picked " + game.mainPlayer.hand.get(game.cardIndex).color + " " + game.mainPlayer.hand.get(game.cardIndex).value);
                if (!game.mainPlayer.hand.get(game.cardIndex).color.equals("wild") || game.mainPlayer.hand.get(game.cardIndex).color.equals("any")) {
                    setValid();
                    validCardPop();
                    updateDiscardImage();
                } else {
                    if (game.mainPlayer.hand.get(game.cardIndex).value.equals("color_changer")) {
                        discardLabel.setIcon(new ImageIcon("large/wild_colora_changer_large.png"));
                    } else if (game.mainPlayer.hand.get(game.cardIndex).value.equals("pick_four")) {
                        discardLabel.setIcon(new ImageIcon("large/wild_pick_four_large.png"));
                    }
                    validCardPop();
                }
                incrementCurrentPlayer();
            } else {
                new InvalidMenu();
            }
        } else if (e.getSource() == drawButton) {
            drawPressed = true;
            game.players.get(game.currentPlayer).draw(game.deck);
            int topCard = game.players.get(game.currentPlayer).hand.size()-1;
            activityTextArea.append("\n - " + game.mainPlayer.name + " has drawn from the draw pile and got a " + game.mainPlayer.hand.get(topCard).color + " " + game.mainPlayer.hand.get(topCard).value);
            if (game.players.get(game.currentPlayer).hand.get(topCard).color.equals(game.validColor) || game.players.get(game.currentPlayer).hand.get(topCard).value.equals(game.validValue)) {
                activityTextArea.append("\n - " + "Seems that that card picked from the pile is a valid card. That card will be played");
                Card validCard = new Card(game.players.get(game.currentPlayer).hand.get(topCard).color, game.players.get(game.currentPlayer).hand.get(topCard).value);
                game.players.get(game.currentPlayer).removeCard(topCard);
                game.deck.discardPile.add(validCard);
            }
            incrementCurrentPlayer();
        }

        if (!applyPressed && !drawPressed) {
            if (game.mainPlayer.hand.get(game.cardIndex).color.equals("wild")) {
                new ChangeColorMenu(this);
                game.validValue = "none";
            }
        }
        applyPressed = false;
        drawPressed = false;
    }

    void validCardPop() {
        Card validCard = new Card(game.mainPlayer.hand.get(game.cardIndex).color, game.mainPlayer.hand.get(game.cardIndex).value);
        game.mainPlayer.removeCard(game.cardIndex);
        game.deck.discardPile.add(validCard);
    }

    void tick() {
        newBotTurns();
        if (!game.deck.discardPile.get(game.deck.discardPile.size()-1).color.equals("wild")) {
            setValid();
            updateStatusTextArea();
        }

        this.repaint();
    }

    void newBotTurns() {
        if (game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
            updateCardImage();
            startTurn();
            return;
        }

        disableAllCardButtons();
        startTurn();
        updateDiscardImage();
        updateStatusTextArea();
        updatePlayersTextArea();
        this.repaint();
    }

    void checkWin() {
        for (int i = 0; i < game.players.size(); i++) {
            if (game.players.get(i).numCards == 0) {
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has gotten rid all their cards!");
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has WON!");
                timer.stop();
                this.dispose();
                new LeaderBoardMenu(game.players);
            }
        }
    }


    void startTurn() {
        checkWin();
        int topDiscard = game.deck.discardPile.size()-1;
        if (game.deck.discardPile.get(topDiscard).color.equals("wild") && game.deck.discardPile.get(topDiscard).value.equals("pick_four")) {
            if (!game.deck.discardPile.get(topDiscard).hasPlayed) {
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has to draw 4 cards");
                for (int i = 0; i < 4; i++) {
                    game.players.get(game.currentPlayer).draw(game.deck);
                }
                game.deck.discardPile.get(topDiscard).hasPlayed = true;
                incrementCurrentPlayer();
            } else {
                if (!game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
                    BotAI();
                }
            }
        } else if (game.deck.discardPile.get(topDiscard).value.equals("picker")) {
            if (!game.deck.discardPile.get(topDiscard).hasPlayed) {
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has to draw 2 cards");
                for (int i = 0; i < 2; i++) {
                    game.players.get(game.currentPlayer).draw(game.deck);
                }
                game.deck.discardPile.get(topDiscard).hasPlayed = true;
                incrementCurrentPlayer();
            } else {
                setValid();
                if (!game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
                    BotAI();
                }
            }
        } else if (game.deck.discardPile.get(topDiscard).value.equals("reverse")) {
            if (!game.deck.discardPile.get(topDiscard).hasPlayed) {
                if (game.direction == Game.gameDirection.CLOCKWISE) {
                    game.direction = Game.gameDirection.COUNTERCLOCKWISE;
                    activityTextArea.append("\n - " + "game direction is changed to counter clockwise");
                } else if (game.direction == Game.gameDirection.COUNTERCLOCKWISE) {
                    game.direction = Game.gameDirection.CLOCKWISE;
                    activityTextArea.append("\n - " + "game direction is changed to clockwise");
                }
                if (game.direction == Game.gameDirection.CLOCKWISE) {
                    game.currentPlayer = (game.currentPlayer + 2) % game.players.size();
                } else if (game.direction == Game.gameDirection.COUNTERCLOCKWISE) {
                    game.currentPlayer = (game.currentPlayer - 2) % game.players.size();
                    if (game.currentPlayer <= -1) {
                        game.currentPlayer = game.players.size()-1;
                    }
                }
                game.deck.discardPile.get(topDiscard).hasPlayed = true;
            } else {
                setValid();
                if (!game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
                    BotAI();
                }
            }
        } else if (game.deck.discardPile.get(topDiscard).value.equals("skip")) {
            if (!game.deck.discardPile.get(topDiscard).hasPlayed) {
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has been skipped and the next person starts");
                game.deck.discardPile.get(topDiscard).hasPlayed = true;
                incrementCurrentPlayer();
            } else {
                setValid();
                if (!game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
                    BotAI();
                }
            }
        } else if (game.deck.discardPile.get(topDiscard).value.equals("color_changer")) {
            // means if this shows up at the beginning of play the player can pick any card they want to establish the new color
            if (game.deck.discardPile.size() <= 1) {
                game.validColor = "any";
                game.validValue = "any";
            }
            if (!game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
                BotAI();
            }
        } else {
            setValid();
            if (!game.players.get(game.currentPlayer).name.equals(game.mainPlayer.name)) {
                BotAI();
            }
        }
    }

    void updateCardImage() {
        for (int i = 0; i < 14; i++) {
            buttons[i].setIcon(new ImageIcon("small/card_back_alt.png"));
            buttons[i].setEnabled(false);
        }
        for (int i = 0; i < game.mainPlayer.hand.size(); i++) {
            buttons[i].setIcon(new ImageIcon("small/"+game.mainPlayer.hand.get(i).color+"_"+game.mainPlayer.hand.get(i).value+".png"));
            buttons[i].setEnabled(true);
        }
    }

    void updatePlayersTextArea() {
        playersTextArea.setText("");
        for (int i = 0; i < game.players.size(); i++) {
            playersTextArea.append(i+1 + ". " + game.players.get(i).name + ": " + game.players.get(i).numCards + " cards remaining\n");
        }
    }

    void updateStatusTextArea() {
        statusTextArea.setText("");
        statusTextArea.append("Game Direction: " + game.direction + "\n");
        statusTextArea.append("Current Player: " + game.players.get(game.currentPlayer).name + "\n");
        statusTextArea.append("Valid Color: " + game.validColor + "\n");
        statusTextArea.append("Valid Value: "+ game.validValue + "\n");
    }

    void callBack(String color) {
        game.validColor = color;
    }

    void incrementCurrentPlayer() {
        if (game.direction == Game.gameDirection.CLOCKWISE) {
            game.currentPlayer = (game.currentPlayer + 1) % game.players.size();
        } else if (game.direction == Game.gameDirection.COUNTERCLOCKWISE) {
            game.currentPlayer = (game.currentPlayer - 1) % game.players.size();
            if (game.currentPlayer == -1) {
                game.currentPlayer = game.players.size()-1;
            }
        }
    }

    void dealCards() {
        for (int i = 0; i < game.players.size(); i++) {
            for (int j = 0; j < 7; j++) {
                game.players.get(i).draw(game.deck);
            }
        }
    }

    void setValid() {
        game.validColor = game.deck.discardPile.get(game.deck.discardPile.size()-1).color;
        game.validValue = game.deck.discardPile.get(game.deck.discardPile.size()-1).value;
    }

    void startDiscardPile() {
        game.deck.discardPile.add(game.deck.topDrawPileCard());
        setValid();
        int topDiscard = game.deck.discardPile.size()-1;
        if (game.deck.discardPile.get(topDiscard).color.equals("wild") && game.deck.discardPile.get(topDiscard).value.equals("pick_four")) {
            game.deck.drawPile.add(0, new Card(game.deck.discardPile.get(topDiscard).color, game.deck.discardPile.get(topDiscard).value));
            game.deck.discardPile.clear();
            startDiscardPile();
        }
        updateDiscardImage();
    }

    void updateDiscardImage() {
        int topDiscard = game.deck.discardPile.size()-1;
        if (game.deck.discardPile.get(topDiscard).color.equals("wild") && game.deck.discardPile.get(topDiscard).value.equals("color_changer")) {
            discardLabel.setIcon(new ImageIcon("large/"+game.deck.discardPile.get(topDiscard).color+"_colora_changer_large.png"));
        } else {
            discardLabel.setIcon(new ImageIcon("large/"+game.deck.discardPile.get(topDiscard).color+"_"+game.deck.discardPile.get(topDiscard).value+"_"+"large.png"));
        }
        panel.repaint();
        panel.revalidate();
    }

    void disableAllCardButtons() {
        for (int i = 0; i < 14; i++) {
            buttons[i].setEnabled(false);
        }
    }

    boolean checkValidCards() {
        boolean hasValid = false;
        for (int i = 0; i < game.players.get(game.currentPlayer).hand.size(); i++) {
            if (game.players.get(game.currentPlayer).hand.get(i).color.equals(game.validColor)) {
                hasValid = true;
            } else if (game.players.get(game.currentPlayer).hand.get(i).value.equals(game.validValue)) {
                hasValid = true;
            } else if (game.players.get(game.currentPlayer).hand.get(i).color.equals("wild")) {
                hasValid = true;
            }
        }
        return hasValid;
    }

    void BotAI() {
        boolean hasValid = checkValidCards();
        if (hasValid) {
            int indexNum = pickCard();
            Card validCard = new Card(game.players.get(game.currentPlayer).hand.get(indexNum).color, game.players.get(game.currentPlayer).hand.get(indexNum).value);
            game.players.get(game.currentPlayer).removeCard(indexNum);
            game.deck.discardPile.add(validCard);
            activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has picked " + game.deck.discardPile.get(game.deck.discardPile.size()-1).color + " " + game.deck.discardPile.get(game.deck.discardPile.size()-1).value);
            incrementCurrentPlayer();
        } else {
            game.players.get(game.currentPlayer).draw(game.deck);
            int topCard = game.players.get(game.currentPlayer).hand.size()-1;
            activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " does not have a valid card in their hand. The player will now draw a card in the draw pile.");
            if (game.players.get(game.currentPlayer).hand.get(topCard).color.equals(game.validColor) || game.players.get(game.currentPlayer).hand.get(topCard).value.equals(game.validValue)) {
                activityTextArea.append("\n - " + "Seems that the " + game.players.get(game.currentPlayer).hand.get(topCard).color + " " + game.players.get(game.currentPlayer).hand.get(topCard).value + " that " + game.players.get(game.currentPlayer).name  + " picked from the draw pile is valid card. That card will be played");
                Card validCard = new Card(game.players.get(game.currentPlayer).hand.get(topCard).color, game.players.get(game.currentPlayer).hand.get(topCard).value);
                game.players.get(game.currentPlayer).removeCard(topCard);
                game.deck.discardPile.add(validCard);
            }
            incrementCurrentPlayer();
        }
    }

    int pickCard() {
        // checking if someone has reached a low amount of cards that will trigger the ability to prioritize getting rid of special and wild cards.
        boolean lowCards = false;
        for (int i = 0; i < game.players.size(); i++) {
            if (game.players.get(i).numCards <= 3) {
                lowCards = true;
            }
        }

        // here we are differentiating our numerical cards and special cards
        HashMap<Integer, Integer> validCards = new HashMap<Integer, Integer>();
        ArrayList<Integer> validSpecial = new ArrayList<Integer>();
        ArrayList<Integer> wild = new ArrayList<Integer>();
        for (int i = 0; i < game.players.get(game.currentPlayer).hand.size(); i++) {
            if (game.players.get(game.currentPlayer).hand.get(i).color.equals(game.validColor) || game.players.get(game.currentPlayer).hand.get(i).value.equals(game.validValue) || game.players.get(game.currentPlayer).hand.get(i).color.equals("wild")) {
                if (game.players.get(game.currentPlayer).hand.get(i).value.equals("picker") || game.players.get(game.currentPlayer).hand.get(i).value.equals("reverse") || game.players.get(game.currentPlayer).hand.get(i).value.equals("skip")) {
                    validSpecial.add(i);
                } else if (game.players.get(game.currentPlayer).hand.get(i).color.equals("wild")) {
                    wild.add(i);
                } else {
                    validCards.put(Integer.valueOf(game.players.get(game.currentPlayer).hand.get(i).value), i);
                }
            }
        }

        // putting hashmaps into tree maps sorts the dictionary by the key
        TreeMap<Integer, Integer> sortedCards = new TreeMap<>(validCards);

        // we want to ask if we see a 0 card inside of that tree map
        boolean hasZero = false;
        for (Map.Entry<Integer, Integer> entry : sortedCards.entrySet()) {
            if (entry.getKey() == 0) {
                hasZero = true;
            }
        }

        // putting that tree map's indexes into an array list so we can access the elements
        ArrayList<Integer> sortedNumericalIndex = new ArrayList<>();
        for (int value : sortedCards.values()) {
            sortedNumericalIndex.add(value);
        }

        // when there are no low cards we want to prioritize getting rid of our numerical cards since they are abundant and cost less points
        // at the end of the game we start seeing players with less cards we want to get rid of the special and wild cards because
        // they are worth more points and will be damaging if we keep them after someone get rid of all of their cards

        int red = 0;
        int blue = 0;
        int yellow = 0;
        int green = 0;

        for (int i = 0; i < game.players.get(game.currentPlayer).hand.size(); i++) {
            String color = game.players.get(game.currentPlayer).hand.get(i).color;
            switch (color) {
                case "red":
                    red += 1;
                    break;
                case "green":
                    green += 1;
                    break;
                case "blue":
                    blue += 1;
                    break;
                case "yellow":
                    yellow += 1;
                    break;
            }
        }
        HashMap<Integer, String> numColors = new HashMap<Integer, String>();
        numColors.put(red, "red");
        numColors.put(green, "green");
        numColors.put(blue, "blue");
        numColors.put(yellow, "yellow");
        TreeMap<Integer, String> sortedNumColors = new TreeMap<>(numColors);
        ArrayList<String> sortedColorNames = new ArrayList<>();
        for (String value : sortedNumColors.values()) {
            sortedColorNames.add(value);
        }
        String frequentColor = sortedColorNames.get(sortedColorNames.size() - 1);

        if (!lowCards) {
            if (!sortedNumericalIndex.isEmpty()) {
                if (hasZero) {
                    // return the first element which should be zero
                    return sortedNumericalIndex.get(0);
                } else {
                    // if there was no zero found return the last element of the list which should the highest valid numerical card
                    return sortedNumericalIndex.get(sortedNumericalIndex.size() - 1);
                }
            } else if (!validSpecial.isEmpty()) {
                return validSpecial.get(0);
            } else if (!wild.isEmpty()) {
                // here we would like to analyze the hand for the most frequent color that appears
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has changed the color to " + frequentColor);
                game.validColor = frequentColor;
                game.validValue = "none";
                return wild.get(0);
            }
        } else if (lowCards) {
            // our priorities are switched once the cards start getting low because not we want to start getting rid of our high point value cards
            // which are specials and wilds.
            if (!wild.isEmpty()) {
                activityTextArea.append("\n - " + game.players.get(game.currentPlayer).name + " has changed the color to " + frequentColor);
                game.validColor = frequentColor;
                game.validValue = "none";
                return wild.get(0);
            } else if (!validSpecial.isEmpty()) {
                return validSpecial.get(0);
            } else if (!sortedNumericalIndex.isEmpty()) {
                if (hasZero) {
                    return sortedNumericalIndex.get(0);
                } else {
                    return sortedNumericalIndex.get(sortedNumericalIndex.size() - 1);
                }
            }
        }
        return 0;
    }
}
