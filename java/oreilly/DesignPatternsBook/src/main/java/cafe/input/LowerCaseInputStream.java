package cafe.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {

        int channel = in.read();
        return (channel == -1 ? channel : Character.toLowerCase(channel));
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException{

        int result = super.read(b,off,len);
        for(int i = off; i<off+result; i++){
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
