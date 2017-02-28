// calculate area of circle 
 import java.awt.*;
 import java.applet.Applet;
 import java.awt.event.*;
 import java.text.*;

 public class CircleCalculation extends Applet implements ActionListener {
	 private double radius = 4.0;
	 private double area = 50.27;
	 private TextField tf1, tf2;
      
     public void init() {
         tf1 = new TextField("4.0",15); 
         tf2 = new TextField("50.27",15);  
         add(new Label("Radius"));
         add(tf1); 
         add(new Label("Area"));
         add(tf2); 

         tf1.addActionListener(this); 
         tf2.addActionListener(this); 
     }
     public void actionPerformed(ActionEvent e){  
         TextField temp = (TextField)e.getSource(); 
         if (temp == tf1) { 
        	 radius = Double.parseDouble(temp.getText()); 
        	 area = Math.PI*radius*radius;
         }	 
         if (temp == tf2) {
        	 area = Double.parseDouble(temp.getText());
        	 radius = Math.sqrt(area/Math.PI);
         }	 
         repaint();
     }

     public void paint(Graphics g) {
    	 NumberFormat nf = NumberFormat.getInstance();
         nf.setMaximumFractionDigits(2);
         tf1.setText(nf.format(radius));
         tf2.setText(nf.format(area));
         g.drawString("Radius is " + nf.format(radius) + " Area is " + nf.format(area), 10, 100);
            // hint: area = Math.PI*radius*radius)
     }
 }
