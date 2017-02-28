package basics;

public class FactComputer {
    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            System.out.println(x + "! = " + Factorial4.factorial(x));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You must specify an argument");
            System.out.println("Usage: java FactComputer <number>");
        }
        catch (NumberFormatException e) {
            System.out.println("The argument you specify must be an integer");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Bad argument: " + e.getMessage());
        }
    }
}
