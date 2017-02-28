package utilities;

public class SalesComputations {
	
	public static double computeAverage(int[] sales) {
    	int sum = getTotalSales(sales); 
    	if(sales.length != 0) { 
    		return (double) sum / sales.length; 
    	}
    	return Double.MIN_VALUE; 
    }
	
	public static int getTotalSales(int[] sales) {
    	int sum = 0;
		for (int i=0; i < sales.length;  i++)
        {
            sum = sum + sales[i];
        }
    	return sum;
    	
    }
	
	public static int findMax(int[] sales){
        int max = sales[0];
        
        for (int i=0; i < sales.length;  i++)
        {
            if (max < sales[i])
            {
                max = sales[i];
            }
        }
        return max;
    }
	
	public static int findMaxPerson(int[] sales){
        int max = sales[0];
        int who = 0;
        for (int i=0; i < sales.length;  i++)
        {
            if (max < sales[i])
            {
                max = sales[i];
                who = i;
            }
        }       
        return who;
    }
	
	public static int findMin(int[] sales){
        int min = sales[0];
        for (int i=0; i < sales.length;  i++)
        {
            if (min > sales[i])
            {
                min = sales[i];
            }
        } 
        return min;
    }
    
	public static int findMinPerson(int[] sales){
        int min = sales[0];
        int who = 0;
        for (int i=0; i < sales.length;  i++)
        {
            if (min > sales[i])
            {
                min = sales[i];
                who = i;
            }
        } 
        return who;
    } 
	
	public static int findExceedTotal(int[] sales, int inputAmt){
		int count = 0;
    	for (int i=0; i < sales.length;  i++)
        {
            if (inputAmt < sales[i])
            {
            	count++;
            }
        }
    	return count;
    } 
	
	public static boolean findWhoExceed(int[] sales, int arrayInd, int inputAmt){
		if (inputAmt < sales[arrayInd]) {
            return true;
        } else {
        	return false;
        }
    } 
}
