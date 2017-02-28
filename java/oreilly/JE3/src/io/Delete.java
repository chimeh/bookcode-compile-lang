package io;

import java.io.*;

public class Delete {

    public static void  main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: Java Delete <file or directory>");
            System.exit(0);
        }
        try { delete(args[0]); }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void delete(String filename) {
        File f = new File(filename);
        if (!f.exists()) fail("Delete: no such file or directory: " + filename);
        if (!f.canWrite()) fail("Delete: write protected: " + filename);

        if (f.isDirectory()) {
            String[] files = f.list();
            if (files.length > 0) fail("Delete: directory not empty: " + filename);
        }
        boolean success = f.delete();
        if (!success) fail("Delete: deletion failed");
    }

    protected static void fail(String msg) throws IllegalArgumentException {
        throw new IllegalArgumentException(msg);
    }

}
