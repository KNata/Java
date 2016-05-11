package SimpleClientServer;

import java.net.*; 
import java.nio.CharBuffer;
import java.util.Scanner;
import java.io.*; 

public class Client extends Thread {
	
	public void run() { 
		
	int filesize = 1022386; 
	int bytesRead; 
	int currentTot = 0; 
	try {
	Socket socket = new Socket("127.0.0.1", 15126); 
    File theFile = new File("FileForServer.txt");
    Scanner response = new Scanner(socket.getInputStream());
    PrintWriter request = new PrintWriter(socket.getOutputStream());
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String passwordLine = "";
    	 System.out.print("Enter password:");
         passwordLine = in.readLine();

         request.println(passwordLine);
         request.flush();
         System.out.println("Hey");
         

	// receive file
		byte [] bytearray = new byte [filesize]; 
		InputStream is = socket.getInputStream(); 
		FileOutputStream fos = new FileOutputStream("copyFile.txt"); 
		BufferedOutputStream bos = new BufferedOutputStream(fos); 
		bytesRead = is.read(bytearray, 0, bytearray.length); 
		currentTot = bytesRead; 
		do { 
			bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot)); 
			if(bytesRead >= 0) currentTot += bytesRead; 
		} 
		while(bytesRead > -1); 
		bos.write(bytearray, 0 , currentTot); 
		bos.flush(); 
		bos.close(); 
		socket.close();
	} catch(IOException e) {
		e.printStackTrace();
		}
	}

	
	
	public static void main(String[] args) {
		Client theClient = new Client();
		theClient.start();
	}
} 

