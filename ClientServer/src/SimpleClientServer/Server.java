package SimpleClientServer;

import java.net.*; 
import java.util.Scanner;
import java.io.*; 

public class Server extends Thread { 
	
	public void run () { 
		try {
		System.out.println("Server is running..."); 

		ServerSocket serverSocket = new ServerSocket(15126); 
		Socket socket = serverSocket.accept();
		
		System.out.println("Accepted connection : " + socket); 
		
		File transferFile = new File ("file.txt"); 
		 Scanner in = new Scanner(socket.getInputStream());
         PrintWriter out = new PrintWriter(socket.getOutputStream());
         String request = "";
         while (in.hasNext()) {
	          request = in.next();
	          if (request.toUpperCase().equals("1234")) {  
					byte [] bytearray = new byte [(int)transferFile.length()]; 
					FileInputStream fin = new FileInputStream(transferFile); 
					BufferedInputStream bin = new BufferedInputStream(fin); 
					bin.read(bytearray, 0, bytearray.length); 
					OutputStream os = socket.getOutputStream(); 
					System.out.println("Sending Files..."); 
					os.write(bytearray, 0, bytearray.length); 
					os.flush(); socket.close(); 
					System.out.println("File transfer complete");
	          }
         } 
	} catch(IOException e) {
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		Server theServer = new Server();
		theServer.start();
	}
}

