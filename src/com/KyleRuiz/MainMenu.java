package com.KyleRuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    JButton playButton;
    JButton closeButton;
    ImageIcon unoLogo;
    JLabel unoLogoLabel;

    public MainMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("UNO");
        this.setLayout(null);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        unoLogo = new ImageIcon(new ImageIcon("uno_logo.png").getImage().getScaledInstance(640/2, 480/2, Image.SCALE_DEFAULT));
        unoLogoLabel = new JLabel();
        unoLogoLabel.setIcon(unoLogo);
        unoLogoLabel.setBounds(160, 10, 640/2, 480/2);

        playButton = new JButton();
        playButton.setText("PLAY");
        playButton.addActionListener(this);
        playButton.setFocusPainted(false);
        playButton.setBounds(640/2-300/2, 270, 300, 50);
        playButton.setFont(new Font("Arial", Font.BOLD, 22));
        playButton.setBackground(Color.gray);
        playButton.setForeground(Color.white);

        closeButton = new JButton();
        closeButton.setText("EXIT");
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(this);
        closeButton.setBounds(640/2-300/2, 270+60, 300, 50);
        closeButton.setFont(new Font("Arial", Font.BOLD, 22));
        closeButton.setBackground(Color.gray);
        closeButton.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 500);
        panel.setLayout(null);
        panel.setBackground(Color.white);

        this.add(panel);
        panel.add(playButton);
        panel.add(closeButton);
        panel.add(unoLogoLabel);
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            new NameMenu();
            this.dispose();
        }
        if (e.getSource() == closeButton) {
            this.dispose();
        }
    }
}
