import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid extends Applet implements ActionListener {
	Box boxOne, boxTwo, boxThree, boxFour, boxFive, boxSix, boxSeven, boxEight, boxNine, boxTen, boxEleven, boxTwelve, boxThirteen, boxFourteen, boxFifteen, boxSixteen; //16 declarations for Box instances
	String action; //Instance Variable telling what action is being done
	
	public void init() {
		List actionList = new List(3);  //makes a list to choose from
		actionList.add("colorful");    //give the list 3 choices
		actionList.add("red_theme");
		actionList.add("blue_theme");
		
		actionList.addActionListener(this);  //tell Java to listen for user input
		add(actionList);                     //add the list to the Applet
		
		boxOne = new Box(60, 60, 50, 50, Color.magenta); 
		boxTwo = new Box(110, 60, 50, 50, Color.lightGray); 
		boxThree = new Box(160, 60, 50, 50, Color.green);
		boxFour = new Box(210, 60, 50, 50, Color.orange); 
		
		boxFive = new Box(60, 110, 50, 50, Color.darkGray); 
		boxSix = new Box(110, 110, 50, 50, Color.cyan); 
		boxSeven = new Box(160, 110, 50, 50, Color.blue);
		boxEight = new Box(210, 110, 50, 50, Color.gray); 
		
		boxNine = new Box(60, 160, 50, 50, Color.red.brighter()); 
		boxTen = new Box(110, 160, 50, 50, Color.yellow.darker()); 
		boxEleven = new Box(160, 160, 50, 50, Color.black);
		boxTwelve = new Box(210, 160, 50, 50, Color.pink.darker()); 
		
		boxThirteen = new Box(60, 210, 50, 50, Color.pink); 
		boxFourteen = new Box(110, 210, 50, 50, Color.red); 
		boxFifteen = new Box(160, 210, 50, 50, Color.white); 
		boxSixteen = new Box(210, 210, 50, 50, Color.yellow); 
				
		resize(350,280); //resize the applet window so that we can see both dukes
	}
	
	public void paint(Graphics g) {
		boxOne.display(g);
		boxTwo.display(g);
		boxThree.display(g);
		boxFour.display(g);
		
		boxFive.display(g);
		boxSix.display(g);
		boxSeven.display(g);
		boxEight.display(g);
		
		boxNine.display(g);
		boxTen.display(g);
		boxEleven.display(g);
		boxTwelve.display(g);
		
		boxThirteen.display(g);
		boxFourteen.display(g);
		boxFifteen.display(g);
		boxSixteen.display(g);
	}
	
	public void actionPerformed(ActionEvent evt) {
		String userChoice = evt.getActionCommand();
		if (userChoice == "colorful") {
			boxOne.setBoxColor(Color.magenta);
			boxTwo.setBoxColor(Color.lightGray);
			boxThree.setBoxColor(Color.green);
			boxFour.setBoxColor(Color.orange);
			boxFive.setBoxColor(Color.darkGray);
			boxSix.setBoxColor(Color.cyan);
			boxSeven.setBoxColor(Color.blue);
			boxEight.setBoxColor(Color.gray);
			boxNine.setBoxColor(Color.red.brighter());
			boxTen.setBoxColor(Color.yellow.darker());
			boxEleven.setBoxColor(Color.black);
			boxTwelve.setBoxColor(Color.pink.darker());
			boxThirteen.setBoxColor(Color.pink);
			boxFourteen.setBoxColor(Color.red);
			boxFifteen.setBoxColor(Color.white);
			boxSixteen.setBoxColor(Color.yellow);
		} else if (userChoice == "red_theme") {
			boxOne.setBoxColor(Color.red);
			boxTwo.setBoxColor(Color.pink);
			boxThree.setBoxColor(Color.red);
			boxFour.setBoxColor(Color.pink);
			boxFive.setBoxColor(Color.pink);
			boxSix.setBoxColor(Color.red);
			boxSeven.setBoxColor(Color.pink);
			boxEight.setBoxColor(Color.red);
			boxNine.setBoxColor(Color.red);
			boxTen.setBoxColor(Color.pink);
			boxEleven.setBoxColor(Color.red);
			boxTwelve.setBoxColor(Color.pink);
			boxThirteen.setBoxColor(Color.pink);
			boxFourteen.setBoxColor(Color.red);
			boxFifteen.setBoxColor(Color.pink);
			boxSixteen.setBoxColor(Color.red);	
		} else if (userChoice == "blue_theme") {
			boxOne.setBoxColor(Color.blue);
			boxTwo.setBoxColor(Color.cyan);
			boxThree.setBoxColor(Color.blue);
			boxFour.setBoxColor(Color.cyan);
			boxFive.setBoxColor(Color.cyan);
			boxSix.setBoxColor(Color.blue);
			boxSeven.setBoxColor(Color.cyan);
			boxEight.setBoxColor(Color.blue);
			boxNine.setBoxColor(Color.blue);
			boxTen.setBoxColor(Color.cyan);
			boxEleven.setBoxColor(Color.blue);
			boxTwelve.setBoxColor(Color.cyan);
			boxThirteen.setBoxColor(Color.cyan);
			boxFourteen.setBoxColor(Color.blue);
			boxFifteen.setBoxColor(Color.cyan);
			boxSixteen.setBoxColor(Color.blue);
		}
		
		repaint();  //if a different choice has been made, call our paint through repaint()
	}
}

