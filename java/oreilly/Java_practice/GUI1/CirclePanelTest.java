import javax.swing.*;
import java.awt.*;

public class CirclePanelTest {

    public static void main (String[] args) {

        JFrame frame = new JFrame();

        MyCirclePanel circle = new MyCirclePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(circle);

        frame.setSize(300,300);

        frame.setVisible(true);

    }

}
