package readerWriter;
import elevator.Elevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
		out.printf(" %18s %-18s   | %18s \n", "", a, b);
		for(int i = 0; i <= 80; i++){
			out.print("-");
		}
		out.println();
		  
		for(int i = 0; i < ele.getModeAList().size(); i++){ //print floors for modeA
			int mASize = ((ele.getModeAList().get(i).size())*2) +3 ;
			for(int j = 0; j < ele.getModeAList().get(i).size(); j++){
				out.printf("%1s ", ele.getModeAList().get(i).get(j)); // print floors
				
			}
			int n = 0; // for slight adjustment (line6 % 7)
			if(i!=3 && i!=4) n=0;
			if(i==3) n = 1;
			if(i==4) n = 3;
			int adjust = 41-mASize-n;
			out.printf("%1s%s%-"+adjust+"s%-1s"  ,"(" ,ele.getDistanceAList().get(i),")","|" ); // print distanceA
			//out.println();
			for(int j = 0; j < ele.getModeBList().get(i).size(); j++){ //print floors for modeB
				
				out.printf("%1s ",ele.getModeBList().get(i).get(j)); // print floors
				
			}
			out.printf("%1s%s%s"  ,"(" ,ele.getDistanceBList().get(i),")" ); // print distanceB
			out.println();
		}
		
		
		
		out.close();
	}
	
}
