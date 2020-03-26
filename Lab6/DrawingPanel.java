
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
		int sides=6; //aici nu am reusit sa ii atribui lui sides valoare pe care o alege userul, dar o sa incerc pentru saptamana viitoare
		
		Random r = new Random(); //am creat o variabila de tip random pe care sa o folosesc la generarea culorii
		Color color=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),65); //se alege random o culoare iar opacitatea am setat-o 65
		graphics.setColor(color);
		graphics.fill(new RegularPolygon(x, y, radius, sides));
	}
	
	@Override
	public void update (Graphics g) {}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}
