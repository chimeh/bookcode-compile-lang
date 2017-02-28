import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


public class JavaFlowControlExample extends JApplet {

  private JTextArea textArea2;
  private JLabel lblSimplifiedCodeListing;
  private JLabel lblExecute;
  private JButton btnMethodfour;
  private JButton btnMethodthree;
  private JButton btnMethodtwo;
  private JButton btnMethodone;
  private JScrollPane scrollPane;
  private JTextArea textArea;
  private JPanel panel_2;
  private JSplitPane splitPane;
  private JPanel panel;
  /**
   * Create the applet
   */
  public JavaFlowControlExample() {
    super();

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.NORTH);

    lblExecute = new JLabel();
    lblExecute.setText("Execute: ");
    panel.add(lblExecute);

    btnMethodone = new JButton();
    btnMethodone.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        clearTextArea();
        methodOne();
      }
    });
    btnMethodone.setText("methodOne()");
    panel.add(btnMethodone);

    btnMethodtwo = new JButton();
    btnMethodtwo.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        clearTextArea();
        methodTwo();
      }
    });
    btnMethodtwo.setText("methodTwo()");
    panel.add(btnMethodtwo);

    btnMethodthree = new JButton();
    btnMethodthree.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        clearTextArea();
        methodThree();
      }
    });
    btnMethodthree.setText("methodThree()");
    panel.add(btnMethodthree);

    btnMethodfour = new JButton();
    btnMethodfour.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        clearTextArea();
        methodFour();
      }
    });
    btnMethodfour.setText("methodFour()");
    panel.add(btnMethodfour);

    splitPane = new JSplitPane();
    splitPane.setDividerLocation(300);
    getContentPane().add(splitPane, BorderLayout.CENTER);

    panel_2 = new JPanel();
    panel_2.setLayout(new BorderLayout());
    splitPane.setRightComponent(panel_2);

    lblSimplifiedCodeListing = new JLabel();
    lblSimplifiedCodeListing.setText("Simplified Code Listing");
    panel_2.add(lblSimplifiedCodeListing, BorderLayout.NORTH);

    textArea2 = new JTextArea();
    panel_2.add(textArea2, BorderLayout.CENTER);

    scrollPane = new JScrollPane();
    splitPane.setLeftComponent(scrollPane);

    textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
    textArea.setText("Method Execution Display:");
    fillTextArea2();
    //
  }

  private void methodOne() {
    textArea.append("\nEnter: Method 1.");
    methodTwo();
    textArea.append("\nExit : Method 1.");
  }
  private void methodTwo() {
    textArea.append("\n  Enter: Method 2.");
    methodThree();
    textArea.append("\n  Exit : Method 2.");
  }
  private void methodThree() {
    textArea.append("\n    Enter: Method 3.");
    methodFour();
    textArea.append("\n    Exit : Method 3.");
  }
  private void methodFour() {
    textArea.append("\n      Enter: Method 4.");
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        textArea.append("\n        methodFour() loop: i = " + i + " j = " + j + " ");
      }
    }
    textArea.append("\n      Exit : Method 4.");
  }

  public void clearTextArea() {
    textArea.setText("Method Execution Display:");
  }
  
  public void fillTextArea2() {
    String method = "private void methodOne() {\n  methodTwo();\n}\n";
    textArea2.setText(method);
    method = "private void methodTwo() {\n  methodThree();\n}\n";
    textArea2.append(method);
    method = "private void methodThree() {\n  methodFour();\n}\n";
    textArea2.append(method);
    method = "private void methodFour() {\n  for(int i = 0; i < 3; i++) {\n    for(int j = 0; j < 3; j++) {}\n  }\n}";
    textArea2.append(method);
  }
  
}
