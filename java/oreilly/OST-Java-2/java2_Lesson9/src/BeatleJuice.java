
public class BeatleJuice {
	public static void main(String[] args) {
		String[] beatles;
		
		beatles = new String[5];
		
		beatles[0] = "John Lennon";
		beatles[1] = "Paul McCartney";
		beatles[2] = "George Harrison";
		beatles[3] = "Ringo Starr";
		beatles[4] = "George Martin";
	
		System.out.println("Element at index 0: " + beatles[0]);
		System.out.println("Element at index 1: " + beatles[1]);
		System.out.println("Element at index 2: " + beatles[2]);
		System.out.println("Element at index 3: " + beatles[3]);
		System.out.println("Element at index 4: " + beatles[4]);
	
		System.out.println("\n\nSize of the beatles array is " + beatles.length);
		int x = 1;
		System.out.println();
		System.out.println("When x=" + x + ", the element at beatles[x] is " + beatles[x]);
		System.out.println("When x=" + x + ", the element at beatles[x++] is " + beatles[x++]);
		System.out.println("After use and then increment, x is now " + x);
		System.out.println("With x=" + x + ", Element at beatles[++x] is " + beatles[++x]);
		System.out.println("After increment and then use, x is now " + x);
	}
}
