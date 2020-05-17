package lab6;

import java.awt.*;
import java.awt.Frame;

import javax.swing.*;

public class MainFrame extends JFrame{

	public MainFrame()
	{
		super("My Drawing Application");
		init();
	}
	
	private void init()
	{
		setTitle("Main Frame");
		setSize(600, 400);
		setLocation(0, 0);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
	}

}
