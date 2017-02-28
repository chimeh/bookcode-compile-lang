import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyDrawPanel extends JPanel {
    private static int cnt = 0;
    public void paintComponent(Graphics g){
        cnt++;
        System.out.println(cnt);
        g.setColor(Color.blue);
        g.fillOval(70,70,this.getWidth()-70, this.getHeight()-70);
    }// close method paintComponent
}// close subClass