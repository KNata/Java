package ThreadsWithFile;

import java.util.ArrayList;

public class Data {
	
	private int state = 1;
	private ArrayList<String> fileList;
	
	Data (ArrayList<String> aFileList) {
		fileList = aFileList;
	}

    public int getState() {
    	return state; 
    }
    
    public ArrayList<String> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}

	public void deletePunctuation() {
    	for (int i = 0; i < fileList.size(); i++) {
    		if (fileList.get(i).equals(",") || fileList.get(i).equals(".") || fileList.get(i).equals("?" ) 
    				|| fileList.get(i).equals("!") || fileList.get(i).equals(":") || fileList.get(i).equals("-")) {
    			 fileList.remove(i);
    		}	
    	}
    	state = 1;
    }
    
    public void wordsToLoverCase() {
    	for (int i = 0; i < fileList.size(); i++) {
    			fileList.get(i).toLowerCase();
    	}
    	state = 2;
    	}
    
    
    public void deleteWords() {
    	for (int i = fileList.size()-1; i >= 0; i--) {
    		if (fileList.get(i).equals(fileList.get(i+1))) {
    			fileList.remove(i);
    			fileList.remove(i+1);
    		}
    	}
    	state = 3;
    }

}
