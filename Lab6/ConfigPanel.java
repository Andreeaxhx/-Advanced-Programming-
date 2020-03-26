package lab6;

import java.awt.*;
import javax.swing.*;

public class ConfigPanel extends JPanel{

	//MainFrame frame = new MainFrame();
	
	final MainFrame frame;
	JLabel sidesLabel;
	JSpinner sidesField;
	JComboBox colorCombo;
	
	public ConfigPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}
	
	private void init() {
	
		sidesLabel = new JLabel("Number of sides:");
		String colors[] = { "Black", "Color"}; //optiunile pentru culori, insa deocamdata nu se pot schimba de catre user
		colorCombo = new JComboBox(colors);
		
		sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		sidesField.setValue(6);
		
		add(sidesLabel);
		add(sidesField);
		add(colorCombo);
        
	}
}
