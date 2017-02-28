// calculate area of circle 
 import java.awt.*;
 import java.applet.Applet;
 import java.awt.event.*;
 import java.text.*;

 public class CircleCalculation extends Applet implements ActionListener {
     private double radius;
     private double area;
     private TextField tf1, tf2;
      
     public void init() {
         tf1 = new TextField("",15); 
         tf2 = new TextField("",15);  
         add(new Label("Radius"));
         add(tf1); 
         add(new Label("Area"));
         add(tf2); 

         tf1.addActionListener(this); 
         tf2.addActionListener(this); 
     }
     
     
     public double getRadius() {
      return radius;
    }


    public void setRadius(double radius) {
      this.radius = radius;
    }


    public double getArea() {
      return area;
    }


    public void setArea(double area) {
      this.area = area;
    }


    public TextField getTf1() {
      return tf1;
    }


    public void setTf1(TextField tf1) {
      this.tf1 = tf1;
    }


    public TextField getTf2() {
      return tf2;
    }


    public void setTf2(TextField tf2) {
      this.tf2 = tf2;
    }


    public void actionPerformed(ActionEvent e){  
         TextField temp = (TextField)e.getSource(); 
         if (temp == tf1) radius = Double.parseDouble(temp.getText()); 
         //if (temp == tf2) area = Double.parseDouble(temp.getText());
         area = 3.14*(radius*radius);
         tf2.setText(String.valueOf(area));
         repaint();
     }

     public void paint(Graphics g) {
    	 NumberFormat nf = NumberFormat.getInstance();
         nf.setMaximumFractionDigits(2);
         g.drawString("Radius is " + radius + " Area is " + nf.format(area), 10, 100);
            // hint: area = Math.PI*radius*radius)
     }
 }
