package com.cruds.swingdemo;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloFrame extends Frame {
	
	HelloFrame()
	{
		setTitle("Hello Frame");
		setSize(100, 100);
		setLocation(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		HelloFrame f = new HelloFrame();
		
		f.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
