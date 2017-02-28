import java.awt.*;

public abstract class Pavement implements Construct {

	public Pavement(){
	
	}
	
	public abstract void pave(Graphics g);
	
	public void construct(Graphics g) {
		pave(g);
	}
}