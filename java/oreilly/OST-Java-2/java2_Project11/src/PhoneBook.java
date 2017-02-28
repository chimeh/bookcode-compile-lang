public class PhoneBook {
	//Two private instance variables that are String arrays. 
	//One array represents names and the other array represents phone numbers.
	final int ARRAY_SIZE = 10;
    private String[] phoneName;
    private String[] phoneNumber;
	
	public PhoneBook() {
		//fill arrays with data
		phoneName = new String[ARRAY_SIZE];
		phoneNumber = new String[ARRAY_SIZE];
	}
	
	public String toString() {
		String formatPhoneList = "";
		for(int i = 0; i < phoneName.length; i++) {
			formatPhoneList = phoneName[i] + "-" + phoneNumber[i] + "-";
		}	
		return formatPhoneList;
		//method that returns a formatted string representation of the entire class.
	}
	
	public boolean setName(String namePara, int arrayIndex) {
		if ((arrayIndex >= 0) && (arrayIndex < phoneName.length)) {
			phoneName[arrayIndex] = namePara;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setNumber(String phonePara, int arrayIndex) {
		if ((arrayIndex >= 0) && (arrayIndex < phoneNumber.length)) {
			phoneNumber[arrayIndex] = phonePara;
			return true;
		} else {
			return false;
		}
	}
	
	public String[] getRecord(int recordIndex) {
		if ((recordIndex >= 0) && (recordIndex < phoneNumber.length) && (recordIndex < phoneName.length)) {
			if ((phoneName[recordIndex] != null) && (phoneNumber[recordIndex] != null)) {
				String[] recordValues = new String[2];
				recordValues[0] = phoneName[recordIndex];
				recordValues[1] = phoneNumber[recordIndex];				
				return recordValues;
			} else {
				return null;
			}		
		} else {
			return null;
		}
	
	}
	
	public int nextIndex() {
		int j = -1;
		for(int i = 0; i < phoneName.length; i++) {
			if (phoneName[i] == null) {
				j = i;
			} 
		}	
		return j;
	}
	
	public int getRecord(String personName) {
		int j = -1;
		for(int i = 0; i < phoneName.length; i++) {
			if ((phoneName[i] != null) && (phoneName[i].equalsIgnoreCase(personName))) {
				j = i;
			} 
		}	
		return j;
	}	
}
