import java.applet.*;
import java.awt.*;

public class ProjectApplet extends Applet {

	Cake cake1;
	Cake cake2;
	Cake cake3;
	Cake cake4;
	Cake cake5;
	
	public void init() {
		cake1 = new Cake(0,0,"wedding");
		cake2 = new Cake(0,200,"vanilla");
		cake3 = new Cake(0,400,"lemon");
		cake4 = new Cake(100,0,"blueberry");
		cake5 = new Cake(100,200,"strawberry");
	}
	
	public void paint (Graphics g){
		cake1.frostCake(Color.gray, g);
		cake2.frostCake(Color.white, g);
		cake3.frostCake(Color.yellow, g);
		cake4.frostCake(Color.blue, g);
		cake5.frostCake(Color.pink, g);
	}
}