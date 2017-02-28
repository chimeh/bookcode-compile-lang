package exceptionTesting;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileFetcher extends JComponent implements Accessible{
  String aLine=""; //looking at file one line at a time
  FileReader myFile;
  BufferedReader in;
  
  public void getHomework(){
    try {
      JFrame frame = new JFrame();
      JFileChooser chooser = new JFileChooser();
      
      chooser.showOpenDialog(frame);
      
      myFile = new FileReader(chooser.getSelectedFile().toString()); // create a Reader for a file
      System.out.println("I did get here");
      in = new BufferedReader(myFile);
    }
    catch (FileNotFoundException e) {
      System.out.println("That file is not accessible or does not exist, please select a valid file");
      System.exit(0);
    }
    
    while (aLine != null) {
      try {
        aLine = in.readLine();
      }
      catch(IOException e) {
        System.out.println("Now we have some other I/O problem");
      }
      if (aLine != null) System.out.println(aLine);
    }
    
    try {
      aLine = in.readLine();
    }
    catch (IOException e) {
      System.out.println("Now we have some other problem!");
    }
   
  }
  
  public static void main(String[] args) {
    FileFetcher testMe = new FileFetcher();
    testMe.getHomework();
  }
}
