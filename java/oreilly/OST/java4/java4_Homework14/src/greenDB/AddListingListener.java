package greenDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* class AddListingListener */
/**
 * A listener for when the add button is clicked. The add button looks like a plus ("+") sign. The
 * AddListingListener creates and displays an AddListingDialog box when actionPerformed is called.
 *
 * @author David Green
 * @version 1.0
 */
class AddListingListener implements ActionListener {
    /** The SimplePhoneBook application frame */
    PhoneBookFrame pbf;
    
    /* AddListingListener */
    /**
     * The AddListingListener constructor.
     * @param pbFrame the SimplePhoneBook application frame object.
     */
    public AddListingListener(PhoneBookFrame pbFrame) {
        pbf = pbFrame;
    }
    
    /* actionPerformed */
    /**
     * Instantiates and displays the Add Listings Dialog Box. This method is  
     * called when the "+" button is clicked.
     * <pre>
     * PRE:
     * POST: The Add Listings Dialog Box is displayed on screen.
     * </pre>
     * @param aEvent an event generated as a result of the "+" button being clicked.
     */
    public void actionPerformed(ActionEvent aEvent) {
        AddListingDialog addDialog = new AddListingDialog(pbf);
        addDialog.setVisible(true);
    }
}  // End AddListingListener class 
