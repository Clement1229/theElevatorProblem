package elevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Elevator {
	// store all the expected output of modeA 
	private ArrayList<ArrayList<Integer>> modeAList= new ArrayList<ArrayList<Integer>>();
	// store all the expected output of modeB
	private ArrayList<ArrayList<Integer>> modeBList= new ArrayList<ArrayList<Integer>>();
	
	boolean up; // default: if requested floor - initial floor > 0
	
	 
	public void modeA(String line){ 
		
		int distance = 0; // elevator total travel distance
		ArrayList<Integer> ls = new ArrayList<Integer>();  // store the output
		String[] split = line.split("-|,|:"); // 1-5,1-6 => 1 5 1 6
		int[] numbers = new int[split.length];
		
		int mod; // modifier = -1: when nextFloor - currentFloor < 0 
                 //            1 : when nextFloor - currentFloor > 0		
		
		for(int i = 0; i < split.length ; i++){
			//Integer floor = Integer.valueOf(split[i]);  // String to Integer
			numbers[i] = Integer.valueOf(split[i]);
			ls.add(numbers[i]);
			if(i != 0){  // calculate distance
				if(numbers[i] - numbers[i-1] >= 0){
					   mod = 1;
				   }
				   else{
					   mod = -1;
				   }
				
				distance += (numbers[i] - numbers[i-1])*mod;
			}
			
		}
//		System.out.print(ls);
//		System.out.println(" distance:" + distance);
		ls.add(0,distance); // add distance at the index0
//		System.out.println(ls);
		modeAList.add(ls);
		//System.out.println("list of list :" + modeAList);
	
		
		
	}
	
	public void modeB(String line){ // EX: input  7:11-6,10-5,6-8,7-4,12-7,8-9
		
		int distance = 0; // elevator total travel distance
		ArrayList<Integer> ls = new ArrayList<Integer>();  // store the output
		String startPos = line.substring(0,line.indexOf(":")); // 7, separate startPos with the rest
		String floorRequest = line.substring(line.indexOf(":")+1); // the rest
		String[] split = floorRequest.split("-|,|:"); // 11 6 10 5 6 8 7 4 12 7 8 9
		int[] numbers = new int[split.length];
		//System.out.println(startPos);
		HashSet<Integer> hs = new HashSet<Integer>();
		
		
		
		for(int i = 0; i < split.length ; i++){ // String[] to Integer[]
			
			numbers[i] = Integer.valueOf(split[i]);
			System.out.print(numbers[i]+ " ");
		}
		
		
		//boolean up; // default: if requested floor - initial floor > 0
		setInitialDirection(numbers);
		//System.out.println("Elevator inital direction: " + up);
		
		int i = 1;
		
		// 11 6 10 5 6 8 7 4 12 7 8 9
		do{
			hs.add(numbers[i-1]);
			hs.add(numbers[i]);
		}while(true);
		
	}
	
	public void setInitialDirection(int[] numbers){
		if(numbers[1] - numbers[0] > 0){  
			up = true;
		}else{
			up = false;
		}
	}
	
	public boolean checkDirection(int i, int d){ // initial floor and destination
		if(d - i > 0)
			return true;  // going up
		else
			return false; // going down
	}
	
	public ArrayList<ArrayList<Integer>> getModeAList(){
		return modeAList;
	}
	public ArrayList<ArrayList<Integer>> getModeBList(){
		return modeBList;
	}
}
