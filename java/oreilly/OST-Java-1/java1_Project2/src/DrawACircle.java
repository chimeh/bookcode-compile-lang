
//use the applet and abstract windowing libraries
//import statements

import java.applet.Applet;
import java.awt.*;


//define two classes ComputeUnitCircle and DrawACircle

//****************************************************************************
//****************************** DrawACircle *********************************
//****************************************************************************

//This class creates an applet which will display a circle that changes color 
//from red to black and back again each time it is painted

public class DrawACircle extends Applet
{
	ComputeUnitCircle myCircle=new ComputeUnitCircle();
	int lastx=50;
	int lasty=25;
	int x=0;
	int y=0;
	boolean z=true;   //not very meaningful variable name but not an error

	// this method is called each time the applet must be repainted 
	// because of an event like a window or cursor being moved over the applet

	public void paint(Graphics g)
	{
		if(z) 	//if z is true do the following 
		{
			z=false;
			g.setColor(Color.red);//change pen color to red
		}
		else	     //if z is false do the following
		{
			z=true;
			g.setColor(Color.black);//change pen color to black
		}
		
		  //draw 360 line segments that approximate a circle
		  //loop 360 times and draw a line connecting around the circle
		for( int degrees=0; degrees<361;degrees++)
		{
			//compute next point along the circle
		x=(int)(myCircle.ComputeX((double)degrees/180*Math.PI)*24+25);
		y=(int)(myCircle.ComputeY((double)degrees/180*Math.PI)*24+25);

			//draw a line from previous end point to next point
			g.drawLine(lastx,lasty,x,y);

			lastx=x;   //beginning of next line 
			lasty=y;

			//debugging code that displays in the console 
		System.out.println("degrees="+degrees+" x="+x + " y="+y);
			System.out.println("z="+z);
		}
			
	}
}
//****************************************************************************
//*********************** end of DrawACircle *********************************
//****************************************************************************


//****************************************************************************
//****************************** ComputeUnitCircle ***************************
//****************************************************************************

//This class computes the x and y location along the unit circle
//The unit circle is discussed in any trigonometry text

class ComputeUnitCircle
{
	//compute the x value along the unit circle
	//inputs are the radian angle ( 0 to 2 pi)
	//outputs are the x value along the circle
	//uses the java.lang.Math class to compute the cos of the angle
	double ComputeX( double RadianAngle)
	{
		return Math.cos(RadianAngle);
	}
	
	//compute the y value along the unit circle
	//inputs are the radian angle ( 0 to 2 pi)
	//outputs are the y value along the circle
	//uses the java.lang.Math class to compute the sin of the angle
	double ComputeY(double RadianAngle)
	{	
		return Math.sin(RadianAngle);
	}	
}
//****************************************************************************
//*********************** end of ComputeUnitCircle ***************************
//****************************************************************************

