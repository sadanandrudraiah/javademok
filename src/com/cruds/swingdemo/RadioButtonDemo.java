package com.cruds.swingdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class RadioButtonDemo extends JFrame implements ActionListener{

public RadioButtonDemo()
{
setSize(280, 200);
setTitle("Radio Button example");
setLocationRelativeTo(null);
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JRadioButton male = new JRadioButton("Male");
male.addActionListener(this);

JRadioButton female = new JRadioButton("FeMale");
female.addActionListener(this);

//create a button group
ButtonGroup group = new ButtonGroup();
group.add(male);
group.add(female);

JPanel panel = new JPanel();
panel.add(male);
panel.add(female);

add(panel);
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	System.out.println(e.getActionCommand());
}

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {

	@Override
	public void run() {
		new RadioButtonDemo();
	}
	});
	}
}

