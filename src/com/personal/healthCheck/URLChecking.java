package com.personal.healthCheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLChecking {
	
	private  int CheckURLWorking(String uRL) throws IOException  {
		final URL url = new URL(uRL);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setRequestMethod("GET");
		int responseCode = 0000;
		try{
		responseCode = huc.getResponseCode();
		}catch(Exception e){
			responseCode = 0000;
		}
		return responseCode;
	}
	
		
	public String CheckingURLs(){
		BufferedReader br = null;
		String result="";
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:/Users/jyadav/workspace_personal/LogsAutomation/URL.properties"));
			
			while ((sCurrentLine = br.readLine()) != null) {
				String temp = sCurrentLine;
				int code =	CheckURLWorking(temp);
				if(code==200){ result+= temp+ "- GOOD \n";}
				else {result+= temp+ "- BAD \n";}
			}
		}catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)br.close();
			} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		return result;
		
	}
}
