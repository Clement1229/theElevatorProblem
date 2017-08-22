package main;
import readerWriter.ReadFile;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String [] args) throws FileNotFoundException{
		
		ReadFile rd = new ReadFile();
		rd.readInputFile();
		PrintWriter out = new PrintWriter("output.txt");
	}
}
