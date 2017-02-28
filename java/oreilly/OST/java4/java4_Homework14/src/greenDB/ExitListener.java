package greenDB;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/* class ExitListener */
/**
 * A listener that will prompt to exit the application and give the option to either save
 * the data and exit or delete the data and exit.
 *
 * @author Ben Orban
 * @version 1.0
 */
public class ExitListener extends JDialog implements ActionListener{
  PhoneBookFrame pbf;

  /*ExitListener*/
  /**
   * The ExitListener constructor
   * 
   * @param pbFrame The PhoneBookFrame passed to which this listener applies.
   */
  public ExitListener(PhoneBookFrame pbFrame) {
    pbf = pbFrame;
    setSize(200,100);
    /** The main panel for displaying the exit options. */
    JPanel main = new JPanel();
    /** A button to save the database table and exit the application.*/
    JButton exitSave = new JButton("Exit and Save Table");
    exitSave.setActionCommand("EXIT_SAVE");
    exitSave.addActionListener(this);
    /**A button to delete the database table and exit the application.*/
    JButton exitDelete = new JButton("Exit and Delete Table");
    exitDelete.setActionCommand("EXIT_DELETE");
    exitDelete.addActionListener(this);
    
    main.add(exitSave);
    main.add(exitDelete);
    main.setVisible(true);
    
    this.add(main);
  }
  /*actionPerfomed*/
  /**
   * Instantiating the ExitListener dialog box. This method is called
   * when the 'Exit' button is pressed.
   * <pre>
   * PRE:
   * POST: The exit dialog box is displayed on screen
   * </pre>
   * @param e An event generated as a result of the 'Exit' button being pressed. 
   */
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
