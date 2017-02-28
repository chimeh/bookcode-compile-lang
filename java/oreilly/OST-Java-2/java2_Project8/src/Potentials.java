import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Potentials extends Applet implements ActionListener {
	  private TextField yearField;
	  private int birthYear = 0;

	  public void init() {
	    Label l = new Label("Enter your birth year"); 
	    add(l);             
		  
	    yearField = new TextField(4);
	    add(yearField);
	    yearField.addActionListener(this);
	    
	    Button reset = new Button("Reset");
	    add(reset);
	    reset.addActionListener(this);
	    
	    resize(400,300);
	  }

	  public void paint(Graphics g) {
		Calendar rightNow = Calendar.getInstance();
		int currentYear = rightNow.get(Calendar.YEAR);
		int age = currentYear - birthYear;
		
		if ((age >= 0) && (age <= 9))
			g.drawString("Almost a decade - enjoy the early years.", 10, 110);
		else if ((age >= 10) && (age <= 19))
			g.drawString("One decades - install good values.", 10, 110);
		else if ((age >= 20) && (age <= 29))
			g.drawString("Two decades - know that the world is full of opportunities", 10, 110);
		else if ((age >= 30) && (age <= 39))
			g.drawString("Three decades - try to establish yourself.", 10, 110);
		else if ((age >= 40) && (age <= 49))
			g.drawString("Four decades - enjoy your family.", 10, 110);
		else if ((age >= 50) && (age <= 59))
			g.drawString("Five decades - look at all that you accomplished.", 10, 110);
		else if ((age >= 60) && (age <= 69))
			g.drawString("Six decades - enjoy your grandkids.", 10, 110);
		else if ((age >= 70) && (age <= 79))
			g.drawString("Seven decades - spend time for yourself.", 10, 110);
		else if ((age >= 80) && (age <= 89))
			g.drawString("Eight decades - discover all that is to know.", 10, 110);
		else if ((age >= 90) && (age <= 99))
			g.drawString("Nine decades - treasure what you have.", 10, 110);
		else
			g.drawString("Age out of range.  Please enter birth year again.", 10, 110);
	  }

	  public void actionPerformed(ActionEvent event) {
	    if (event.getSource() instanceof Button) {
	    	birthYear = 0;
	    	yearField.setText("");
	    }
	    else if (event.getSource() instanceof TextField)
		  
		if (yearField.getText().length() == 0)
			birthYear = 0;
	    else
	    	birthYear = Integer.parseInt(yearField.getText());
	    repaint();
	  }
}
