import javax.swing.*;
import java.awt.*;

public class TestFrame {

    JFrame frame;

    public void makeFrame() {

        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300,300);

        frame.setVisible(true);

    }

}
