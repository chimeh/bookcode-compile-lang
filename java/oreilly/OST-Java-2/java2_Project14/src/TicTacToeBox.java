import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

public class TicTacToeBox extends ClickableBox {
	private boolean mask;
	private Color maskColor;
	Container parent;
		
	public TicTacToeBox(int x, int y, int width, int height, Color borderColor,
			Color backColor, boolean drawBorder, Container parent, String boardChar) {
		super(x, y, width, height, borderColor, backColor, drawBorder, parent, boardChar);
		this.parent = parent;
	}
	
	public void draw(Graphics g) {
		super.draw(g);			
		if (mask) {
			g.setColor(Color.cyan);
			g.fillRect(getX(), getY(), getWidth(), getHeight());
			if (isDrawBorder()) {
				g.setColor(getBorderColor());
				g.drawRect(getX(), getY(), getWidth(), getHeight());
			}
			g.setColor(Color.black);
			g.drawString(getBoardChar(), getX()+8, getY()+14);
		}
	}
	
	public boolean isMask() {
		return mask;
	}
	
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	
	public Color getMaskColor() {
		return maskColor;
	}
	
	public void setMaskColor(Color maskColor) {
		this.maskColor = maskColor;
	}
}

