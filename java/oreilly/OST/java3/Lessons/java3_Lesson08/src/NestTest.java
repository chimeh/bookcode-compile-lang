import java.applet.Applet;
import java.awt.Graphics;


public class NestTest extends Applet {

  private static int defaultBirthYear = 1958;
  private static int defaultBirthMonth = 12;
  private static int defaultBirthDay = 23;
  
  private BirthDayClass birthDate;
  
  public void init() {
    birthDate = new BirthDayClass();
  }
  
  public void paint(Graphics g) {
    g.drawString("Default Birthdate: " + defaultBirthMonth + "/" + defaultBirthDay + "/"
          + defaultBirthYear, 0, 20);
    g.drawString("Birthdate from birthDate object: " + birthDate.getBirthMonth() + "/" 
          + birthDate.getBirthDay() + "/" + birthDate.getBirthYear(), 0, 40); 
  }
  
  public static class BirthDayClass{
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    public int getBirthYear() {
      return birthYear;
    }
    public void setBirthYear(int birthYear) {
      this.birthYear = birthYear;
    }
    public int getBirthMonth() {
      return birthMonth;
    }
    public void setBirthMonth(int birthMonth) {
      this.birthMonth = birthMonth;
    }
    public int getBirthDay() {
      return birthDay;
    }
    public void setBirthDay(int birthDay) {
      this.birthDay = birthDay;
    }
    
    public BirthDayClass() {
      birthYear = defaultBirthYear;
      birthMonth = defaultBirthMonth;
      birthDay = defaultBirthDay;
    }
  }
}
