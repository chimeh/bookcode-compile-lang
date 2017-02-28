package greenDB;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/* class PhoneFocusListener */
/**
 * A listener that will delete any data currently in the telephone number fields (area code, prefix,
 * and extension) whenever focus is detected for those fields. This listener is used in conjunction with
 * the PhoneDocumentListener to prevent more than the expected number of characters from being entered
 * in the telephone number fields. That is, the area code and prefix fields will only be allowed to
 * contain three characters each while the extension field will only be allowed to contain four characters.
 *
 * @author David Green
 * @version 1.0
 */
class PhoneFocusListener implements FocusListener {

  /* focusGained */
  /**
   * Called when the field to which this listener applies gains focus. This method will delete
   * any data currently contained in the field.
   * <pre>
   * PRE:  True.
   * POST: Any data in the telephone number field to which this listener applies is deleted.
   * </pre>
   * @param fEvent An event generated as a result of focus being gained on this telephone number field.
   */
    public void focusGained(FocusEvent fEvent) {
        JTextField tf = (JTextField)fEvent.getSource();
        tf.setText("");
    }
    
    /** Not implemented */
    public void focusLost(FocusEvent fEvent){}
    
} // End PhoneFocusListener class

