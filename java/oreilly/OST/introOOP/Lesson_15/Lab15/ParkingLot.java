import java.awt.*;

public class ParkingLot extends Pavement{

	public void ParkingLot(){
	}

	public void pave(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(10, 150, 50, 50);
	}
}