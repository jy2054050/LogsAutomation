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

		return listOfFiles;
	}
	
	
	// method to remove line breaks 
	
	public String LineBreakRemove(String DomainFolderLocation,String file) throws IOException{
		String filePath = file;
		String middleFilePath=DomainFolderLocation+"/"+"middleman.txt";
		System.out.println("4"+middleFilePath);
		String fileContent;
		
		fileContent=readFileAsString(filePath);
		String fileContent1=fileContent.replaceAll("\n", "");
		String fileContent2= fileContent1.replace("|#]", "|#]\n");
		FileWriter fw = null;
		File middleFile = new File(middleFilePath);
		try {
			fw = new FileWriter(middleFile,true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(!middleFile.exists()){
			try {
				middleFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("file1");
		bw.write(fileContent2);
		bw.close();
		return middleFilePath;
		
	}
	
	
	// method to read file into an string
	public String readFileAsString(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	           	sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	
	// extract line containing exception , warning , fault etc
	public void extractExceptionLines(String DomainFolderLocation,String fileName) throws IOException {
		String excptionFileLocation =DomainFolderLocation+"/exception.txt";
		File tempFile = new File(excptionFileLocation);
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
	
			String Exception = "exception";
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			bw.write("**********************************"+fileName+" start***************************\n");
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("exception")||sCurrentLine.contains("warning")|| sCurrentLine.contains("fault")||sCurrentLine.contains("Exception")||sCurrentLine.contains("Warning")|| sCurrentLine.contains("Fault")||sCurrentLine.contains("EXCEPTION")||sCurrentLine.contains("WARNING")|| sCurrentLine.contains("FAULT")){
					bw.write(sCurrentLine);
					System.out.println(sCurrentLine);
					bw.write("\n\n");
		
				}else{
				// do nothing 	
				}
			}
			
			bw.write("\n");
			bw.write("************************************"+fileName+" file done**********************************");
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
