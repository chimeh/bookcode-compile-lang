package greenDB;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ExitListener extends JDialog implements ActionListener{
  PhoneBookFrame pbf;

  public ExitListener(PhoneBookFrame pbFrame) {
    pbf = pbFrame;
    setSize(200,100);
    JPanel main = new JPanel();
    
    JButton exitSave = new JButton("Exit and Save Table");
    exitSave.setActionCommand("EXIT_SAVE");
    exitSave.addActionListener(this);
    
    JButton exitDelete = new JButton("Exit and Delete Table");
    exitDelete.setActionCommand("EXIT_DELETE");
    exitDelete.addActionListener(this);
    
    main.add(exitSave);
    main.add(exitDelete);
    main.setVisible(true);
    
    this.add(main);
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
    ExitListener exitL = new ExitListener(pbf);
    exitL.setVisible(true);
    
    String cmd = e.getActionCommand();
    if("EXIT_SAVE".equals(cmd)) {
      pbf.getDBManager().close(false);
      System.exit(0);
    }
    
    if("EXIT_DELETE".equals(cmd)) {
      pbf.getDBManager().close(true);
      System.exit(0);
    }
    
  }

}
