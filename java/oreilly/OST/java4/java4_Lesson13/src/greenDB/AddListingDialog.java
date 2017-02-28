package greenDB;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class AddListingDialog extends JDialog {
    /** A text field for entering the new phone listing's last name */
    private JTextField lNameField    = new JTextField(16);
    /** A text field for entering the new phone listing's first name */
    private JTextField fNameField    = new JTextField(16);
    /** A text field for entering the new phone listing's area code */
    private JTextField areaCodeField = new JTextField(2);
    /** A text field for entering the new phone listing's prefix */
    private JTextField prefixField   = new JTextField(2);
    /** A text field for entering the new phone listing's extension */
    private JTextField suffixField   = new JTextField(3);
    /** A button which, when clicked, will add the new listing to the Listings table */
    private JButton addButton;
    
    public AddListingDialog(final JFrame owner) {
        // set the dialog title and size
        super(owner, "Add Listing", true);
        setSize(280, 150);
        
        // Create the center panel which contains the fields for entering the new listing
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 2));
        center.add(new JLabel(" Last Name:"));
        center.add(lNameField);
        center.add(new JLabel(" First Name:"));
        center.add(fNameField);
        
        // Here we create a panel for the phone number fields and add it to the center panel.
        JPanel pnPanel = new JPanel();
        pnPanel.add(new JLabel("("));
        pnPanel.add(areaCodeField);
        pnPanel.add(new JLabel(") "));
        pnPanel.add(prefixField);
        pnPanel.add(new JLabel("-"));
        pnPanel.add(suffixField);
        center.add(new JLabel(" Phone Number:"));
        center.add(pnPanel);
        
        // Create the south panel, which contains the buttons
        JPanel south = new JPanel();
        addButton    = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
        addButton.setEnabled(false);
        south.add(addButton);
        south.add(cancelButton);
        
        // Add listeners to the fields and buttons
        lNameField.getDocument().addDocumentListener(new InputListener());
        fNameField.getDocument().addDocumentListener(new InputListener());
        areaCodeField.getDocument().addDocumentListener(new InputListener());
        prefixField.getDocument().addDocumentListener(new InputListener());
        suffixField.getDocument().addDocumentListener(new InputListener());
        
        areaCodeField.getDocument().addDocumentListener(new PhoneDocumentListener(areaCodeField, 3));
        prefixField.getDocument().addDocumentListener(new PhoneDocumentListener(prefixField, 3));
        suffixField.getDocument().addDocumentListener(new PhoneDocumentListener(suffixField, 4));
        
        areaCodeField.addFocusListener(new PhoneFocusListener());
        prefixField.addFocusListener(new PhoneFocusListener());
        suffixField.addFocusListener(new PhoneFocusListener());
        
        // listeners to close the window
        addButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent aEvent) {
                    // ((PhoneBookFrame)owner).doInsertQuery(buildQuery());
                    DatabaseManager ownersDB = ((PhoneBookFrame)owner).getDBManager();
                    ownersDB.doInsertQuery(buildQuery());
                    dispose();
                }
        });
        
        cancelButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent aEvent) {
                    dispose();
                }
        });
        
        // Add the panels to the dialog window
        Container contentPane = getContentPane();
        contentPane.add(center, BorderLayout.CENTER);
        contentPane.add(south,  BorderLayout.SOUTH);
    }
    
    public String buildQuery() {
        // Get the data entered by the user, trim the white space and change to upper case
        String query = "";
        String last  = lNameField.getText().trim().toUpperCase();
        String first = fNameField.getText().trim().toUpperCase();
        String ac    = areaCodeField.getText().trim().toUpperCase();
        String pre   = prefixField.getText().trim().toUpperCase();
        String sfx   = suffixField.getText().trim().toUpperCase();
        
        // Replace any single quote chars with a space char so the string will not get truncated by SQL
        last  = last.replace('\'', ' ');
        first = first.replace('\'', ' ');
        ac    = ac.replace('\'', ' ');
        pre   = pre.replace('\'', ' ');
        sfx   = sfx.replace('\'', ' ');
        
        // build  and return the insert statement
        return new String("insert into Listings values ('" + last + "', '" +
         first + "', '" +
         ac + "', '" +
         pre + "', '" +
         sfx + "')");
    }
    
    /* inner class InputListener */
    class InputListener implements DocumentListener {
        public void insertUpdate(DocumentEvent dEvent) {
            // If first name and last name have data and phone number is complete
            // enable the add button, give it focus and make it clickable if
            // user presses Enter.
            if(lNameField.getDocument().getLength()     > 0 &&
             fNameField.getDocument().getLength()     > 0 &&
             areaCodeField.getDocument().getLength() == 3 &&
             prefixField.getDocument().getLength()   == 3 &&
             suffixField.getDocument().getLength()   == 4) {
             
                addButton.setEnabled(true);
                if(dEvent.getDocument() == suffixField.getDocument()) {
                    addButton.requestFocus();
                    getRootPane().setDefaultButton(addButton);
                }
            }
        }

        public void removeUpdate(DocumentEvent dEvent) {
            // If last name or first name don't have data or phone number
            // is  not complete, disable the Add button.
            if(lNameField.getDocument().getLength()   == 0 ||
             fNameField.getDocument().getLength()   == 0 ||
             areaCodeField.getDocument().getLength() < 3 ||
             prefixField.getDocument().getLength()   < 3 ||
             suffixField.getDocument().getLength()   < 4 )

                addButton.setEnabled(false);
        }
        
        /** Empty implementation. Method necessary for implementation of DocumentListener */
        public void changedUpdate(DocumentEvent dEvent) {}
        
    } // End InputListener inner class
  
} // End AddListingDialog class  

