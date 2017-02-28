
public class ArrayDemo {
	public static void main(String[] args) {
		int array1[];
		
		array1 = new int[8];
		
		array1[0] = 42;
		array1[1] = 15;
		array1[2] = 74;
		array1[3] = 6;
		array1[4] = 32;
		array1[5] = 150;
		array1[6] = 724;
		array1[7] = 66;
		
		System.out.println("Size of the array array1 is " + array1.length);
		System.out.println();
		System.out.println("Element at index 1: " + array1[1]);
		System.out.println("Element at index 4: " + array1[4]);
		System.out.println("Element at index 6: " + array1[6]);
		System.out.println("Element at index 8: " + array1[7]);		
	}
}
