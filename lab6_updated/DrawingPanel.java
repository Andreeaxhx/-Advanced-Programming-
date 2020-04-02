
package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.util.*;
public class DrawingPanel extends JPanel {

	final MainFrame frame;
	final static int W=800, H=600;

	BufferedImage image;
	Graphics2D graphics;
	
	public DrawingPanel(MainFrame frame) {
		
		this.frame = frame;
		createOffscreenImage();
		init();
		
	}
	
	private void createOffscreenImage() {
		
		image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, W, H);
	}
	
	private void init() {
		setPreferredSize(new Dimension(W, H));
		setBorder(BorderFactory.createEtchedBorder());
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawShape(e.getX(), e.getY()); repaint();	
			}
		});
	}
	
	private void drawShape(int x, int y){
		int radius=(int)(10+Math.random()*200); //am generat un numar random
		
		int sides=(int)frame.configPanel.sidesField.getValue(); // se atribuie lui sides valoarea aleasa de user
		
		Random r = new Random(); //am creat o variabila de tip random pe care sa o folosesc la generarea culorii
		
		Color color=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),150); //se seteaza random o culoare random cu opacitatea 150
		Color color1 = new Color(0, 0, 0, 150); // se seteaza culoarea negru cu opacitatea 150
		
		if(frame.configPanel.colorCombo.getSelectedIndex() == 0) // se verifica optiunea aleasa de user
			graphics.setColor(color1); // daca s-a ales culoarea negru, atunci figurile vor fi desenate cu negru
		else graphics.setColor(color); // similar pentru optiunea "color"
		
		graphics.fill(new RegularPolygon(x, y, radius, sides));
	}
	
	@Override
	public void update (Graphics g) {}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}
