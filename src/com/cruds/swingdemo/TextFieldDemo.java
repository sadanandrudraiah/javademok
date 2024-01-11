package com.cruds.swingdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.cruds.db.StudentDAO;
import com.cruds.entity.Student;
import com.cruds.exception.SMSException;

public class TextFieldDemo extends JFrame{
	
	private JLabel lblRollNo;
	private JTextField txtRollNo;
	private JLabel lblName;
	private JTextField txtName;
	private JButton btnCreate;
	private JPanel panel;
	
	
	public TextFieldDemo(){
		setTitle("Text Field Demo");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		lblRollNo = new JLabel("Roll No");
		txtRollNo = new JTextField(5);
		lblName = new JLabel("Name");
		txtName = new JTextField(5);
		btnCreate = new JButton("Create");
		
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strRollNo = txtRollNo.getText();
				String strName = txtName.getText();
				
				if(strRollNo.trim().equals("") || strName.trim().equals(""))
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, "Roll No or Name cannot be empty",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			//	System.out.println(strRollNo + ":" + strName);
				try
				{
					Student s = new Student(Integer.parseInt(strRollNo), strName);
				
				StudentDAO dao = new StudentDAO();
				if(dao.Create(s))
				{
					JOptionPane.showMessageDialog(panel, "Student Created Successfully",
							"Success", JOptionPane.INFORMATION_MESSAGE);
					
					txtRollNo.setText("");
					txtName.setText("");
				}
			}catch(NumberFormatException nfe)
				{
				getToolkit().beep();
				JOptionPane.showMessageDialog(panel, "Inavlid Roll No, it has to be number",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				}catch (SMSException smse) 
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, smse.getInfo(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		
		panel.add(lblRollNo);
		panel.add(txtRollNo);
		panel.add(lblName);
		panel.add(txtName);
		panel.add(btnCreate);
		add(panel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TextFieldDemo();// work item
			}
		});
		
	}

}
