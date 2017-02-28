/**
 * 
 */
package at.markusegger.Learning.FileIO;

import java.io.*;
import java.util.*;

/**
 * Learning Java I/O
 * 
 * @author MarkusME
 * @version 0.2
 */
public class Program
{
	final static private int HASH = 42;
	
	final static private String file1 =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\File1.txt";
	
	final static private String file2 =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\File2.txt";
	
	final static private String file3 =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\File3.txt";
	
	final static private String javaFileOrig =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\Java_orig.png";
	
	final static private String javaFileEncoded =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\Java_enc.png";
	
	final static private String javaFileDecoded =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\Java_dec.png";
	
	/**
	 * File I/O Tests
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		readTextFile();
		
		System.out.println();
		
		writeTextFile();
		
		System.out.println();
		
		byteDemo();
		
		System.out.println();
		
		readTextFileBuffered();
		
		System.out.println();
		
		writeTextFileBuffered();
		
		System.out.println();
		
		readWriteBinaryBuffered(javaFileOrig, javaFileEncoded, HASH);
		
		System.out.println();
		
		readWriteBinaryBuffered(javaFileEncoded, javaFileDecoded, -HASH);
		
		System.out.println();
		
		// TODO: Binary - PrintOutputStream
	}

	/**
	 * Reading Text File Demo
	 */
	private static void readTextFile()
	{
		System.out.println("Reading text file ...");
		
		File file = null;
		Scanner scanner = null;
		
		try
		{
			file = new File(file1);
		
			System.out.println(String.format("Exists? %b", file.exists()));
					
			scanner = new Scanner(file);
			
			System.out.println("<file>");
			
			while (scanner.hasNextLine())
			{
				System.out.println(scanner.nextLine());
			}
			
			System.out.println("</file>");
			
		}
		catch (NullPointerException npex)
		{
			npex.printStackTrace();
		}
		catch (FileNotFoundException fnfex)
		{
			fnfex.printStackTrace();
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
				scanner = null;
			}
			
			file = null;
		}
		
		System.out.println("Done!");
	}
	
	/**
	 * Write Text File Demo
	 */
	private static void writeTextFile()
	{
		System.out.println("Writing text file ...");
		
		File file = null;
		FileWriter fileWriter = null;
		
		Random rand = new Random();
		
		try
		{
			file = new File(file2);
			
			fileWriter = new FileWriter(file, false);
			
			for (int i = 0; i < 10; ++i)
			{
				// I knew there was a more idiomatic way than String.format ...
				// However, since there is no FileWriter.writeLine() it's less advantageous ...
				// And the line separator stuff makes it just much more ugly ...
				//     (http://stackoverflow.com/questions/207947/how-do-i-get-a-platform-dependent-new-line-character)
				String str = Integer.toString(rand.nextInt()) + System.lineSeparator();
				
				fileWriter.write(str);
				
			}
		}
		catch (NullPointerException npex)
		{
			npex.printStackTrace();
		}
		catch (IOException ioex)
		{
			// TODO Auto-generated catch block
			ioex.printStackTrace();
		}
		finally
		{
			closeHelper(fileWriter);
						
			file = null;
		}
		
		System.out.println("Done!");
	}
	
	/**
	 * Demo of numeric roll-over in case of a byte.
	 */
	private static void byteDemo()
	{
		byte by = 0;
		
		System.out.println("<byte>");
		
		for (int i = 0; i < 520; ++i)
		{
			System.out.println(by++);
		}
		
		System.out.println("</byte>");
	}

	/*
	 * Reading a Text File in a Buffered Fashion
	 */
	private static void readTextFileBuffered()
	{
		// TODO Auto-generated method stub
		System.out.println("Reading text file (buffered) ...");
		
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try
		{
			file = new File(file1);
			
			fileReader = new FileReader(file);
			
			bufferedReader = new BufferedReader(fileReader);
			
			System.out.println("<bufferedFile>");
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null)
			{
				System.out.println(line);
			}
			
			System.out.println("</bufferedFile>");
		}
		catch (NullPointerException npex)
		{
			npex.printStackTrace();
		}
		catch (FileNotFoundException fnfex)
		{
			fnfex.printStackTrace();
		} catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
		finally
		{
			closeHelper(bufferedReader);
			closeHelper(fileReader);
						
			file = null;
		}
		
		System.out.println("Done!");
	}
	
	/**
	 * Write Text File Buffered Demo
	 * @throws IOException 
	 */
	private static void writeTextFileBuffered()
	{
		System.out.println("Writing text file (buffered) ...");
		
		File file = null;
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		Random rand = new Random();
		
		try
		{
			file = new File(file3);
			
			fileWriter = new FileWriter(file);
			
			bufferedWriter = new BufferedWriter(fileWriter);
			
			for (int i = 0; i < 10; ++i)
			{
				String line = String.format("%d: %d", i, rand.nextInt());
				
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		}
		catch (NullPointerException | IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeHelper(bufferedWriter);
			closeHelper(fileWriter);
			
			file = null;
		}
		
		System.out.println("Done!");
	}

	private static void readWriteBinaryBuffered(String sourcePath, String targetPath, int key)
	{
		System.out.println("Reading and encoding/decoding binary file (buffered) ...");
		
		File inputFile = null;
		File outputFile = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try
		{
			inputFile = new File(sourcePath);
			outputFile = new File(targetPath);
			
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int byteAsInt;
			
			while ((byteAsInt = bis.read()) != -1)
			{
				bos.write(byteAsInt + key);
			}
			
			bos.flush();
		}
		catch (NullPointerException | IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeHelper(bos);
			closeHelper(bis);
			
			closeHelper(fos);
			closeHelper(fis);
			
			outputFile = null;
			inputFile = null;
		}
		
		System.out.println("Done!");
	}
	
	/**
	 * Closes any I/O object like {@link FileInputStream}, {@link BufferedInputStream},
	 * {@link BufferedOutputStream}, ... that implements {@link Closeable}.
	 * 
	 * @param closeable		An object that has the {@link Closeable} interface implemented
	 */
	static private void closeHelper(Closeable closeable)
	{
		try
		{
			if (closeable != null)
			{
				closeable.close();
			}
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
		finally
		{
			closeable = null;
		}
	}
}
