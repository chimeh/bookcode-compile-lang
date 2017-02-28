package io;

import java.io.*;

public class WordList {

    public static void main(String[] args) throws IOException {
        writeWords("words.data", args);

        WordList list = new WordList("words.data");

        for(int i = list.size() -1; i >= 0; i --) {
            System.out.println(list.get(i));
        }

        list.close();
    }

    public static void writeWords(String filename, String[] words) throws IOException {
        RandomAccessFile f = new RandomAccessFile(filename, "rw");

        long wordPositions[] = new long[words.length];
        f.seek(4L + (8 * words.length));

        for(int i = 0; i < words.length; i ++) {
            wordPositions[i] = f.getFilePointer();
            f.writeUTF(words[i]);
        }
        f.seek(0L);
        f.writeInt(wordPositions.length);
        for(int i = 0; i < wordPositions.length; i ++) {
            f.writeLong(wordPositions[i]);
        }

        f.close();
    }

    RandomAccessFile f;
    long[] positions;

    public WordList(String filename) throws IOException {
        f = new RandomAccessFile(filename, "r");

        int numwords = f.readInt();
        positions = new long[numwords];
        for( int i = 0; i < numwords; i ++) {
            positions[i] = f.readLong();
        }
    }

    public void close() throws IOException {
        if (f != null) f.close();
        f = null;
        positions = null;
    }

    public int size() {
        if (f == null) throw new IllegalStateException("already closed");
        return positions.length;
    }

    public String get(int i) throws IOException {
        if (f == null) throw new IllegalStateException("already closed");
        f.seek(positions[i]);
        return f.readUTF();
    }

}
