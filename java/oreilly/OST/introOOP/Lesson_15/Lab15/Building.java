import java.awt.*;

public abstract class Building implements Construct {

	public Building () {
	
	}
	
	public abstract void build(Graphics g);
	
	public void construct(Graphics g){
		build(g);
	}

}