package com.personal.healthCheck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileConversion {

	public void GetFileNames(String location) {
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  String temp=listOfFiles[i].getName();
		    	  System.out.println(i);
		          ReadFiles(location+"/"+temp , temp);
		       } 
		    }
	}
	public void ReadFiles(String Location, String filename){
		File tempFile = new File("C:/Users/jyadav/Desktop/Jitender_Yadav/sample/myTempFile1.txt");
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
			br = new BufferedReader(new FileReader(Location));
			bw.write("**********************************"+filename+" start***************************\n");
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.contains("|WARNING|") || sCurrentLine.contains("|SEVERE|")){
					// do nothing				
				}
				else if ((!sCurrentLine.contains("|INFO|")) && !sCurrentLine.isEmpty()){
					bw.write(sCurrentLine+"\n");
				}
			}
			bw.write("************************************"+filename+" file done**********************************\n");
			bw.newLine();
		
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
