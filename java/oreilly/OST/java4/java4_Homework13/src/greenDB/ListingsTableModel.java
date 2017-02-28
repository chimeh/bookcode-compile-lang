package greenDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

class ListingsTableModel extends AbstractTableModel {
    /** The result set from the Listings table to be displayed */
    private ResultSet rs;

    public ListingsTableModel(ResultSet rs) {
        this.rs = rs;
    }

    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int column) {
        try {
            String colName = rs.getMetaData().getColumnName(column + 1);
            // Return column names that look better than the database column names.
            // Since getColumnCount always returns 3, we only look for first 3 columns in
            // the result set.
            if(colName.equals("LAST_NAME"))
                return "Last Name";
            else if(colName.equals("FIRST_NAME"))
                return "First Name";
            else if(colName.equals("AREA_CODE"))
                return "Phone Number";
            else if (colName.equals("PRI_KEY"))
                return "ID";
            else return colName;      // Should never get here.

        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public Object getValueAt(int row, int column) {
        try {
            rs.absolute(row + 1);
            // for the 3rd column in the results, combine all of the phone number fields for output
            if(column == 3)
                return "(" + rs.getObject(column + 1) + ") " + rs.getObject(column + 2) + "-" + rs.getObject(column + 3);
            else
                return rs.getObject(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}  // End ListingsTableModel class
