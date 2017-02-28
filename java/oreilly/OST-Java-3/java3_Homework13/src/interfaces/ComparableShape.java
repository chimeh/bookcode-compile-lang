package interfaces;

import java.awt.Color;

/*
 * Interface for closed shapes.  Shapes that implements this interface 
 * has area, has fill color, and shape can be filled. 
 */
public interface ComparableShape {
	public abstract int getArea();

	public abstract void setFillColor(Color fillColor);

	public abstract void setFill(boolean fill);
}
