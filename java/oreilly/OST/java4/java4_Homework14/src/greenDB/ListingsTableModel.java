package greenDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/* class ListingsTableModel */
/**
 * This class provides methods for displaying the results returned from the Listings
 * table. The methods are used by a JTable object so the results may displayed in a cell format.
 *
 * @author David Green
 * @version 1.0
 */
class ListingsTableModel extends AbstractTableModel {
    /** The result set from the Listings table to be displayed */
    private ResultSet rs;

    /* ListingsTableModel */
    /**
     * The ListingsTableModel constructor.
     * @param rs the result set from the Listings table to be displayed.
     */
    public ListingsTableModel(ResultSet rs) {
        this.rs = rs;
    }

    /* getRowCount */
    /**
     * Returns the number of rows in the result set.
     * <pre>
     * PRE: True
     * POST: The number of rows in the result set is returned.
     * </pre>
     * @return the number of rows in the result set.
     */
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* getColumnCount */
    /**
     * Returns the number of columns to be displayed for the result set. Note that
     * this does not return the number of columns IN the result set. The three phone
     * number fields (area code, prefix, and extension) are combined together to form
     * a single column for output. This method always returns 3 for Last Name, First
     * Name, and Phone Number.
     * <pre>
     * PRE: True
     * POST: The number 3 is returned.
     * </pre>
     * @return the number 3, for the three output columns Last Name, First Name, and Phone Number.
     */
    public int getColumnCount() {
        return 4;
    }

    /* getColumnName */
    /**
     * Returns the name of the column specified by the index.
     * <pre>
     * PRE:  Column is assigned and 0 >= column <= 2.
     * POST: A column name is returned.
     * </pre>
     * @param column the index of the column name to be returned.
     * @return the column name specified.
     */
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

    /* getValueAt */
    /**
     * Returns the value in the result set at the location specified by row and column. If column
     * is equal to 2 (the AREA_CODE), combine the AREA_CODE, PREFIX, and SUFFIX for that row and
     * return the combined string.
     * <pre>
     * PRE:  row and column are assigned and 0 >= column <= 2 and row is within range.
     * POST: The value in the result set at row and column is returned, or the combined
     *       phone number is returned if column = 2.
     * </pre>
     * @param row the row of the result set whose value is to be returned.
     * @param column the column of the result set whose value is to be returned.
     * @return the value in the result set at row and column is returned, or the combined
     * phone number is returned if column = 2.
     */
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
