package greenDB;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A listener that is applied to any of the telephone number fields (area code, prefix,
 * and extension). The purpose of this listener is to prevent more than the expected number
 * of characters from being entered in the telephone number fields. That is, the area code and
 * prefix fields might only be allowed to contain 3 characters each while the extension field
 * might only be allowed to contain four characters. The PhoneDocumentListener class accomplishes
 * this by accepting a 'numbers allowed' parameter during construction. Every time a character is
 * entered in the phone number field to which this listener applies, the insertUpdate method is
 * called. The insertUpdate method checks the number of characters in the field and if the number
 * is equal to 'numbers allowed', focus is transferred to the next component.
 *
 * @author David Green
 * @version 1.0
 */
class PhoneDocumentListener implements DocumentListener {
    /** The phone number text field to which this listener applies */
    private JTextField txtField;
    /** The number of characters that will cause focus to be transferred */
    private int numsAllowed;
    
    /* PhoneDocumentListener */
    /**
     * The PhoneDocumentListener constructor.
     * @param tf The phone number text field to which this listener applies.
     * @param numsAllowed The number of characters that can be entered in this field.
     */
    public PhoneDocumentListener(JTextField tf, int numsAllowed) {
        txtField = tf;
        this.numsAllowed = numsAllowed;
    }
    
    /* insertUpdate */
    /**
     * Called when a character is typed in the field to which this listener is applied.
     * The field is examined for number of characters and if the number is equal to the
     * numbers allowed, as specified during construction, focus is transferred to the next
     * component.
     * <pre>
     * PRE:
     * POST: Focus is transferred if field length equals numsAllowed; else nothing happens.
     * </pre>
     * @param dEvent An event generated as a result of a character being entered in the
     * telephone number field to which this listener is applied.
     */
    public void insertUpdate(DocumentEvent dEvent) {
        if(dEvent.getDocument().getLength() == numsAllowed)
            txtField.transferFocus();
    }
    
    /** Empty implementation. Method necessary for implementation of DocumentListener */
    public void removeUpdate(DocumentEvent dEvent) {}
    /** Empty implementation. Method necessary for implementation of DocumentListener */
    public void changedUpdate(DocumentEvent dEvent) {}
} // End PhoneDocumentListener class
