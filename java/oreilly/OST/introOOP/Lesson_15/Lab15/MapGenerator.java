import java.applet.*;
import java.awt.*;

public class MapGenerator extends Applet {

	public Construct[] CityBlock = new Construct[4];
	
	public void paint(Graphics g) {
	
		CityBlock[0] = new MusicShop();
		CityBlock[1] = new PawnShop();
		CityBlock[2] = new Roads();
		CityBlock[3] = new ParkingLot();
		
		
		for (int i = 0; i < CityBlock.length; i++) {
		
			CityBlock[i].construct(g);
		}
	}
}