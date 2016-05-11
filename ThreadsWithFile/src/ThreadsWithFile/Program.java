package ThreadsWithFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// read data from file 
		
		File theFile = new File("FileForEdit.txt");
		ArrayList<String> fileList = new ArrayList<String>();
		FileReader fileReader = new FileReader(theFile);
		BufferedReader br = new BufferedReader(fileReader);
		String scan = br.readLine();
		while (scan != null) {
			String[] wordStrings = scan.split(" ");
    	    	for (int i = 0; i < wordStrings.length; i++) {
    	    		
    	    		fileList.add(wordStrings[i]);
    	    	}
    	    	scan = br.readLine();
			}
		
		// create and join threads
		
		Data theData = new Data(fileList);
		Worker firstWorker = new Worker(1, theData);
		Worker secondWorker = new Worker(2, theData);
		Worker thirldWorker = new Worker(3, theData);
	
		secondWorker.join();
		thirldWorker.join();
		
	}
}
