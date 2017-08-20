package readerWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {

	public ReadFile(){
	}
	
	public void readInputFile(){  // read input.txt
		Path objPath = Paths.get("input.txt"); // locate the file
	    //List<String> lines = new LinkedList<String>(); // create a new list
		if (Files.exists(objPath)){

		     File objFile = objPath.toFile();
		     try(BufferedReader in = new BufferedReader(new FileReader(objFile))){
		        
		        String line = in.readLine(); // read a line at a time
		        
		        
		        while(line != null){ //loop till no more lines
		        	
		        	//lines.add(line); // add the line to list
		        	System.out.println(line);
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
