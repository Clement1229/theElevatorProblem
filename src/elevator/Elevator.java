package elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	  
	    
	public void modeA(String startingFloor, String floorList){ 
		
		int distance = 0; // elevator total travel distance
		List<Integer> ls = new ArrayList<Integer>();  // store the output
		String[] split = floorList.split("-|,"); // 1-5,1-6 => 1 5 1 6
		int[] numbers = new int[split.length+1]; // add startingPos at numbers[0]
		int mod; // modifier = -1: when nextFloor - currentFloor < 0 
		
		/*
		for(int i = 0; i < split.length ; i++){
			Integer floor = Integer.valueOf(split[i]);  // String to Integer
			if(i != 0){  // 10 8 1
				
			}
			System.out.println(floor);
		}*/
		
		numbers[0] = Integer.parseInt(startingFloor);
		ls.add(numbers[0]);
		for(int i = 1; i < split.length+1 ; i++){
		   numbers[i] = Integer.parseInt(split[i-1]);  // convert String[] to Integer[]
		   ls.add(numbers[i]);
		   
		   if(i != 0){// calculate distance, start from index of 1
			   if(numbers[i] - numbers[i-1] >= 0){
				   mod = 1;
			   }
			   else{
				   mod = -1;
			   }
			   distance += (numbers[i] - numbers[i-1])*mod;
			  
		   }
		}
		
		System.out.println("distance:" + distance);
		
		
	}
	
	public void modeB(){
		
	}
}
