import java.awt.*;
import javax.swing.*;

class MyGradientPanel extends JPanel {

    public void paintComponent (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70,70,Color.blue, 150,150, Color.orange);

        g2d.setPaint(gradient);

        g2d.fillOval(70,70,100,100);

    }

}
