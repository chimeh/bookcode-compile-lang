package salesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPanel extends JPanel implements ActionListener {
    Panel topPanel, middlePanel, bottomPanel, leftPanel, rightPanel;
    InputPanel currentPanel, savedPanel;
    JLabel[] jlSales;                       
    JLabel  prompt, doneLabel, jlSalesBar;
    JTextField[] jtfSales;                  
    JTextField jtfSalesBar;                 
    JButton done;
    SalesApp app;      
    int numPeople;
    int [] sales;
    int goal;

    public InputPanel(SalesApp container, int numPeople, int gridX){
        this.app = container;
        this.numPeople = numPeople;
        sales = new int[numPeople];
        this.setLayout(new BorderLayout());  
        topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());
        middlePanel = new Panel();
        middlePanel.setLayout(new GridLayout(numPeople, gridX));
        bottomPanel = new Panel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setPreferredSize(new Dimension(600,100));
        leftPanel = new Panel();
        rightPanel = new Panel();
        add("North", topPanel);
        add("Center", middlePanel);
        add("South", bottomPanel);
        add("East", rightPanel);
        add("West", leftPanel);
        
        jlSales = new JLabel[numPeople];
        jtfSales = new JTextField[numPeople];
        prompt = new JLabel("Give values for each salesperson:");
        topPanel.add(prompt);
        for (int x = 0; x < numPeople; x++)
        {
            jlSales[x] = new JLabel("Sales Person " + (x+1));
            jtfSales[x] = new JTextField("0",8);
            middlePanel.add(jlSales[x]);
            middlePanel.add(jtfSales[x]);
        }                                      
        
        jlSalesBar = new JLabel("Enter a value for the sales goal: ");
        bottomPanel.add(jlSalesBar);
        jtfSalesBar = new JTextField("0",8);
        bottomPanel.add(jtfSalesBar);
        doneLabel = new JLabel("Click when all are entered:");
        bottomPanel.add(doneLabel);
        done = new JButton("All Set");
        bottomPanel.add(done);
        done.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() instanceof JButton)
        {
            if ((JButton)event.getSource() == done) {
                for (int x = 0; x < numPeople; x++){
                    sales[x] = Integer.parseInt(jtfSales[x].getText());
                }
                app.setCurrentSales(sales);
                goal = Integer.parseInt(jtfSalesBar.getText());
                app.setSalesBar(goal);     
                currentPanel = this;
              }
                
      }
    }

    public InputPanel getCurrentPanel() {
      return currentPanel;
    }

    public void setCurrentPanel(InputPanel currentPanel) {
      this.currentPanel = currentPanel;
    }

    public InputPanel getSavedPanel() {
      return savedPanel;
    }

    public void setSavedPanel(InputPanel savedPanel) {
      this.savedPanel = savedPanel;
    }
    
    

}
