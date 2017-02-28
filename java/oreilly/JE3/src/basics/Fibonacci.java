package basics;

public class Fibonacci {
    public static void main(String[] args) {
        int n0 = 1, n1 = 1, n2;
        System.out.print(n0 + " " + n1 + " ");

        for (int i = 0; i < 18; i++) {
            n2 = n1 + n0;
            System.out.print(n2 + " ");
            n0 = n1;
            n1 = n2;
        }
        System.out.println();
    }
}
