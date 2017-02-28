package utilities;

public class Sorts {
	public static void shellSort(Sortable[] a) {
		int n = a.length;
		int increment = n / 2;
		
		while (increment >= 1) {
			for (int i = increment; i < n; i++) {
				Sortable temp = a[i];
				int j = i;
				while (j >= increment && temp.compareTo(a[j - increment]) < 0) {
					a[j] = a[j - increment];
					j = j - increment;
				}
				a[j] = temp;
			}
			increment = increment/2;
		}
	}
}
