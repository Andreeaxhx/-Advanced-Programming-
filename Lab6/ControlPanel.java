package lab6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ControlPanel extends JPanel{
	final MainFrame frame;
	JButton saveBtn = new JButton ("Save");
	JButton loadBtn = new JButton ("Load");
	JButton resetBtn = new JButton ("Reset");
	JButton exitBtn = new JButton ("Exit");
	
	public ControlPanel (MainFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		setLayout(new GridLayout(1, 4));
		
		//aici am afisat butoanele
		add(saveBtn); //functioneaza
		add(loadBtn);
		add(resetBtn);
		add(exitBtn); //dar doar exit functioneaza
		
		saveBtn.addActionListener(this::save);
		exitBtn.addActionListener(this::exit);
	}
	
	private void save(ActionEvent e) {
		try {
			ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
		}   catch (IOException ex) {System.err.println(ex);}
	}
	
	//exit
	private void exit(ActionEvent e) {
		System.exit(0);
	}

}
