
public class PhoneBook {
  
  final int SIZE = 10;
  private String[] name;
  private String[] phoneNumber;
  
  public PhoneBook() {
      this.name = new String[SIZE];
      this.phoneNumber = new String[SIZE];
  }
  
  public void setName(String name, int x) {
    this.name[x]=name;
  }

  public void setNumber(String phoneNumber, int x) {
    this.phoneNumber[x]=phoneNumber;
  }
  
  public String toString() {
    String retValue;
    
    retValue =
        this.name[0] +"\t" + this.phoneNumber[0] + "\n" +
        this.name[1] +"\t" + this.phoneNumber[1] + "\n" +
        this.name[2] +"\t" + this.phoneNumber[2] + "\n" +
        this.name[3] +"\t" + this.phoneNumber[3] + "\n" +
        this.name[4] +"\t" + this.phoneNumber[4] + "\n" +
        this.name[5] +"\t" + this.phoneNumber[5] + "\n" +
        this.name[6] +"\t" + this.phoneNumber[6] + "\n" +
        this.name[7] +"\t" + this.phoneNumber[7] + "\n" +
        this.name[8] +"\t" + this.phoneNumber[8] + "\n" +
        this.name[9] +"\t" + this.phoneNumber[9] + "\n";
    return retValue;
  }
    
  public String[] getRecord(int i) {
    String[] recordArray = new String[2];
      recordArray[0] = this.name[i];
      recordArray[1] = this.phoneNumber[i];
      return recordArray;
  }
  
  public int nextIndex() {
    int indexValue = 0;
    int count = 0;
    
      while((this.name[count] != null) && (count < this.SIZE)) {
        count += 1;
      }
    
      if(this.name[count] == null) {
        indexValue = count;
      }
      else {
        indexValue = -1;
      }
  
    return indexValue;
  }

  public int getRecord(String name) {
    int indexNumber = -1;
    
    for(int i = 0; i < this.SIZE; i++) {
      if(name == this.name[i]) {
        indexNumber = i;
      }
    }
    return indexNumber;
  }


  
}
