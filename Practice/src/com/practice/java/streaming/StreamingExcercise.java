package com.practice.java.streaming;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamingExcercise {
	
	public static void main(String[] args) throws Exception{
		copyBits();
	}
	
	public static void copyBits() throws IOException{ 
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("/Users/desingh/Desktop/sample-input");
			out = new FileWriter("/Users/desingh/Desktop/sample-output");
			
			int c;
			
			while((c = in.read()) != -1){
				out.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			in.close();
			out.close();
		}
		
	}

}
