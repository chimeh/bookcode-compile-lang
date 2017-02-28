import javax.swing.*;
import java.awt.*;

public class RandomGradientPanelTest {

    public static void main (String[] args) {

        JFrame frame = new JFrame();

        MyRandomGradientPanel rgrad = new MyRandomGradientPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(rgrad);

        frame.setSize(300,300);

        frame.setVisible(true);

    }

}
