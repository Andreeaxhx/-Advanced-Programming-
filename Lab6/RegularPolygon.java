package lab6;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RegularPolygon extends Polygon {

	public RegularPolygon(int x0, int y0, int radius, int sides) {
		double alpha = 2*Math.PI/sides;
		for(int i = 0; i<sides; i++) {
			double x= x0+radius*Math.cos(alpha*i);
			double y= y0+radius*Math.sin(alpha*i);
			this.addPoint((int) x, (int) y);
		}
	}

}
