package main;
import readerWriter.ReadFile;
import elevator.Elevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String [] args) throws FileNotFoundException{
		Elevator e = new Elevator();
		
		ReadFile rd = new ReadFile(e);
		rd.readInputFile();
		PrintWriter out = new PrintWriter("output.txt");
		
		
		System.out.println("final listA: " + e.getModeAList());
		System.out.println("final listB: " + e.getModeBList());
	}
}
