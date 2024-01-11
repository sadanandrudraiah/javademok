package com.cruds.swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaEx extends JFrame {
    JTextArea area;

    public TextAreaEx() {
        setTitle("JTextArea");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane pane = new JScrollPane();
        area = new JTextArea();

        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        pane.setViewportView(area);

        JButton btn = new JButton("Submit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(area.getText());
            }
        });

        panel.add(pane);
        panel.add(btn, BorderLayout.SOUTH);

        add(panel);
        setSize(new Dimension(350, 300));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextAreaEx();
            }
        });
    }
}

