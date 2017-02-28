import javax.swing.*;
import java.awt.*;

public class GradientPanelTest {

    public static void main (String[] args) {

        JFrame frame = new JFrame();

        MyGradientPanel grad = new MyGradientPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(grad);

        frame.setSize(300,300);

        frame.setVisible(true);

    }

}
