package net;

import java.net.*;
import java.io.*;
import java.util.Date;

public class GetURLInfo {

    public static void printinfo(URL url) throws IOException {
        URLConnection c = url.openConnection();
        c.connect();

        System.out.println(" Content Type: " + c.getContentType());
        System.out.println(" Content Encoding: " + c.getContentEncoding());
        System.out.println(" Content Length: " + c.getContentLength());
        System.out.println(" Date: " + new Date(c.getDate()));
        System.out.println(" Last Modified: " + new Date(c.getLastModified()));
        System.out.println(" Expiration: " + new Date(c.getExpiration()));

        if (c instanceof HttpURLConnection) {
            HttpURLConnection h = (HttpURLConnection) c;
            System.out.println(" Request Method: " + h.getRequestMethod());
            System.out.println(" Response Message: " + h.getResponseMessage());
            System.out.println(" Response Code: " + h.getResponseCode());
        }
    }

    public static void main(String[] args) {
        try { printinfo(new URL(args[0])); }
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java GetURLInfo <url>");
        }
    }

}
