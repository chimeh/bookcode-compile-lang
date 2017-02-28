import java.util.Scanner;
          
public class SalesReport{
    int salespeople;
    int sum;
    int sales[];
    Scanner scan = new Scanner(System.in); 
    int userInput;
          
    public SalesReport(int howMany){
        this.salespeople = howMany;
        this.sales = new int[salespeople];
    }
          
    public SalesReport(){
        System.out.print("Enter the number of salespersons: ");
        this.salespeople = scan.nextInt();
        this.sales = new int[salespeople];
    } 
          
    public void testMe(){
        getSalesInput();
        provideSalesOutput();
        computeAverage(sum);
        findMax();
        findMin();
        getInput();
        getUserInput();
    }
          
    public void getSalesInput(){
    	for (int i=0; i < sales.length;  i++)
        {
            System.out.print("Enter sales for salesperson " + (i+1) + ": ");
            sales[i] = scan.nextInt();
        }
    }
          
    public void provideSalesOutput(){
        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i < sales.length;  i++)
        {
            System.out.println("     " + (i+1) + "         " + sales[i]);
            sum = sum + sales[i];
        }
        System.out.println("\nTotal sales: " + sum);
    }
          
    public void findMax(){
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
        System.out.println("Salesperson " + (who+1) + " had the highest sale with $" + max );
    }
    
    //Find and print the minimum sale. Print both the ID of the salesperson with the min sale and the amount of the sale;
    public void findMin(){
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
        System.out.println("Salesperson " + (who+1) + " had the lowest sale with $" + min );
    }

    //After the list, sum, average, max, and min have been printed, ask the user to enter a value.
    public void computeAverage(int sum) {
    	double average = (double)sum/sales.length;
    	System.out.println("Average sales: " + average);
    };
    
    public void getInput(){
    	System.out.print("Please enter a value: " );
    	userInput = scan.nextInt();
    }

    //Then print the ID of each salesperson who exceeded that amount, and the amount of their sales.
    public void getUserInput(){
        int count = 0;
    	for (int i=0; i < sales.length;  i++)
        {
            if (userInput < sales[i])
            {
            	System.out.println("Salesperson " + (i+1) + " exceeded amount with sales of $" + sales[i] );
            	count++;
            }
        }
    	//Also print the total number of salespeople whose sales exceeded the value entered.
    	System.out.println("Total Salesperson that exceeded input amount: " + count);
    }
}


