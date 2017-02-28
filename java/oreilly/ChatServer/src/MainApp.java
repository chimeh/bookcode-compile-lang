import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MainApp {
	ArrayList OutputStreams;
	
	public class ClientManager implements Runnable {
		BufferedReader reader;
		Socket socket;
		
		public ClientManager(Socket clientSocket) {
			try {
				socket = clientSocket;
				InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(isReader);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public synchronized void run() {
			String message;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("Read message: "+message);
					sendOut(message);
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new MainApp().start();
	}
	
	public void start() {
		OutputStreams = new ArrayList();
		try {
			ServerSocket serverSocket = new ServerSocket(4000);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				OutputStreams.add(writer);
				
				Thread thread1 = new Thread(new ClientManager(clientSocket));
				thread1.start();
				System.out.println("Connected!");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public synchronized void sendOut(String message) {
		Iterator it = OutputStreams.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
