package salesIO;
import java.util.Scanner;
import utilities.SalesComputations;

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
        System.out.println ("Average Sales: " + SalesComputations.computeAverage(sales));
        System.out.println("Salesperson " + (SalesComputations.findMaxPerson(sales)+1) + " had the highest sale with $" + SalesComputations.findMax(sales));
        System.out.println("Salesperson " + (SalesComputations.findMinPerson(sales)+1) + " had the lowest sale with $" + SalesComputations.findMin(sales));
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

        for (int i=0; i < sales.length;  i++)
        {
            System.out.println("     " + (i+1) + "         " + sales[i]);
        }
        System.out.println("\nTotal sales: " + SalesComputations.getTotalSales(sales));
    }
          
    public void getInput(){
    	System.out.print("Please enter a value: " );
    	userInput = scan.nextInt();
    }

    public void getUserInput(){
    	for (int i=0; i < sales.length;  i++)
        {
    		if (SalesComputations.findWhoExceed(sales,i,userInput))
            {
            	System.out.println("Salesperson " + (i+1) + " exceeded amount with sales of $" + sales[i] );
            }
        }  	
    	System.out.println("Total Salesperson that exceeded input amount: " + SalesComputations.findExceedTotal(sales,userInput));
    	
    }
}


