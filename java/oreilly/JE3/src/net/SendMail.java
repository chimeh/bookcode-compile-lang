package net;

import java.io.*;
import java.net.*;

public class SendMail {

    public static void main(String[] args) {
        try {
            if (args.length >= 1)
                System.getProperties().put("mail.host", args[0]);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("From: ");
            String from = in.readLine();
            System.out.print("To: ");
            String to = in.readLine();
            System.out.print("Subject: ");
            String subject = in.readLine();

            URL u = new URL("mailto:" + to);
            URLConnection c = u.openConnection();
            c.setDoInput(false);
            c.setDoOutput(true);
            System.out.println("Connecting...");
            System.out.flush();
            c.connect();
            PrintWriter out =
                    new PrintWriter(new OutputStreamWriter(c.getOutputStream()));

            out.print("From: \"" + from + "\" <" +
                System.getProperties("user.name") + "@" +
                InetAddress.getLocalHost().getHostName() + ">\r\n");
            out.print("To: " + to + "\r\n");
            out.print("Subject: " + subject + "\r\n");
            out.print("\r\n");

            System.out.println("Enter the message. " +
                "End with a '.' on a line by itself");

            String line;
            for(;;) {
                line = in.readLine();
                if ((line == null) || line.equals(".")) break;
                out.print(line + "\r\n");
            }

            out.close();

            System.out.println("Message sent.");

        }
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java SendMail [<mailhost>]");
        }
    }

}
