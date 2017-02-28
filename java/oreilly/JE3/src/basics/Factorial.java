package basics;

public class Factorial {
    public static int factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("x must be >= 0");
        int fact = 1;
        for (int i = 2; i <= x; i ++) {
            fact *= i;
        }
        return fact;
    }
}
