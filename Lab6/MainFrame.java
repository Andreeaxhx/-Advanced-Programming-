package lab6;

import java.awt.*;
import java.awt.Frame;

import javax.swing.*;

public class MainFrame extends JFrame{

	ConfigPanel configPanel;
	ControlPanel controlPanel;
	DrawingPanel canvas;
	
	public MainFrame()
	{
		super("My Drawing Application");
		init();
	}
	
	private void init()
	{
		//Main Frame
		setTitle("Main Frame");
		setSize(600, 400);
		setLocation(0, 0);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//am initializat obiectele
		canvas = new DrawingPanel(this);
		configPanel = new ConfigPanel (this);
		controlPanel = new ControlPanel (this);
		//si le-am adaugat in main frame
		add(canvas, BorderLayout.CENTER);
		add(configPanel,BorderLayout.NORTH);
		add(controlPanel,BorderLayout.SOUTH);
		
		pack();
	}

}
