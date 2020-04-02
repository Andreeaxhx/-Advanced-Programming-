
/* am incarcat doar ConfigPanel si DrawingPanel pentru ca doar pe astea le-am modificat.
 * in princioiu, userul poate modifica numarul de laturi pe care le are figura (de la 3 la 20),
 *  precum si daca aceasta va fi colorata cu negru sau o culoare la intamplare.
 *  si cum am spus si in documentul pe care l-am trimis saptamana trecuta, doar butoanele
 *  save si exit functioneaza
 */


package lab6;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConfigPanel extends JPanel{

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
		sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 20, 1));
		
		 
		add(sidesLabel);
		add(sidesField);
		add(colorCombo);
	}
}
