package main;
import readerWriter.ReadFile;
import readerWriter.WriteFile;
import elevator.Elevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String [] args) throws FileNotFoundException{
		Elevator e = new Elevator();
		
		ReadFile rf = new ReadFile(e);
		rf.readInputFile();
		System.out.println("distanceA: " + e.getDistanceAList());
		System.out.println("distanceB: " + e.getDistanceBList());
		//PrintWriter out = new PrintWriter("output.txt");
		WriteFile wf = new WriteFile(e);
		wf.writeOutputFile();
		
		
		
		System.out.println("final listA: " + e.getModeAList());
		System.out.println("final listB: " + e.getModeBList());
	}
}
