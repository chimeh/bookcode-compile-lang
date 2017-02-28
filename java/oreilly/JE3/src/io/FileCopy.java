package io;

import java.io.*;

public class FileCopy {

    public static void main(String[] args) {
        if (args.length != 2) System.err.println("Usage: java FileCopy <source> <destination>");
        else {
            try { copy(args[0], args[1]); }
            catch (IOException e) { System.err.println(e.getMessage()); }
        }
    }

    public static void copy(String from_name, String to_name) throws IOException {
        File from_file = new File(from_name);
        File to_file = new File(to_name);

        if (!from_file.exists()) abort("no such source file: " + from_name);
        if (!from_file.isFile()) abort("can't copy directory" + from_name);
        if (!from_file.canRead()) abort("source file is unreadable: " + from_name);

        if (to_file.isDirectory()) to_file = new File(to_file, from_file.getName());
        if (to_file.exists()) {
            if (!to_file.canWrite()) abort("destination file is unwritable: " + to_name);
            System.out.print("Overwrite existing file" + to_file.getName() + "? (Y/N): ");
            System.out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String response = in.readLine();
            if (!response.equals("Y") && !response.equals("y"))
                abort("existing file was not overwritten.");
        }
        else {
            String parent = to_file.getParent();
            if (parent == null) parent = System.getProperty("user.dir");
            File dir = new File(parent);
            if (!dir.exists()) abort("destination directory doesn't exist: " + parent);
            if (dir.isFile()) abort("destination is not a directory: " + parent);
            if (!dir.canWrite()) abort("destination directory is unwriteable: " + parent);
        }

        FileInputStream from = null;
        FileOutputStream to = null;
        try {
            from = new FileInputStream(from_file);
            to = new FileOutputStream(to_file);
            byte[] buffer = new byte[4096];
            int bytes_read;
            while ((bytes_read = from.read(buffer)) != -1)
                to.write(buffer, 0, bytes_read);
        }
        finally {
            if (from != null) try { from.close(); } catch (IOException e) { ; }
            if (to != null) try { to.close(); } catch (IOException e) { ; }
        }
    }

    protected static void abort(String msg) throws IOException {
       throw new IOException(msg);
    }

}
