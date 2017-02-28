package greenDB;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

class PhoneFocusListener implements FocusListener {

    /** an event generated as a result of focus being gained on this telephone number field.  */
    public void focusGained(FocusEvent fEvent) {
        JTextField tf = (JTextField)fEvent.getSource();
        tf.setText("");
    }
    
    /** Not implemented */
    public void focusLost(FocusEvent fEvent){}
    
} // End PhoneFocusListener class

