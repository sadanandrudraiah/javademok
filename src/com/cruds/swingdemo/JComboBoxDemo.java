package com.cruds.swingdemo;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JComboBoxDemo  extends JFrame {
	

		final String[] deptId = {"101","102","103"};
		final String[] deptNames = {"Sales","HR","MKT"};

		private JLabel lblDept = null;
		private JComboBox<String> deptCombo = new JComboBox<String>(deptId);
		private JPanel panel;

		public JComboBoxDemo()
		{
		setTitle("JComboBox Demo");
		setSize(300, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		panel = new JPanel();

		lblDept = new JLabel();
		lblDept.setPreferredSize(new Dimension(100, 127));
		lblDept.setMaximumSize(new Dimension(100, 127));

		panel.add(lblDept);

		deptCombo.setSelectedIndex(-1);
		deptCombo.setPreferredSize(new Dimension(140, 22));
		deptCombo.setMaximumSize(new Dimension(140, 22));


		deptCombo.addItemListener(new ItemListener() {

		//@Override
		public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED)
		{
		int index = deptCombo.getSelectedIndex();
		String deptName = deptNames[index];
		lblDept.setText(deptName);
		}}
		});
		panel.add(deptCombo);
		add(panel);
		}
		public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		new JComboBoxDemo();
		}
		}); }}




