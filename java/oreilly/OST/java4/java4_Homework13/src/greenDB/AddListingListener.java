package greenDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddListingListener implements ActionListener {
    /** The SimplePhoneBook application frame */
    PhoneBookFrame pbf;
    
    public AddListingListener(PhoneBookFrame pbFrame) {
        pbf = pbFrame;
    }
    
    public void actionPerformed(ActionEvent aEvent) {
        AddListingDialog addDialog = new AddListingDialog(pbf);
        addDialog.setVisible(true);
    }
}  // End AddListingListener class 
