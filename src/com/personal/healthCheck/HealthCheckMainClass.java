package com.personal.healthCheck;

import com.personal.healthCheck.URLChecking;

public class HealthCheckMainClass {

	public static void main(String[] args) {
	
		URLChecking ur = new URLChecking();
		String print =ur.CheckingURLs();
		System.out.println(print);
				
	/*	String location ="C:/Users/jyadav/Desktop/Jitender_Yadav/sample";
		LogFileConversion lfc = new LogFileConversion();
		lfc.GetFileNames(location);*/
					
	}
	
}
