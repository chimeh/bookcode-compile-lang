import java.awt.*;
import javax.swing.*;

class MyPicPanel extends JPanel {

    public void paintComponent(Graphics g) {

        Image image = new ImageIcon("Test_Image/Dia_De_Los_Muertos.jpg").getImage();

        g.drawImage(image,3,4,this);

    }

}
