import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1b implements ActionListener {
    JButton button;
    Jbutton button2;
    
    public static void main (String[] args){
        SimpleGui1b gui = new SimpleGui1b();
        gui.go();
    }//close main
    
    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click me");
        button2 = new JButton("Click me");
        
        button2.addActionListener();
        button.addActionListener(this);
        
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }// close method go
    
    public void actionPerformed(ActionEvent event){
        button.setText("I've been clicked!");
    }//close method actionPerformed
}//close class