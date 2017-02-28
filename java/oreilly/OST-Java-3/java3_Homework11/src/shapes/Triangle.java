package shapes;

import interfaces.ComparableShape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Triangle extends Shape implements ComparableShape {
	private Color fillColor;
	private boolean fill;
	private int num_points = 3;
	private int area;
	private boolean s, t, u;
	
	public Triangle(int[] x_a, int[] y_a, Color lineColor, Color fillColor, boolean fill) {
		super(x_a, y_a, lineColor);
		this.fillColor = fillColor;
		this.fill = fill;
		setArea();
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		if (isFill()) {
			g.setColor(getFillColor());
			g.fillPolygon(getX_array_shape(), getY_array_shape(), getNum_points());
		}
		g.setColor(getLineColor());
		g.drawPolygon(getX_array_shape(), getY_array_shape(), getNum_points());
		g.setColor(oldColor);
		setArea();
	}
	
	private void setArea() {
		area = (int) (Math.abs((x_array_shape[0]-x_array_shape[2])*(y_array_shape[1]-y_array_shape[0])-
		         (x_array_shape[0]-x_array_shape[1])*(y_array_shape[2]-y_array_shape[0]))*0.5);
	}
	
	public int getArea() {
		return area;
	}

	public boolean containsLocation(int x, int y) {
		s = ((x - x_array_shape[1]) * (y_array_shape[0] - y_array_shape[1]) - (x_array_shape[0] - x_array_shape[1]) * (y - y_array_shape[1])) < 0.0f;
	    t = ((x - x_array_shape[2]) * (y_array_shape[1] - y_array_shape[2]) - (x_array_shape[1] - x_array_shape[2]) * (y - y_array_shape[2])) < 0.0f;
	    u = ((x - x_array_shape[0]) * (y_array_shape[2] - y_array_shape[0]) - (x_array_shape[2] - x_array_shape[0]) * (y - y_array_shape[0])) < 0.0f;
	    if ((s == t) && (t == u)) {
	    	return true;
	    }
	    return false; 
	} 
	
	public int getNum_points() {
		return num_points;
	}

	public void setNum_points(int num_points) {
		this.num_points = num_points;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public String toString() {
		/* return "Triangle: \n\tx = " + Arrays.toString(getX_array_shape()) + "\n\ty = " + Arrays.toString(getY_array_shape()) +
				"\n\t points = " + getNum_points(); */
		return "Triangle";		
	} 
}
