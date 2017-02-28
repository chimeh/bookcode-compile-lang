/**
 * 
 */
package at.markusegger.RaceManagerData;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

import at.markusegger.RaceManagerObjects.*;

/**
 * An utility class providing load/save methods to the race manager program.
 * 
 * @author MarkusME
 * @version 0.8
 */
public class RaceFileManager
{
	static public ArrayList<RacingAthlete> loadAthletesFromFile(String loadFileName)
		throws NullPointerException, IOException, IllegalArgumentException, NumberFormatException
	{
		ArrayList<RacingAthlete> athletes = new ArrayList<RacingAthlete>();
		
		File loadFile = null;
		FileReader loadReader = null;
		BufferedReader loadBufferedReader = null;
		
		loadFile = new File(loadFileName);
		loadReader = new FileReader(loadFile);
		loadBufferedReader = new BufferedReader(loadReader);
		
		String line;
		
		while ((line = loadBufferedReader.readLine()) != null)
		{
			RacingAthlete a;
			
			line = line.trim();
			
			// A data line looks like "ATHLETETYPE|property1=value1;property2=value2;..."
			String[] typeAndProps = line.split("\\|");
			
			// There should be one and only one pipe character in the line
			if (typeAndProps.length != 2)
			{
				throw new IllegalArgumentException("No proper pipe-delimited line: " + line);
			}
			
			// Create an object based on the string representation of the type
			switch (typeAndProps[0].trim().toLowerCase())
			{
				case "biker":
					a = new Biker();
					break;
				
				case "runner":
					a = new Runner();
					break;
				
				case "swimmer":
					a = new Swimmer();
					break;
				
				default:
					throw new IllegalArgumentException("Unknown athlete type: " + typeAndProps[0].trim());
			}
			
			// Property-value pairs are delimited by semicolon
			// property1=value1;property2=value2;...
			String[] pvPairs = typeAndProps[1].split(";");
			
			// There is a minimum of 4 basic properties required for the RacingAthlete class
			if (pvPairs.length < 4)
			{
				throw new IllegalArgumentException("Expected at least four property name-value pairs");
			}
			
			Hashtable<String, String> properties = new Hashtable<String, String>();
			
			// Now we will parse the property-value pairs
			for (String pv : pvPairs)
			{
				// Name and value are separated by equal sign '='
				// property1=value1
				String[] pvSplit = pv.split("=");
				
				// A proper pair separated by one '=' can only result in a two-element array,
				// 0 = name, 1 = value
				if (pvSplit.length != 2)
				{
					throw new IllegalArgumentException("Not a proper name-value pair: " + pv);
				}
				
				// 0 = name, 1 = value
				properties.put(pvSplit[0].trim(), pvSplit[1].trim());
			}
			
			// Now let's browse through the hashtable and act on all properties we know of.
			if (properties.containsKey("name"))
			{
				a.setName(properties.get("name"));
			}
			
			if (properties.containsKey("age"))
			{
				a.setAge(Integer.parseInt(properties.get("age")));
			}
			
			if (properties.containsKey("contestantID"))
			{
				a.setContestantID(Integer.parseInt(properties.get("contestantID")));
			}
			
			if (properties.containsKey("isInjured"))
			{
				a.setIsInjured(Boolean.parseBoolean(properties.get("isInjured")));
			}
			
			// We mustn't forget the properties of specific sub-classes
			if (a instanceof Biker)
			{
				if (properties.containsKey("usingClips"))
				{
					((Biker) a).setUsingClips(Boolean.parseBoolean(properties.get("usingClips")));
				}
			}
			
			if (a instanceof Runner)
			{
				if (properties.containsKey("shoeBrand"))
				{
					((Runner) a).setShoeBrand(properties.get("shoeBrand"));
				}
			}
			
			// Swimmer has no specific properties
			/*if (a instanceof Swimmer)
			{
				
			}*/
			
			athletes.add(a);
		}
		
		// Clean-up
		loadBufferedReader.close();
		loadBufferedReader = null;
		
		loadReader.close();
		loadReader = null;
		
		loadFile = null;
		
		// Result
		return athletes;
	}
	
	static public void saveAthletesToFile(ArrayList<RacingAthlete> athletes, String saveFileName)
		throws NullPointerException, IOException
	{
		File saveFile = null;
		FileWriter saveWriter = null;
		BufferedWriter saveBufferedWriter = null;

		saveFile = new File(saveFileName);
		
		saveWriter = new FileWriter(saveFile);
		
		saveBufferedWriter = new BufferedWriter(saveWriter);
		
		for (RacingAthlete a : athletes)
		{
			saveBufferedWriter.write(a.toDataString());
			
			saveBufferedWriter.newLine();
		}
		
		saveBufferedWriter.flush();
		
		saveBufferedWriter.close();
		saveBufferedWriter = null;
		
		saveWriter.close();
		saveWriter = null;
		
		saveFile = null;
	}
}
