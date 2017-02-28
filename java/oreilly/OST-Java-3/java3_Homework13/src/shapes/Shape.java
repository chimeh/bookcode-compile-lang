package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	private int x, y;
	private Color lineColor;
	protected int[] x_array_shape = {};
	protected int[] y_array_shape = {};

	/*
	 * Constructor for Shape object.
	 */
	public Shape(int x, int y, Color lineColor) {
		this.x = x;
		this.y = y;
		this.lineColor = lineColor;
	}

	/*
	 * Overloaded constructor to be used with the Triangle object.
	 */
	public Shape(int[] x_array_shape, int[] y_array_shape, Color lineColor) {
		this.x_array_shape = x_array_shape;
		this.y_array_shape = y_array_shape;
		this.lineColor = lineColor;
	}

	public int[] getX_array_shape() {
		return x_array_shape;
	}

	public void setX_array_shape(int[] x_array_shape) {
		this.x_array_shape = x_array_shape;
	}

	public int[] getY_array_shape() {
		return y_array_shape;
	}

	public void setY_array_shape(int[] y_array_shape) {
		this.y_array_shape = y_array_shape;
	}

	/*
	 * All shapes should have a draw method.
	 */
	public abstract void draw(Graphics g);

	/*
	 * All shapes should have a containsLocation method.
	 */
	public abstract boolean containsLocation(int x, int y);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
}
