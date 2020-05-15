package lab12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")

public class MainFrame extends JPanel implements ActionListener {
	
	JPanel jPanel3 = new JPanel(); // panel to hold buttons
	
	JTextField text = new JTextField(20);
	
	String[] components = new String[] { "Button", "Spinner", "CheckBox", "ComboBox", "Menu", "RadioButton" };
	SpinnerListModel comp = new SpinnerListModel(components);
	JSpinner spinner = new JSpinner(comp);

	JButton create = new JButton("Create");
	
	public MainFrame() {
		
		create.addActionListener(e -> {
			final JButton newButton = new JButton("A fost creat un buton!");
			newButton.addActionListener(e2 -> {
				jPanel3.remove(newButton);
				jPanel3.revalidate();
				jPanel3.repaint();
			});
			jPanel3.add(newButton);
			jPanel3.revalidate();
			jPanel3.repaint();
		});

		JPanel bottomPanel = new JPanel();
		
		bottomPanel.add(spinner);
		bottomPanel.add(text);
		bottomPanel.add(create);

		
		text.addActionListener(this);
		
		jPanel3.setLayout(new GridLayout(0, 1));

		
		JPanel borderLayoutPanel = new JPanel(new BorderLayout());
		borderLayoutPanel.add(jPanel3, BorderLayout.PAGE_START);
	
		JScrollPane scrollPane = new JScrollPane(borderLayoutPanel);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


		setPreferredSize(new Dimension(400, 200));
		
		setLayout(new BorderLayout());
		
		add(scrollPane, BorderLayout.CENTER);
		
		add(bottomPanel, BorderLayout.NORTH);
	}
	
public void actionPerformed(ActionEvent e) {
	
	String s1 = text.getText();
	System.out.println(s1);
	/*JButton clicked = (JButton) e.getSource();
	
	if(clicked==create) System.out.println(s1);
	else System.out.println(s1);*/
}

	private static void createAndShowGui() {
		MainFrame mainFrame = new MainFrame();
		JFrame frame = new JFrame("Main Frame");

		frame.setSize(600, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainFrame);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createAndShowGui());
		System.out.println();
	}

	

}
