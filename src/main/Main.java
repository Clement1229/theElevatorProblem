package main;
import readerWriter.ReadFile;
import readerWriter.WriteFile;
import elevator.Elevator;

import java.io.FileNotFoundException;


public class Main {

	public static void main(String [] args) throws FileNotFoundException{
		
		Elevator e = new Elevator();
		ReadFile rf = new ReadFile(e);
		rf.readInputFile();
		WriteFile wf = new WriteFile(e);
		wf.writeOutputFile();
		
		
		
		System.out.println("final listA: " + e.getModeAList());
		System.out.println("methodA distance: " + e.getDistanceAList());
		System.out.println("final listB: " + e.getModeBList());
		System.out.println("methodB distance: " + e.getDistanceBList());
		System.out.println();
		System.out.println("**********For Test Input, Please See \"input.txt\"");
		System.out.println("**********For Expected Output, Please See \"output.txt\"");
	}
}
