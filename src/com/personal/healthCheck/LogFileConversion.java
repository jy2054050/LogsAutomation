package com.personal.healthCheck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileConversion {
	

	public File[] GetFileNames(String location) {
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  String temp=listOfFiles[i].getName();
		    	 
		       } 
		    }
			return listOfFiles;
	}
	
	
	// Method to read the file block wise and write the exception block in to new file called exception.txt
	
	public void FileReaderBloclWise(String filename){

		File tempFile = new File("C:/Users/jyadav/Desktop/Test/sample/exception.txt");
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(tempFile,true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(!tempFile.exists()){
			try {
				tempFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	}
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {
	
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filename));
			bw.write("**********************************"+filename+" start***************************\n");
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith("[#|") && sCurrentLine.endsWith("|#]") && (sCurrentLine.contains("exception") ||sCurrentLine.contains("error")||sCurrentLine.contains("fault"))){
		
					bw.write(sCurrentLine);
					bw.write("\n");
				}else if (sCurrentLine.startsWith("[#|") && sCurrentLine.endsWith("|#]") && !(sCurrentLine.contains("exception") ||sCurrentLine.contains("error")||sCurrentLine.contains("fault"))){
				// do nothing 	
				}
				if (! sCurrentLine.endsWith("|#]")){
					bw.write(sCurrentLine);
					
										
				}
				if (sCurrentLine.endsWith("|#]") && !sCurrentLine.startsWith("[#|")){
					bw.write("|#]");
					
				}
				
				
			}
			
			bw.write("\n");
			bw.write("************************************"+filename+" file done**********************************");
			bw.write("\n");
			bw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
				if(bw !=null)bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
