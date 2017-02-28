import javax.swing.*;


public class TableProject {
              
  private static void createAndShowTable() {
    
    String [] columnNames = {"First Name",
        "Last Name",
        "Birthday",
        "Phone",
        "Address",
        "City",
        "Zip"};

    Object [][] data = {
                       {"Ben", "Orban", "10-18-87", "618-555-5555", "1723 Clawson St.", "Alton", "62002"},
                       {"Debra","Orban", "12-15-57", "618-555-5678", "3810 Western Ave", "Alton", "62002"},
                       {"Amy", "Orban", "01-22-90", "618-555-5556", "3810 Western Ave", "Alton", "62002"},
                       {"Josh", "Fank", "09-07-80", "618-555-5557", "123 Clydesdale Ln", "Stephens City", "32105"},
                       {"Anna", "Fank", "05-15-85", "310-555-5555", "123 Clydesdale Ln", "Stephens City", "32105"}
                        };
    JTable table = new JTable(data, columnNames);
    
    JFrame.setDefaultLookAndFeelDecorated(false);
    JFrame frame = new JFrame("TableProject");
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(table);
    frame.pack();
    frame.setVisible(true);
    }
  
    public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
         createAndShowTable(); 
        }
      });
    }
}
