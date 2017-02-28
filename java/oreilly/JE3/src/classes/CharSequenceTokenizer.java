package classes;

import java.io.IOException;

public class CharSequenceTokenizer extends AbstractTokenizer {

    char[] buffer;

    public CharSequenceTokenizer(CharSequence sequence) {
        buffer = sequence.toString().toCharArray();
    }

    protected void createBuffer(int bufferSize) {
        assert text == null;
        text = buffer;
        numChars = buffer.length;
    }

    protected boolean fillBuffer() { return false; }

    public static class Test {
        public static void main(String[] args) throws IOException {
            StringBuffer text = new StringBuffer();
            for (int i = 0; i < args.length; i ++) text.append(args[i]+ " ");
            CharSequenceTokenizer t = new CharSequenceTokenizer(text.toString());
            t.tokenizeWords(true).quotes("'&", "';").skipSpaces(true);
            while( t.next() != Tokenizer.EOF )
                System.out.println(t.tokenText());
        }
    }

}
