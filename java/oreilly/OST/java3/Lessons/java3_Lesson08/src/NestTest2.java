import java.applet.Applet;
import java.awt.Graphics;

public class NestTest2 extends Applet {

  NestTest.BirthDayClass birthDate;
  
  public void init() {
    birthDate = new NestTest.BirthDayClass();
  }
  
  public void paint(Graphics g) {
    g.drawString("Birthdate from birthDate object: "
        + birthDate.getBirthMonth() + "/" + birthDate.getBirthDay()
        + "/" + birthDate.getBirthYear(), 0, 40);
  }
}
