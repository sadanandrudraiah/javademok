package com.cruds.eventhandling;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventDemo extends Applet implements KeyListener {

	String str = "";
	
	@Override
	public void init() {
		addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString(str, 10, 10);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		str = str + e.getKeyChar();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		showStatus("key Released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		showStatus("Key Typed");
	}

}
