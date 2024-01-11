package com.cruds.swingdemo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CustomCardLayoutExample extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public CustomCardLayoutExample() {
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();

        card1.add(new JLabel("This is Card 1"));
        card2.add(new JLabel("Welcome to Card 2"));

        cardPanel.add(card1, "Card 1");
        cardPanel.add(card2, "Card 2");

        JButton showCard1Button = new JButton("Show Card 1");
        JButton showCard2Button = new JButton("Show Card 2");

        showCard1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Card 1");
            }
        });

        showCard2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Card 2");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showCard1Button);
        buttonPanel.add(showCard2Button);

        add(cardPanel);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomCardLayoutExample());
    }
}

