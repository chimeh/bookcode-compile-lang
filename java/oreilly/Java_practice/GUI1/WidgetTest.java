import javax.swing.*;
import java.awt.*;

public class WidgetTest {

    public static void main (String[] args) {

        WidgetTest tw = new WidgetTest();

        if (args.length != 1) {

            System.out.println("Don't forget your class to test!");

        } else {

            String cw = args[0];

            tw.testWidget(cw);

        }

    }

    public void testWidget(String cw) {

        TestFrame ft = new TestFrame();

        String wg = new cw();
	
        ft.getContentPane().add(wg);

    }

}
