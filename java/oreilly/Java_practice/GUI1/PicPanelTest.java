import javax.swing.*;
import java.awt.*;

public class PicPanelTest {

    public static void main (String[] args) {

        JFrame frame = new JFrame();

        MyPicPanel pic = new MyPicPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(pic);

        frame.setSize(300,300);

        frame.setVisible(true);

    }

}
