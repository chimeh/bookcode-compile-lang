import java.applet.*;
import java.awt.*;

public class CakeIf extends Applet {

	String cakeType, recipient;
	Cake birthdayCake, anniversaryCake, graduationCake, anyCake;
	
	public void paint(Graphics g) {
	
		cakeType = "new baby";
	
		if (cakeType == "birthday" || cakeType == "new baby") {
			birthdayCake = new Cake(20, 20, "Happy Birthday!");
			birthdayCake.frostCake(Color.blue, g);
		}
		
		else if (cakeType == "birthday") {
			birthdayCake = new Cake(20, 20, "Happy Birthday!");
			birthdayCake.frostCake(Color.red, g);
		}
	
		else if (cakeType == "anniversary") {
			anniversaryCake = new Cake(20, 20, "Happy Anniversary!");
			anniversaryCake.frostCake(Color.pink, g);
		}
	
		else if (cakeType == "graduation") {
			graduationCake = new Cake(20, 20, "Con-GRAD-ulations!");
			graduationCake.frostCake(Color.orange, g);
		}
		
		else {
			anyCake = new Cake(20, 20, "Yay!");
			anyCake.frostCake(Color.yellow, g);
		}
	
	}
}