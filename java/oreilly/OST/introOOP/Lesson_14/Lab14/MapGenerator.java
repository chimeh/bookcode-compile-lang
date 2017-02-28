import java.applet.*;
import java.awt.*;

public class MapGenerator extends Applet {

	public Building[] CityBlock = new Building[2];
	
	public void paint(Graphics g) {
	
		CityBlock[0] = new MusicShop();
		CityBlock[1] = new PawnShop();
		
		for (int i = 0; i < CityBlock.length; i++) {
		
			CityBlock[i].construct(g);
		}
	}
}