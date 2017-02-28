package algs.model.tests.array;

import org.junit.Test;

import algs.model.array.FirstSelector;
import algs.model.array.IPivotIndex;
import algs.model.array.LastSelector;
import algs.model.array.MedianSelector;
import algs.model.array.PISelector;
import algs.model.array.QuickSort;
import algs.model.array.RandomSelector;

import junit.framework.TestCase;


public class QuickSortTest extends TestCase {
	
	IPivotIndex[] selectors = new IPivotIndex[]{
			new FirstSelector(), 
			new LastSelector(), 
			new PISelector(5), 
			new RandomSelector(),
			new MedianSelector(),
	};
	
	private Integer[] createRandom(int num) {
		Integer[] set = new Integer[num];
		for (int i = 0; i < num; i++) {
			set[i] = (int)(Math.random()*100000);
		}
		
		return set;
	}
	
	
	
	@Test
	public void testNoImpact() {
		Integer[] data = { 9, 7, 4, 2};
		QuickSort<Integer> qs = new QuickSort<Integer>(data);
		
		// nonsense request
		qs.qsort(2, 2);
		
		assertEquals (9, (int)data[0]);
		assertEquals (7, (int)data[1]);
		assertEquals (4, (int)data[2]);
		assertEquals (2, (int)data[3]);
	}
	
	@Test
	public void testBasic() {
		int  numTrials = 10;
		int  numPoints = 100;
		for (int i = 0; i < numTrials; i++) {
			for (int ms = 0; ms < 10; ms++) {
				
				Integer[]rnd = createRandom(numPoints);
				
				// try for first one.
				Integer[] copy = new Integer[rnd.length];
				System.arraycopy(rnd, 0, copy, 0, rnd.length);
				
				QuickSort<Integer> qs = new QuickSort<Integer>(copy);
				qs.setPivotMethod(selectors[0]);
				qs.qsort(0, rnd.length-1);
				
				for (int s = 1; s < selectors.length; s++) {
					Integer[] copy2 = new Integer[rnd.length];
					System.arraycopy(rnd, 0, copy2, 0, rnd.length);
				
					QuickSort<Integer> qs2 = new QuickSort<Integer>(copy2);
					qs2.setPivotMethod(selectors[s]);
					qs2.setMinimumSize(ms);
					qs2.qsort(0, rnd.length-1);
					
					// check
					for (int x = 0; x < rnd.length-1; x++) {
						if (copy2[x].intValue() != copy[x].intValue()) {
							fail ("different selectors had different order @" + x + "[" + copy2[x] + "," + copy[x] + "]");
						}
					}
				}
				
			}
		}
			
	}
}
