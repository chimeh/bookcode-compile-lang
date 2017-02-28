package io;

import java.io.*;

public class RemoveHTMLReader extends FilterReader {

    public RemoveHTMLReader(Reader in) { super(in); }

    boolean intag = false;

    public int read(char[] buf, int from, int len) throws IOException {
        int numchars = 0;
        while (numchars == 0) {
            numchars = in.read(buf, from, len);
            if (numchars == -1) return -1;

            int last = from;
            for(int i = from; i < from + numchars; i ++) {
                if (!intag) {
                    if (buf[i] == '<') intag = true;
                    else buf[last++] = buf[i];
                }
                else if (buf[i] == '>') intag = false;
            }
            numchars = last - from;
        }
        return numchars;
    }

    public int read() throws IOException {
        char[] buf = new char[1];
        int result = read(buf, 0, 1);
        if (result == -1) return -1;
        else return (int) buf[0];
    }

    public static class Test {
        public static void main(String[] args) {
            try {
                if (args.length != 1)
                    throw new IllegalArgumentException("Wrong number of args");
                BufferedReader in = new BufferedReader(
                        new RemoveHTMLReader(new FileReader(args[0]))
                );
                String line;
                while((line = in.readLine()) != null)
                    System.out.println(line);
                in.close();
            }
            catch(Exception e) {
                System.err.println(e);
                System.err.println("Usage: java RemoveHTMLReader$Test <filename>");
            }
        }
    }
}
