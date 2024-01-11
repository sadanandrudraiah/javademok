package com.cruds.swingdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldExample extends JFrame {

    JTextField txtName;
    JPasswordField txtPwd;
    JLabel lblName;
    JLabel lblPwd;
    JButton btnClick;
    JPanel panel;

    public TextFieldExample() {
        setTitle("TextField Example");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        lblName = new JLabel("Name:");
        txtName = new JTextField(10);
        lblPwd = new JLabel("Password:");
        txtPwd = new JPasswordField(10);
        btnClick = new JButton("Login");

        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(txtName.getText());
                System.out.println(new String(txtPwd.getPassword()));
            }
        });

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblPwd);
        panel.add(txtPwd);
        panel.add(btnClick);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFieldExample();
            }
        });
    }
}

