package chapter1.examples;

public class StringSlicer {

    public static String slice(String text, int start, int end) {
        return text.substring(start, end);
    }

    public static void main(String[] args) {
        int start, end;
        String word;

        try {
            word = args[0];
            start = Integer.parseInt(args[1]);
            end   = Integer.parseInt(args[2]) + 1;
        }
        catch (Exception e) {
            word = "Hello there!";
            start = 2;
            end   = 5 + 1;
        }
        System.out.print(slice(word, start, end));


    }
}
