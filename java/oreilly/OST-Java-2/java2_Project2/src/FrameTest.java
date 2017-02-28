import java.awt.event.*;
import java.awt.*;

public class FrameTest extends Frame {
	private static int varOne = 1;
	private static int varTwo = 2;
	private static int varThree = 3;
	private static int varFour = 4;
	private static int varFive = 5;
	private static int varSix = 6; 
	private int varSeven = 7;
	private int varEight = 8;
	private int varNine = 9;
	private int varTen = 10;
	private int varEleven = 11;
	private int varTwelve = 12;
		
	public FrameTest() {
		super ("This is a FrameTest Title");
	}
	
	public void paint(Graphics g) {
		g.drawString("The value of varSeven is " + varSeven, 50, 50);
		g.drawString("The value of varEight is " + varEight, 50, 65);
		g.drawString("The value of varNine is " + varNine, 50, 80);
		g.drawString("The value of varTen is " + varTen, 50, 95);
		g.drawString("The value of varEleven is " + varEleven, 50, 110);
		g.drawString("The value of varTwelve is " + varTwelve, 50, 125);
	}
	
	public void start() {
		setSize(300,300);
		setVisible(true);
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				dispose(); //free up system resources
				System.exit(0);
			}
		}); //Quit the app.
	}
	
	public static void main(String[] args) {
		System.out.println("The value of varOne is " + varOne);
		System.out.println("The value of varTwo is " + varTwo);
		System.out.println("The value of varThree is " + varThree);
		System.out.println("The value of varFour is " + varFour);
		System.out.println("The value of varFive is " + varFive);
		System.out.println("The value of varSix is " + varSix);
		
		FrameTest frameT = new FrameTest();
		frameT.start();	
	}
}
