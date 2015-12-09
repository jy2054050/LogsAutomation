package com.personal.healthCheck;

import java.io.File;

public class HealthCheckMainClass {

	public static void main(String[] args) {
		
		//project on git 
	
/*		URLChecking ur = new URLChecking();
		String print =ur.CheckingURLs();
		System.out.println(print);
				*/
		String location ="C:/Users/jyadav/Desktop/Test/sample";
		LogFileConversion lfc = new LogFileConversion();
		
		File[] listofFiles = lfc.GetFileNames(location);  // get the names of all the files in the sample folder
		//System.out.println(listofFiles);
		
		/*System.out.println(lfc.ConsolidateFiles(listofFiles));*/
		//consolidate it all into one file

		for (int i =0;i<listofFiles.length ; i++){
		lfc.FileReaderBloclWise(listofFiles[i].toString());
		}
		System.out.println("Done Here");
	}
	
}