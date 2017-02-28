// These are Java comments. This syntax works for single lines.

/* These are also Java comments. Notice the syntax used to implement them.
   They work over multible lines. */
   
   import java.applet.*;
   import java.awt.*;
   
   public class CakeApplet2 extends Applet {
   
   	public void paint(Graphics g) {
   		frostCake(Color.red,g);
   		g.setColor(Color.black);
   		g.drawString("I am a red Cake.",50,100);
   	}
   	
   	public void frostCake(Color myColor, Graphics myGraphics) {
   		myGraphics.setColor(myColor);
   		myGraphics.fill3DRect(15,5,200,200,true);
   		myGraphics.draw3DRect(15,5,200,190,true);
  
   	}
   	
   	
   }
   