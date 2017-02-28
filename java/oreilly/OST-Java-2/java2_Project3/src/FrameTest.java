import java.awt.event.*;
import java.awt.*;

public class FrameTest extends Frame {
	//byte
	private static byte byteC = -128;
	private static byte byteF = 127;
	//short
	private static short shortC = -32768;
	private static short shortF = 32767;
	//int
	private static int intC = -2147483648;
	private static int intF = 2147483647; 
	//long
	private static long longC = -9223372036854775808L;
	private long longF = 9223372036854775807L;
	//float 
	private static float floatC = -9223372036854775809.9F;
	private float floatF = 9223372036854775808.9F;
	//double
	private static double doubleC = -9223372036854775809.99;
	private double doubleF = 9223372036854775808.99;
	//boolean
	private static boolean booleanC = true;
	private boolean booleanF = false;
	//char
	private static char charC = 'a';
	private char charF = 'b';
		
	public FrameTest() {
		super ("This is a FrameTest Title");
	}
	
	public void paint(Graphics g) {
		g.drawString("byte byteF = " + byteF, 30, 50);
		g.drawString("short shortF = " + shortF, 30, 65);
		g.drawString("int intF = " + intF, 30, 80);
		g.drawString("long longF = " + longF, 30, 95);
		g.drawString("float floatF = " + floatF, 30, 110);
		g.drawString("double doubleF = " + doubleF, 30, 125);
		g.drawString("boolean booleanF = " + booleanF, 30, 140);
		g.drawString("char charF = " + charF, 30, 155);
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
		System.out.println("byte byteC = " + byteC);
		System.out.println("short shortC = " + shortC);
		System.out.println("int intC = " + intC);
		System.out.println("long longC = " + longC);
		System.out.println("float floatC = " + floatC);
		System.out.println("double doubleC = " + doubleC);
		System.out.println("boolean booleanC = " + booleanC);
		System.out.println("char charC = " + charC);
		
		FrameTest frameT = new FrameTest();
		frameT.start();	
	}
}
