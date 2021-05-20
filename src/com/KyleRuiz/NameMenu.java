package com.KyleRuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameMenu extends JFrame implements ActionListener {

    JLabel nameLabel;
    JTextField nameTextField;
    JButton submitButton;
    JButton cancelButton;

    public NameMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("UNO");
        this.setLayout(null);
        this.setSize(490, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        nameLabel = new JLabel();
        nameLabel.setText("Enter your name:");
        nameLabel.setBounds(10, 10, 150, 20);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        nameTextField = new JTextField();
        nameTextField.setBounds(10+150, 10, 300, 25);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton();
        submitButton.setText("SUBMIT");
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(360, 70, 100, 25);
        submitButton.setBackground(Color.gray);
        submitButton.setForeground(Color.white);

        cancelButton = new JButton();
        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(this);
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(360-110, 70, 100, 25);
        cancelButton.setBackground(Color.gray);
        cancelButton.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 500);
        panel.setLayout(null);

        this.add(panel);
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(submitButton);
        panel.add(cancelButton);
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            this.dispose();
            new MainMenu();
        }

        if (e.getSource() == submitButton) {
            if (nameTextField.getText().equals("")) {
                new GameMenu("Player");
            } else {
                new GameMenu(nameTextField.getText());
            }
            this.dispose();
        }
    }
}
