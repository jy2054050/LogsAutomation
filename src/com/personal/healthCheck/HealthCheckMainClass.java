package com.personal.healthCheck;

import java.io.File;
import java.io.IOException;

public class HealthCheckMainClass {

	public static void main(String[] args) throws IOException {
		
		//project on git 
		String folderRoot="C:/Users/jyadav/Documents/ESB_Log_Analysis";
		String domains[] = {"D1","D2","D3","D4","D5"};
		
		LogFileConversion lfc = new LogFileConversion();
		String middleFileTempPath = null;
		
		for(int j=0;j<domains.length;j++){
			String DomainFolderLocation= folderRoot+"/"+domains[j];
			
			System.out.println("1"+DomainFolderLocation);
			File[] listofFiles = lfc.GetFileNames(DomainFolderLocation); 
			
			for(int k=0;k<listofFiles.length;k++){
				System.out.println("2"+listofFiles[k]);
								
				middleFileTempPath=	lfc.LineBreakRemove(DomainFolderLocation,listofFiles[k].toString());
			}
			lfc.extractExceptionLines(DomainFolderLocation,middleFileTempPath);
			
		}		
		
		/*		URLChecking ur = new URLChecking();
		String print =ur.CheckingURLs();
		System.out.println(print);
				*/
		

	}
	
}