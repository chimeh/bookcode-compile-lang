package salesGUI;
//Need to add listeners for r,s,t
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SalesUserInterface extends JFrame {
  SalesApp app;
  JMenuBar mb ;
  JMenu m, m1, data;
  JMenuItem q, r, s, t;
  InputPanel currentInputPanel, savedInputPanel;
  JLabel peopleLabel;
  JTextField peopleField;
  JButton jbNumPeople, done;
  int numPeople;
  boolean processed;
  
  public SalesUserInterface(SalesApp myApp) {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app = myApp;
    app.setMyUserInterface(this);
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(600,600));
    mb = new JMenuBar();
    setJMenuBar(mb);
    m = new JMenu("File");
    data = new JMenu("Options");
    data.add(r = new JMenuItem("Reset"));
    data.add(s = new JMenuItem("Retrieve Previous"));
    data.add(t = new JMenuItem("Return"));
    mb.add(m);
    mb.add(data);
    
    m.add(q = new JMenuItem("Exit"));
    
    q.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    
    r.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentInputPanel.removeAll();
        SalesUserInterface.this.revalidate();
      }
    });
    
    s.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         System.out.println("Getting saved panel");
         currentInputPanel.setVisible(false);
         add(savedInputPanel);
         savedInputPanel.setVisible(true);
         SalesUserInterface.this.revalidate();
      }
    });
    
    t.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Returning to current panel");
        savedInputPanel.setVisible(false);
        currentInputPanel.setVisible(true);
        SalesUserInterface.this.revalidate();
      }
    });
    InitPanel specifyNumber = new InitPanel();
    add("North", specifyNumber);
    
    pack();
    setVisible(true);
  }
  
  

  private class InitPanel extends JPanel{
    public InitPanel() {
      peopleLabel = new JLabel("Enter the number of sales people");
      add(peopleLabel);
      peopleField = new JTextField(5);
      add(peopleField);
      jbNumPeople = new JButton("Submit");
      add(jbNumPeople);
      jbNumPeople.addActionListener(new NumSalesPeopleListener());

    }
    
    private class NumSalesPeopleListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
        if (currentInputPanel != null) {
          savedInputPanel = currentInputPanel;
          remove(currentInputPanel);
          app = new SalesApp();
        }
        numPeople = Integer.parseInt(peopleField.getText());
        currentInputPanel = new InputPanel(app, numPeople, 2);
        add("Center", currentInputPanel);
        SalesUserInterface.this.validate();
        
      }
    }
  }
}
