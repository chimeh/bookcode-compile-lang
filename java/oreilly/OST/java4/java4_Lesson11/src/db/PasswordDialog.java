package db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordDialog extends JDialog implements ActionListener {
  private JTextField user;
  private JPasswordField password;
  private String username, passwd;
  private static String[] info;
  private static boolean set = false;
  
  public PasswordDialog(final JFrame owner) {
    super(owner, "Login", true);
    setSize(280, 150);
    user = new JTextField(10);
    user.addActionListener(this);
    password = new JPasswordField(10);
    password.addActionListener(this);
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(3, 2));
    center.add(new JLabel("Enter UserName:"));
    center.add(user);
    center.add(new JLabel("Enter Password: "));
    center.add(password);
    JPanel south = new JPanel();
    JButton submitButton = new JButton("Submit");
    submitButton.setActionCommand("SUBMIT");
    submitButton.addActionListener(this);
    
    JButton helpButton = new JButton("Help");
    south.add(submitButton);
    south.add(helpButton);
    helpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent aEvent) {
        JOptionPane.showMessageDialog(owner, 
            "Your username and password are the same as those\n"+
            "you use to access your O'Reilly School of Technology courses. \n");
      }
    });
    Container contentPane = getContentPane();
    contentPane.add(center, BorderLayout.CENTER);
    contentPane.add(south, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if("SUBMIT".equals(cmd)) {
      username = user.getText();
      char[] input = password.getPassword();
      passwd = new String(input);
      
      System.out.println("User is " + username + ", password is " + passwd  );
      info = new String[2];
      info[0] = username;
      info[1] = passwd;
      set = true;
      dispose();
    }
  }
  
  public static void main(String [] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final PasswordDialog addPassword = new PasswordDialog(frame);
    addPassword.setVisible(true);
    System.exit(0);
  }
  
  public static String[] login(Object sender) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final PasswordDialog addPassword = new PasswordDialog(frame);
    addPassword.setVisible(true);
    while(!set)
      try {
        Thread.sleep(5000);
      }
    catch (InterruptedException e) {};
    return info;
  }
}
