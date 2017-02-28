import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class FileIO {
	File myFile;
	
	public FileIO(String path) {
		myFile = new File(path);
	}
	
	public boolean deleteFile() {
		return myFile.delete();
	}
	
	public File getFile() {
		return myFile;
	}
	
	public void setFile(String path) {
		myFile = new File(path);
	}
	
	public void createFile() throws InvocationTargetException{
		try {
			File dirFile = myFile.getParentFile();
			if (dirFile != null) {
				dirFile.mkdirs();
			}
			myFile.createNewFile();
		}
		catch (IOException e) {
			throw new InvocationTargetException(e);
		}
	}
	
	public boolean printToFile(String text, boolean append, boolean autoFlush)
		throws InvocationTargetException {
		FileWriter fWriter;
		PrintWriter pWriter;
		boolean successFlag = true;
		try {
			fWriter = new FileWriter(myFile, append);
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
		pWriter = new PrintWriter(fWriter, autoFlush);
		
		pWriter.println(text);
		if (pWriter.checkError()) {
			successFlag = false;
		}
		
		pWriter.close();
		return successFlag;
	}
	
	public String readFile() throws InvocationTargetException {
		FileReader fReader;
		BufferedReader bReader;
		String txtLine = "";
		String returnText = "";
		try {
			fReader = new FileReader(myFile);
			bReader = new BufferedReader(fReader);
			while ((txtLine = bReader.readLine()) != null) {
				returnText += txtLine + "\n";
		}
			return returnText;
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
	}
	
	public static void main(String [] args) {
		final int NORMAL_EXIT = 0;
		final int FILE_CREATION_ERROR = 1;
		final int FILE_ERROR = 2;
		final int FILE_WRITE_ERROR = 3;
		
		String path = "filetest.txt";
		int exitCode = NORMAL_EXIT;
		FileIO fileTest = new FileIO(path);
		boolean append = true;
		boolean autoFlush = true;
		
		try {
			fileTest.createFile();
			for (int i = 1; i <= 10; i++) {
				if (!fileTest.printToFile("Line: " + i, append, autoFlush)) {
					System.out.println("An error occurred writing to file: " 
							+ fileTest.getFile().getPath());
					exitCode = FILE_WRITE_ERROR;
					break;
				}
			}	System.out.println(fileTest.readFile());
		} catch (InvocationTargetException e) {
			e.getCause().printStackTrace();
			exitCode = FILE_CREATION_ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			exitCode = FILE_ERROR;
		}
		finally {
			System.exit(exitCode);
		} 
	}
}
