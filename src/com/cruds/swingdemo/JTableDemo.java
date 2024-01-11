package com.cruds.swingdemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.cruds.db.StudentDAO;

public class JTableDemo extends JFrame{
	
	private JTable table;
//	private Object[] colNames = {"Roll No", "Name"};
//	private Object[][] data = {{"101","Sagar"},{"202","Keerthi"}};
	Vector<String> colNames = new Vector<>();
//	Vector<Vector<String>> data = new Vector<>();
	
	private JPanel panel;
	private JScrollPane scrpane;
	private JButton btnDelete;
	private StudentDAO dao = new StudentDAO();
	
	public JTableDemo()
	{
		setTitle("JTable Demo");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		colNames.add("Roll No");
		colNames.add("Name");
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int idx = table.getSelectedRow();
				String strRollNo = (String) table.getModel().getValueAt(idx, 0);
			//	System.out.println(strRollNo);
				dao.delete(Integer.parseInt(strRollNo));
				table.setModel(new DefaultTableModel(dao.getTableData(), colNames));

				
			//	data.remove(idx);
				
							
			}
		});
		
		panel = new JPanel();
		table = new JTable(new DefaultTableModel(dao.getTableData(), colNames));
		scrpane = new JScrollPane(table);
		
		panel.add(scrpane);
		add(panel);
		add(btnDelete, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JTableDemo();// work item
				
			}
		});
	}
}
