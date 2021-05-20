package com.KyleRuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvalidMenu extends JFrame implements ActionListener {

    JLabel invalidLabel;
    JButton okButton;

    public InvalidMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("UNO");
        this.setLayout(null);
        this.setSize(490, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        invalidLabel = new JLabel();
        invalidLabel.setText("You have chosen an invalid card. Please try again!");
        invalidLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        invalidLabel.setForeground(Color.BLACK);
        invalidLabel.setBounds(10, 5, 500, 50);

        okButton = new JButton();
        okButton.setText("OK");
        okButton.addActionListener(this);
        okButton.setFont(new Font("Arial", Font.PLAIN, 16));
        okButton.setFocusPainted(false);
        okButton.setBounds(370, 80, 100, 25);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 490, 150);
        panel.setLayout(null);

        this.add(panel);
        panel.add(okButton);
        panel.add(invalidLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            this.dispose();
        }
    }
}
