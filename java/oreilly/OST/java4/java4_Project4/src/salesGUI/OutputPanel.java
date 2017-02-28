package salesGUI;

import javax.swing.*;
import java.text.DecimalFormat;

public class OutputPanel extends JPanel {
  
  JLabel jlSalesOutput;
  JPanel leftPanel, rightPanel;
  JLabel jlSalesBar;
  JTextField jtfSalesBar;
  JButton done;
  SalesApp app;
  int salesBar;
  int[] sales;
  
  public OutputPanel(SalesApp container) {
    app = container;
    sales = app.getSales();
    leftPanel = new JPanel();
    rightPanel = new JPanel();
    add("East", rightPanel);
    add("West", leftPanel);
    jlSalesOutput = new JLabel();
    rightPanel.add(jlSalesOutput);
    jlSalesOutput.setText("");
  }
  
  public void refreshOutput() {
    jlSalesOutput.setText("");
  }
  
  protected void writeOutput() {
    app.calculateMinMax();
    DecimalFormat df1 = new DecimalFormat("####.00");
    String txtOutput = 
        "<html>Sales Figures<br>_______________________________<br>";
    for (int x = 0; x < sales.length; x++) {
      txtOutput += "Sales Person " + (x + 1) + ": $" + df1.format(sales[x]) + "<br>";
    }
    
    txtOutput += "<br>The lowest sales belongs to sales person " + 
        (app.getMin() + 1) + " with $" + df1.format(sales[app.getMin()]) + "<br>";
    txtOutput += "<br>The highest sales belongs to sales person " + 
        (app.getMax() + 1) + " with $" + df1.format(sales[app.getMax()]) + "<br>";
    txtOutput += "<br>The total sales were: $ " + 
        df1.format(app.getTotalSales()) + "<br>";
    txtOutput += "<br>The average sales was: $ " + df1.format(app.getAverage()) +
        "<br><br>";
    txtOutput += createSalesBarInfo();
    txtOutput += "</html>";
    
    jlSalesOutput.setText(txtOutput);
    validate();
    repaint();
  }
  
  protected String createSalesBarInfo() {
    DecimalFormat df1 = new DecimalFormat("####.00");
    String salesBarOutput = "";
    int overSalesBar = 0;
    int[] performance = app.determineTopSalesPeople();
    int[] sales = app.getSales();
    
    for(int x = 0; x < sales.length; x++) {
      if (performance[x] == 1) {
        overSalesBar++;
        salesBarOutput += "Sales person " + (x + 1) + 
            " sold more than the sales goal with sales of $" + df1.format(sales[x]) + "<br>";
      }
      else if (performance[x] == 0) {
        salesBarOutput += "Sales person " + (x + 1) +
            " exactly reached the sales goal with sales of $" + df1.format(sales[x]) + "<br>";
      }
    }
    if (overSalesBar ==1) {
      salesBarOutput += "Only " + overSalesBar +
          " sales person sold more than the sales goal of $" + df1.format(app.getBar()) + "<br><br>";
    }
    else {
        salesBarOutput += overSalesBar +
            " sales people sold more than the sales goal of $" + df1.format(app.getBar()) + "<br><br>";
    }
    return salesBarOutput;
  }

  protected void writeMinMax() {
    app.calculateMinMax();
    
    DecimalFormat df1 = new DecimalFormat("####.00");
    String txtOutput = 
        "<html>Sales Figures<br>_______________________________<br>";
    txtOutput += "<br>The lowest sales belongs to sales person " + 
        (app.getMin() + 1) + " with $" + df1.format(sales[app.getMin()]) + "<br>";
    txtOutput += "<br>The highest sales belongs to sales person " + 
        (app.getMax() + 1) + " with $" + df1.format(sales[app.getMax()]) + "<br>";
    txtOutput += "</html>";
    
    jlSalesOutput.setText(txtOutput);
    validate();
    repaint();
  }
}
