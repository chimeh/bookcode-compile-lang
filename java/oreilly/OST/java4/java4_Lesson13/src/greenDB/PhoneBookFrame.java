package greenDB;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class PhoneBookFrame extends JFrame {
    /** The initial user interface width, in pixels */
    private static final int WIDTH  = 577;
    /** The initial user interface height, in pixels */
    private static final int HEIGHT = 466;
    /** Provides methods for displaying a SQL result set in a JTable */
    // Commented out for now so the program can run without it.
    private ListingsTableModel tblModel;
    /** Used to display the SQL result set in a cell format */
    private JTable table;
    /** A scrollable view for the SQL result set */
    private JScrollPane scrollPane;
    /** A text field for entering the phone listing's last name */
    private JTextField lNameField    = new JTextField(10);
    /** A text field for entering the phone listing's first name */
    private JTextField fNameField    = new JTextField(10);
    /** A text field for entering the phone listing's area code. The value in parentheses  
    is the number of columns (NOT necessarily characters) to allow for the field. */
    private JTextField areaCodeField = new JTextField(2);
    /** A text field for entering the phone listing's prefix */
    private JTextField prefixField   = new JTextField(2);
    /** A text field for entering the phone listing's extension */
    private JTextField suffixField   = new JTextField(3);
    /** Database Operations */
    private DatabaseManager myDB;
    
    public PhoneBookFrame() {
        String [] info = PasswordDialog.login(this);  // static login so can call from class
        // create and initialize the listings table
        myDB = new DatabaseManager(info[0], info[1]);
        // should have access so make GUI   
        JButton getButton = new JButton("Get");  // get the listing
        JButton add       = new JButton("+");    // add a listing
        JButton rem       = new JButton("-");    // remove a listing
        JLabel  space     = new JLabel(" ");
        // set the window size and title
        setTitle("Simple Phone Book");
        setSize(WIDTH, HEIGHT);
        // if user presses Enter, get button pressed
        getRootPane().setDefaultButton(getButton);
        // create the panel for looking up listing
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        south.add(new JLabel("Last:"));
        south.add(lNameField);
        south.add(new JLabel(" First:"));
        south.add(fNameField);
        south.add(new JLabel("  Phone:  ("));
        south.add(areaCodeField);
        south.add(new JLabel(") "));
        south.add(prefixField);
        south.add(new JLabel("-"));
        south.add(suffixField);
        south.add(new JLabel("   "));
        south.add(getButton);
        // create the panel for adding and deleting listings
        JPanel  east           = new JPanel();
        GridBagLayout gb       = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        east.setLayout(gb);
        add.setFont(new Font("SansSerif", Font.BOLD, 12));
        rem.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(add, gbc);
        gb.setConstraints(space, gbc);
        gb.setConstraints(rem, gbc);
        east.setLayout(gb);
        east.add(add);
        east.add(space);
        east.add(rem);

        // add the panels
        Container contentPane = getContentPane();
        contentPane.add(south, BorderLayout.SOUTH);
        contentPane.add(east, BorderLayout.EAST);
        // Add listeners
        // When the application closes, drop the Listings table and close the connection to MySQL
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent wEvent) {      
              myDB.close(false);  // We will want to save our additions to the PhoneBook, so don't drop table
            }
        });
        
        areaCodeField.addFocusListener(new PhoneFocusListener());
        areaCodeField.getDocument().addDocumentListener(new PhoneDocumentListener(areaCodeField, 3));
        
        prefixField.addFocusListener(new PhoneFocusListener());
        prefixField.getDocument().addDocumentListener(new PhoneDocumentListener(prefixField, 3));
        
        suffixField.addFocusListener(new PhoneFocusListener());
        suffixField.getDocument().addDocumentListener(new PhoneDocumentListener(suffixField, 4));
        
        add.addActionListener(new AddListingListener(this));  // add (+) listener--define in own class
        
        // remove (-) listener--delete the highlighted listing from the result set and database
        rem.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent aEvent) {
                    try {
                        int selected = table.getSelectedRow();
                        ResultSet rset  = myDB.getResultSet();
                        if(selected != -1 && selected < tblModel.getRowCount()) {
                            rset.absolute(table.getSelectedRow() + 1);
                            rset.deleteRow();
                            table.repaint();
                            table.clearSelection();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        });


        getButton.addActionListener(new GetListener());
        // when the UI first displays, do an empty lookup so the center panel doesn't look funny
        getButton.doClick();
        lNameField.requestFocus();  // set focus to last name field (most common lookup)
    }

    public DatabaseManager getDBManager() {
      return myDB;
    }
    
    /* inner class GetListener */
    class GetListener implements ActionListener {  // Gets the entries from the text fields

        public void actionPerformed(ActionEvent aEvent) {
            // Get whatever the user entered, trim any white space and change to upper case
            String last  = lNameField.getText().trim().toUpperCase();
            String first = fNameField.getText().trim().toUpperCase();
            String ac    = areaCodeField.getText().trim().toUpperCase();
            String pre   = prefixField.getText().trim().toUpperCase();
            String sfx   = suffixField.getText().trim().toUpperCase();
            
            // Replace any single quote chars w/ space char or SQL will think the ' is the end of the string
            last  = last.replace('\'', ' ');
            first = first.replace('\'', ' ');
            ac    = ac.replace('\'', ' ');
            pre   = pre.replace('\'', ' ');
            sfx   = sfx.replace('\'', ' ');
            // Get rid of the last result displayed if there is one
            if(scrollPane != null)
                getContentPane().remove(scrollPane);
            // Only execute the query if one or more fields have data, else just display an empty table
            if(last.length()  > 0 ||
             first.length() > 0 ||
             ac.length()    > 0 ||
             pre.length()   > 0 ||
             sfx.length()   > 0) {
                // build the query and execute it. Provide the results to the table model
                myDB.doGetQuery(buildQuery(last, first, ac, pre, sfx));
                ResultSet rset = myDB.getResultSet();
                tblModel = new ListingsTableModel(rset);
                table = new JTable(tblModel);
            } else {
                table = new JTable();
            }
            // Allows the user to only delete one record at a time
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            // Add the table with the results to the contentPane and display it.
            scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            pack();
            doLayout();
        }

        public String buildQuery(String last, String first, String ac, String pre, String sfx) {
            String whereClause = " where";
            // Build the where clause
            if(last.length() > 0)
                whereClause += (" LAST_NAME = '" + last + "'");

            if(first.length() > 0) {
                if(whereClause.length() > 6)
                    whereClause += " AND";
                whereClause += (" FIRST_NAME = '" + first + "'");
            }

            if(ac.length() > 0) {
                if(whereClause.length() > 6)
                    whereClause += " AND";
                whereClause += (" AREA_CODE = '" + ac + "'");
            }

            if(pre.length() > 0) {
                if(whereClause.length() > 6)
                    whereClause += " AND";
                whereClause += (" PREFIX = '" + pre + "'");
            }

            if(sfx.length() > 0) {
                if(whereClause.length() > 6)
                    whereClause += " AND";
                whereClause += (" SUFFIX = '" + sfx + "'");
            }

            return "select LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX from Listings" + whereClause;
        }
    }   // End GetListener inner class

}  // End PhoneBookFrame class

