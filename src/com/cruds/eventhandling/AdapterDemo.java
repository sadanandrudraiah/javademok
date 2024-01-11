package com.cruds.eventhandling;

import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdapterDemo extends Applet {
	
	@Override
	public void init() {
		addMouseListener(new MyMouseAdapter(this));
	}

}


//listener
class MyMouseAdapter extends MouseAdapter
{
	Applet app;
	MyMouseAdapter(Applet app)
	{
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		app.showStatus("Mouse Clicked ********");
		
	}
}
