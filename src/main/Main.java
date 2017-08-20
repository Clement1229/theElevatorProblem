package main;
import readerWriter.ReadFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String [] args){
		
		ReadFile rd = new ReadFile();
		rd.readInputFile();
	}
}
