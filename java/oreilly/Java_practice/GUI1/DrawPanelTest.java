import javax.swing.*;
import java.awt.*;

public class DrawPanelTest {

    public static void main (String[] args) {

        JFrame frame = new JFrame();

        MyDrawPanel draw = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(draw);

        frame.setSize(300,300);

        frame.setVisible(true);

    }

}
