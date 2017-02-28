package uk.ac.ox.bodleian.beam.drr.wclouds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		// get some text to parse
		String str = readBook("/path/to/book/as/text.txt");

		Cloud c1 = new Cloud();

		// absorb takes the string and an integer - the n in the n-gram - ie.
		// how many words make up each token.
		c1.absorb(str, 2);

		StringBuilder out = new StringBuilder();
		out.append("<style> .c1 { color: #ccc; } .c2 { color: #aaa;} </style>");
		out.append("<hr /><h1>This book's word cloud</h1><div style=\"width:300px; text-align: center;\">"+c1.toHTMLem()+"</div>");

		System.out.println(out.toString());
	}

	public static String readBook(String fn) {
		StringBuffer sb = new StringBuffer();

		try {
			BufferedReader brin = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(
									new File(fn))));
			while (brin.ready()) {
				sb.append(brin.readLine() + "\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
