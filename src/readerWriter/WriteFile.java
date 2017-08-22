package readerWriter;
import elevator.Elevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteFile {
	Elevator ele;
	String a = "Mode A";
	String b = "Mode B";
    
	public WriteFile(Elevator e){
		ele = e;
	}
	//(String.format("%-20s= %s" , "label", "content" ))
	public void writeOutputFile() throws FileNotFoundException{
	
		PrintWriter out = new PrintWriter("output.txt");
		out.printf(" %18s %-18s  | %18s \n", "", a, b);
		for(int i = 0; i <= 80; i++){
			out.print("-");
		}
		out.println();
		
		for(int i = 0; i < ele.getModeAList().size(); i++){
			for(int j = 0; j < ele.getModeAList().get(i).size(); j++){
				out.printf("%1s ", ele.getModeAList().get(i).get(j)); // print floors
				
			}
			out.printf("%1s%s%s"  ,"(" ,ele.getDistanceAList().get(i),")" ); // print distance
			out.println();
		}
		
		
		
		out.close();
	}
	
}
