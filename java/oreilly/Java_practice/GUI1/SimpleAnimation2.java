import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleAnimation2 implements ActionListener {

    int x = 70;

    int y = 70;

    Animator a = new Animator();

    MyDrawPanel3 drawPanel = new MyDrawPanel3();

    public static void main (String[] args) {

        SimpleAnimation2 gui = new SimpleAnimation2();

        gui.go();

    }

    public void go() {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Animate");

        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(300,300);

        frame.setVisible(true);

        a.animate(drawPanel);

    }

    class Animator {

        public void animate(MyDrawPanel3 drawPanel) {

            for (int i = 0; i < 130; i++) {

                x++;

                y++;

                drawPanel.repaint();

                try {

                    Thread.sleep(50);

                } catch(Exception ex) { }

            }

        }

    }

    class MyDrawPanel3 extends JPanel {

        public void paintComponent(Graphics g) {

            g.setColor(Color.white);

            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(Color.green);

            g.fillOval(x,y,40,40);

        }

    }

    public void actionPerformed(ActionEvent event) {

            x = 70;

            y = 70;

            a.animate(drawPanel);

    }

}
