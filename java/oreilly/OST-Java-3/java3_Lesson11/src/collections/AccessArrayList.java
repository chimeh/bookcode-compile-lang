package collections;

import java.util.ArrayList;

public class AccessArrayList {
	public static void main (String[] args) {
		AccessArrayList testing = new AccessArrayList();
		testing.tryThis();
	}
	
	public void tryThis() {
		ArrayList <String> beatles = new ArrayList<String>();
		
		System.out.println ("Size of beatles at start: " + beatles.size());
		beatles.add("John");
		beatles.add("Paul");
		beatles.add("George");
		beatles.add("Ringo");
		beatles.add("MetamorphosisGuy");
		
		System.out.println (beatles);
		System.out.println ("Size of beatles after adding: " + beatles.size());
		
		int location = beatles.indexOf("MetamorphosisGuy");
		beatles.remove(location);
		
		System.out.println("After removing location " + location + "\n beatles are " + beatles);
		System.out.println("At index 1 is " + beatles.get(1));
		
		beatles.add (2, "Mick");
		
		System.out.println("After adding Mick at location 2 \n " + beatles);
		System.out.println("Size of beatles: " + beatles.size());
		
	}
}
