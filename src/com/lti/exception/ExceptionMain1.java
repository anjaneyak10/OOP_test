package com.lti.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ExceptionMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile("apap.txt");
		
		
	}
	
	public static void readFile(String fName)  {
		
		FileReader fread=null;
		char[] ch = new char[100];
			try {
				fread = new FileReader(fName);
				fread.read(ch);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println(ch);
	}

}
