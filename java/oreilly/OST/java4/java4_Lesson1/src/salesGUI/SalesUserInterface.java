package salesGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SalesUserInterface extends JFrame {
  SalesApp app;
  JMenuBar mb;
  JMenu m, m1;
  JMenuItem q, r, s, t;
  InputPanel inputPanel;
  JLabel peopleLabel;
  JTextField peopleField;
  JButton jbNumPeople, done;
  int numPeople;
  OutputPanel results;
  boolean processed = false;
  
  public SalesUserInterface(SalesApp myApp) {
    System.out.println("Did I get made?");
    app = new SalesApp();
    //app = myApp;
    app.setMyUserInterface(this);
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(600,600));
    mb = new JMenuBar();
    setJMenuBar(mb);
    m = new JMenu("File");
    m1 = new JMenu("Options");
    mb.add(m);
    mb.add(m1);
    m.add(q = new JMenuItem("Exit"));
    q.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    m1.add(t= new JMenuItem("Results"));
    t.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputPanel.setAllInputs();
        if (processed) {
          remove(results);
        }
        results = new OutputPanel(app);
        add("South", results);
        processed = true;
        results.writeOutput();}
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
        if (inputPanel != null) {
          remove(inputPanel);
          app = new SalesApp();
        }
        numPeople = Integer.parseInt(peopleField.getText());
        inputPanel = new InputPanel(app, numPeople, 2);
        add("Center", inputPanel);
        SalesUserInterface.this.validate();
      }
    }
  }
}
