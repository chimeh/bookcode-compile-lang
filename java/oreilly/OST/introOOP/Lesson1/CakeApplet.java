// These are Java comments. This syntax works for single lines.

/* These are also Java comments. Notice the syntax used to implement them.
   They work over multible lines. */
   
   import java.applet.*;
   import java.awt.*;
   
   public class CakeApplet extends Applet {
   
   	public void paint(Graphics g) {
   		frostCake(Color.blue,g);
   		g.setColor(Color.black);
   		g.drawString("I am a BLUE Cake.",25,25);
   	}
   	
   	public void frostCake(Color myColor, Graphics myGraphics) {
   		myGraphics.setColor(myColor);
   		myGraphics.fillRect(0,0,50,50);
  
   	}
   	
   	
   }
   