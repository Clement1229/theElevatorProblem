package readerWriter;
import elevator.Elevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadFile {
	
	Elevator ele = new Elevator();
	
	public ReadFile(Elevator e){
		ele = e;
	}
	
	public void readInputFile(){  // read input.txt
		
		Path objPath = Paths.get("input.txt"); // locate the file
		
		if (Files.exists(objPath)){

		     File objFile = objPath.toFile();
		     
		     try(BufferedReader in = new BufferedReader(new FileReader(objFile))){
		        
		        String line = in.readLine(); // read a line at a time
		        
		        while(line != null){ //loop till no more lines
		        	
		        	ele.modeA(line);
		        	ele.modeB(line);
		        	line = in.readLine(); // try to read another line
		        	
		        }
		    	 
		    	
		
		        }
		         catch(IOException e){
		
		             System.out.println(e);
		         }
		     	 finally{
		     		 //System.out.println(lines);
		     	 }
		
		}
		
	    else
	    {
	      System.out.println(
	              objPath.toAbsolutePath() + " doesn't exist");
	    }
	}
}
