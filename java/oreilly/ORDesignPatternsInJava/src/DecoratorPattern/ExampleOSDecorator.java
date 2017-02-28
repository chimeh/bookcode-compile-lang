package DecoratorPattern;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipOutputStream;

public class ExampleOSDecorator {
    public static void main(String[] args){
        try {
//            OutputStream os = new FileOutputStream("test.txt");
            OutputStream os = new FileOutputStream("test.zip");
            os = new ZipOutputStream(os);

            writeSomeContentToAnOutputStream(os);
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void writeSomeContentToAnOutputStream(OutputStream os) throws IOException{
        String someContent = "ABCDEFG";
        os = new BufferedOutputStream(os);
        os.write(someContent.getBytes(Charset.forName("UTF-8")));
    }
}
