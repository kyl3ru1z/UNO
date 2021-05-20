package com.KyleRuiz;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class LeaderBoardMenu extends JFrame implements ActionListener {
    JLabel leaderboardTitleLabel;
    JLabel boxLabel1;
    JLabel boxLabel2;
    JLabel boxLabel3;
    JLabel boxLabel4;
    JButton mainMenuButton;
    JPanel grayPanel;
    JPanel panel;

    HashMap<Integer, String> playerDictionary;
    TreeMap<Integer, String> sortedPlayers;
    ArrayList<String> sortedNames;
    ArrayList<Integer> sortedScore;

    public LeaderBoardMenu(ArrayList<Player> players) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("UNO");
        this.setLayout(null);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBounds(0, 0, 640, 480);
        panel.setLayout(null);

        leaderboardTitleLabel = new JLabel();
        leaderboardTitleLabel.setBounds(480/2-210, 5, 300, 50);
        leaderboardTitleLabel.setText("Leaderboard");
        leaderboardTitleLabel.setFont(new Font("Arial Black", Font.BOLD, 36));
        leaderboardTitleLabel.setForeground(Color.white);

        grayPanel = new JPanel();
        grayPanel.setBounds(480/2-80, 0, 640/2, 370);
        grayPanel.setFont(new Font("Arial Black", Font.BOLD, 36));;
        grayPanel.setBackground(Color.gray);
        grayPanel.setLayout(null);

        mainMenuButton = new JButton();
        mainMenuButton.setText("Main Menu");
        mainMenuButton.addActionListener(this);
        mainMenuButton.setFocusPainted(false);
        mainMenuButton.setBounds(640/2-300/2-11, 373, 322, 65);
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 22));
        mainMenuButton.setBackground(Color.gray);
        mainMenuButton.setForeground(Color.white);
        mainMenuButton.setBorder(new LineBorder(Color.WHITE));

        boxLabel1 = new JLabel();
        boxLabel1.setBounds(480/2-210, 80, 260, 50);
        boxLabel1.setFont(new Font("Arial", Font.BOLD, 22));
        boxLabel1.setBackground(Color.gray);
        boxLabel1.setForeground(Color.white);
        boxLabel1.setBorder(new LineBorder(Color.WHITE));
        boxLabel1.setOpaque(true);

        boxLabel2 = new JLabel();
        boxLabel2.setBounds(480/2-210, 140, 260, 50);
        boxLabel2.setFont(new Font("Arial", Font.BOLD, 22));
        boxLabel2.setBackground(Color.gray);
        boxLabel2.setForeground(Color.white);
        boxLabel2.setBorder(new LineBorder(Color.WHITE));
        boxLabel2.setOpaque(true);

        boxLabel3 = new JLabel();
        boxLabel3.setBounds(480/2-210, 200, 260, 50);
        boxLabel3.setFont(new Font("Arial", Font.BOLD, 22));
        boxLabel3.setBackground(Color.gray);
        boxLabel3.setForeground(Color.white);
        boxLabel3.setBorder(new LineBorder(Color.WHITE));
        boxLabel3.setOpaque(true);

        boxLabel4 = new JLabel();
        boxLabel4.setBounds(480/2-210, 260, 260, 50);
        boxLabel4.setFont(new Font("Arial", Font.BOLD, 22));
        boxLabel4.setBackground(Color.gray);
        boxLabel4.setForeground(Color.white);
        boxLabel4.setBorder(new LineBorder(Color.WHITE));
        boxLabel4.setOpaque(true);

        this.add(panel);
        panel.add(mainMenuButton);
        panel.add(grayPanel);
        grayPanel.add(leaderboardTitleLabel);
        grayPanel.add(boxLabel1);
        grayPanel.add(boxLabel2);
        grayPanel.add(boxLabel3);
        grayPanel.add(boxLabel4);

        playerDictionary = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            playerDictionary.put(players.get(i).score, players.get(i).name);
        }
        sortedPlayers = new TreeMap<>(playerDictionary);
        sortedNames = new ArrayList<>();
        sortedScore = new ArrayList<>();
        for (String value : sortedPlayers.values()) {
            sortedNames.add(value);
        }
        for (int key : sortedPlayers.keySet()) {
            sortedScore.add(key);
        }
        boxLabel1.setText(" [1st] " + sortedNames.get(0) + " - " + sortedScore.get(0) + " points");
        boxLabel2.setText(" [2nd] " + sortedNames.get(1) + " - " + sortedScore.get(1) + " points");
        boxLabel3.setText(" [3rd] " + sortedNames.get(2) + " - " + sortedScore.get(2) + " points");
        boxLabel4.setText(" [4th] " + sortedNames.get(3) + " - " + sortedScore.get(3) + " points");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainMenuButton) {
            this.dispose();
            new MainMenu();
        }
    }
}
