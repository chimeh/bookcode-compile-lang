package salesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPanel extends JPanel implements ActionListener {
  JPanel topPanel, middlePanel, bottomPanel, leftPanel, rightPanel;
  JLabel[] jlSales;
  JLabel prompt, doneLabel, jlSalesBar;
  JTextField[] jtfSales;
  JTextField jtfSalesBar;
  JButton done;
  SalesApp app;
  int numPeople;
  int[] sales;
  int goal;
  
  public InputPanel(SalesApp container, int numPeople, int gridX) {
    this.app=container;
    this.numPeople = numPeople;
    sales = new int[numPeople];
    this.setLayout(new BorderLayout());
    topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout());
    middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(numPeople, gridX));
    bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout());
    bottomPanel.setPreferredSize(new Dimension(600,100));
    leftPanel = new JPanel();
    rightPanel = new JPanel();
    add("North", topPanel);
    add("Center", middlePanel);
    add("South", bottomPanel);
    add("East", rightPanel);
    add("West", leftPanel);
    
    jlSales = new JLabel[numPeople];
    jtfSales = new JTextField[numPeople];
    prompt = new JLabel("Give values for each salesperson:");
    topPanel.add(prompt);
    for (int x=0; x <numPeople; x++) {
      jlSales[x] = new JLabel("Sales Person " + (x+1));
      jtfSales[x] = new JTextField("0",8);
      middlePanel.add(jlSales[x]);
      middlePanel.add(jtfSales[x]);
    }
    // Does not play nice if more than one element is placed in the bottom panel
    
    jlSalesBar = new JLabel("Enter a value for the sales goal:");
    bottomPanel.add(jlSalesBar);
    jtfSalesBar = new JTextField("0",8);
    bottomPanel.add(jtfSalesBar);
    doneLabel = new JLabel("Click when all are entered: ");
    bottomPanel.add(doneLabel);
    done = new JButton("All Set");
    bottomPanel.add(done);
    done.addActionListener(this);
    
  }
  
  public void actionPerformed(ActionEvent event){
    if(event.getSource() instanceof JButton) {
      if((JButton)event.getSource() == done) {
        setAllInputs();
      }
    }
  }
  
  public void setAllInputs() {
    for(int x =0; x < numPeople; x++) {
      try {
        sales[x] = Integer.parseInt(jtfSales[x].getText());
      }
      catch(NumberFormatException e) {
        String messageLine1 = "Input must be whole numbers.\n";
        String messageLine2 = "Your decimal value " + jtfSales[x].getText() + " for Sales Person " + (x+1) + " will be truncated\n";
        String messageLine3 = "You may enter a different integer and click AllSet if truncation is unacceptable.";

        JOptionPane.showMessageDialog(this, messageLine1+messageLine2+messageLine3,"Input Error", JOptionPane.ERROR_MESSAGE);
        sales[x] = (int)Double.parseDouble(jtfSales[x].getText());
        jtfSales[x].setText(Integer.toString(sales[x]));
      }
      
    }
    app.setSales(sales);
    goal = Integer.parseInt(jtfSalesBar.getText());
    app.setSalesBar(goal);
  }
}
