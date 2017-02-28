package cafe.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class tmp {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Write number: ");
        int number = in.nextInt();
        in.nextLine();
        System.out.println("Write text 1: ");
        String text1 = in.nextLine();
        System.out.println("Write text 2: ");
        String text2 = in.nextLine();
        System.out.println(number);
        String result;
        result = number == 20 ? text1 : text2;
        System.out.println(result);
    }
}
