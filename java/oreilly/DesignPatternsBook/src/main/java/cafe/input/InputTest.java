package cafe.input;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

    public static void main(String[] args) {

        int channel;

        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(
                    new FileInputStream("C:\\Users\\media\\Desktop\\Workspace\\" +
                            "BookDesignPatterns\\src\\main\\java\\cafe\\input\\test.txt")));
            while ((channel = in.read()) >= 0){
                System.out.print((char)channel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
