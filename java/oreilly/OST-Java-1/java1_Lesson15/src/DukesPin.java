import java.awt.Color;

public class DukesPin extends Dukes {
	private boolean showingPin;
	
	public DukesPin() {
		super();
		//you could add more here and Java will do the parent's first and then come back for more
	}
	
	public DukesPin(Color nose, boolean love) {
		super(nose, love);
	}
	
	public boolean isShowingPin() {
		return showingPin;
	}
	
	public void switchShowingPin() {
		showingPin = !showingPin;
		if (showingPin && !isAngry()) {
			setAngryMessage("I don't get a Pin, I'm not angry");
			showingPin = !showingPin; //don't let them show Pins since not angry
		}
	}
	
	public void setMood() {
		super.setMood();  //let the parent do the work first, then do what we need in addition
		if (isAngry() == false) showingPin = false;
	}
}
