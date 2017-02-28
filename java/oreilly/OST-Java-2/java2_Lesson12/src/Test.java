public class Test {
	int total;
	
	public static void main(String[] args) {
		Test myTest = new Test();
		myTest.demo();
	}
	
	public void demo() {
		int[] table = new int[12];
		for (int i=0; i < table.length; i++) {
			table[i] = 1;
			System.out.print(table[i] + " ");
		}
		
		int[] table2 = new int[12];
		System.arraycopy(table, 0, table2, 0, table.length);
		total = sum(table2);
		
		total = sum(table);
		System.out.println("The total is " + total);
		System.out.println("After method invocation completes \n and control has returned, values are");
		for (int i = 0; i < table.length; i++)
			System.out.print(table[i] + " ");
	}
	
	public int sum(int [] array) {
		total = 0;
		for (int s=0; s < array.length; s++) {
			total = total + array[s];
			array[s] = array[s] + 1;
		}	
		return total;
	}
} 
