package chapter1.examples;

public class Tribonacci {

    public static void main(String[] args) {

        int n0 = 1, n1 = 1, n2 = 2, n3;
        System.out.print(n0 + " " + n1 + " " + n2 + " ");

        for (int i = 0; i < 17; i ++) {
            n3 = n0 + n1 + n2;
            System.out.print(n3 + " ");
            n0 = n1;
            n1 = n2;
            n2 = n3;
        }

        System.out.println();
    }
}
