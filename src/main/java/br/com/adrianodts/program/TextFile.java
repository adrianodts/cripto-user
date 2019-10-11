package br.com.adrianodts.program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TextFile {
	
	public static String saveFile(String fileName, String extension, String data) throws IOException {
	    File tmpFile = File.createTempFile(fileName, extension);
	    FileWriter writer = new FileWriter(tmpFile);
	    writer.write(data);
	    writer.close();	
	    return tmpFile.getPath();
	}
	
	public static Map<String,String> getData(String fileName) throws IOException {
		Map<String,String> users = new HashMap<String,String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				String[] data = line.split(" ");
				users.put(data[0], data[1]);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}				
	    return users;
	}
		
}
