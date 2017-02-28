package chapter1.examples;

public class Counter {

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i ++) {
            System.out.print(i + " ");
        }
        for (int i = 15; i >= 0; i -= 2) {
            System.out.print(i + " ");
        }
    }
}
