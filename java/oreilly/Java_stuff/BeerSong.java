public class BeerSong {
	
	public static void main(String[] args) {
		for (int numBottles = 99; numBottles > 0; numBottles--) {
			if (numBottles == 1) {
				System.out.println("1 bottle of beer on the wall.");
				System.out.println("1 bottle of beer.");
			} else {
				System.out.println(numBottles + " bottles of beer on the wall.");
				System.out.println(numBottles + " bottles of beer.");
			}
			System.out.println("Take one down, pass it around...");
			
			if ((numBottles -1) == 0) {
				System.out.println("No more bottles of beer on the wall.");
				System.out.println("Stop singing.");
			} else {
				System.out.println((numBottles - 1) + " bottles of beer on the wall.");
				System.out.println();
			} 
		}
	}
}