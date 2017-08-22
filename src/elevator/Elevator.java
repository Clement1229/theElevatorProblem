package elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	// store all the expected output of modeA 
	private ArrayList<ArrayList<Integer>> modeAList= new ArrayList<ArrayList<Integer>>();
	// store all the expected output of modeB
	private ArrayList<ArrayList<Integer>> modeBList= new ArrayList<ArrayList<Integer>>();
	
	 
	public void modeA(String line){ 
		
		int distance = 0; // elevator total travel distance
		ArrayList<Integer> ls = new ArrayList<Integer>();  // store the output
		String[] split = line.split("-|,|:"); // 1-5,1-6 => 1 5 1 6
		int[] numbers = new int[split.length];
		int mod; // modifier = -1: when nextFloor - currentFloor < 0 
		
		
		for(int i = 0; i < split.length ; i++){
			//Integer floor = Integer.valueOf(split[i]);  // String to Integer
			numbers[i] = Integer.valueOf(split[i]);
			ls.add(numbers[i]);
			if(i != 0){  // 10 8 1
				if(numbers[i] - numbers[i-1] >= 0){
					   mod = 1;
				   }
				   else{
					   mod = -1;
				   }
				
				distance += (numbers[i] - numbers[i-1])*mod;
			}
			
		}
		System.out.print(ls);
		System.out.println(" distance:" + distance);
		ls.add(0,distance); // add distance at the index0
		System.out.println(ls);
		modeAList.add(ls);
		//System.out.println("list of list :" + modeAList);
	
		
		
	}
	
	public void modeB(String line){
		
	}
	
	public ArrayList<ArrayList<Integer>> getModeAList(){
		return modeAList;
	}
	public ArrayList<ArrayList<Integer>> getModeBList(){
		return modeBList;
	}
}
