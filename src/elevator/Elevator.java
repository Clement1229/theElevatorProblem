package elevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import elevator.TreeSetComparator;

public class Elevator {
	// store all the expected output of modeA 
	private ArrayList<ArrayList<Integer>> modeAList= new ArrayList<ArrayList<Integer>>();
	// store all the expected output of modeB
	private ArrayList<ArrayList<Integer>> modeBList= new ArrayList<ArrayList<Integer>>();
	// expected distance List
	private ArrayList<Integer> distanceAList = new ArrayList<Integer>();
	//expected distance List
	private ArrayList<Integer> distanceBList = new ArrayList<Integer>();
	
	int distance = 0; // elevator total travel distance
	boolean up; // moving direction => default: if requested floor - initial floor > 0
	
	
	
	//modeA => arrayList
	public void modeA(String line){ 
		
		ArrayList<Integer> ls = new ArrayList<Integer>();  // store the output
		ArrayList<Integer> ns = new ArrayList<Integer>();  // new list => list without consecutive duplicates
		String[] split = line.split("-|,|:"); // 9:1-5,1-6 => 9 1 5 1 6
		int[] numbers = new int[split.length];
			
		
		for(int i = 0; i < split.length ; i++){
			
			numbers[i] = Integer.valueOf(split[i]);
			ls.add(numbers[i]);
			
		}
		
		ns.addAll(removeConsecutiveDups(ls));
		distanceAList.add(calculateDistance(ns));
		modeAList.add(ns);
		distance = 0; // set back to default
	}
	
	
	//modeB => Two TreeSet, one implements Comparator
	public void modeB(String line){ // EX: input  7:11-6,10-5,6-8,7-4,12-7,8-9
		
		ArrayList<Integer> ls = new ArrayList<Integer>();  // store the output
		ArrayList<Integer> ns = new ArrayList<Integer>();  // new list => list without consecutive duplicates
 		String startPos = line.substring(0,line.indexOf(":")); // 7, separate startPos with the rest
		String floorRequest = line.substring(line.indexOf(":")+1); // the rest
		String[] split = floorRequest.split("-|,|:"); // 11 6 10 5 6 8 7 4 12 7 8 9
		int[] numbers = new int[split.length];
		
		HashSet<Integer> hs = new HashSet<Integer>();
		TreeSet<Integer> ats = new TreeSet<Integer>(hs); //Ascending Order
		TreeSet<Integer> dts = new TreeSet<Integer>(new TreeSetComparator(hs)); //Descending Order
		
		
		
		for(int i = 0; i < split.length ; i++){ // String[] to Integer[]
			
			numbers[i] = Integer.valueOf(split[i]);
			//System.out.print(numbers[i]+ " ");
			
		}
		//System.out.println();
		
		
		//boolean up; // default: if requested floor - initial floor > 0
		setInitialDirection(numbers);
		//System.out.println("Elevator inital direction: " + up);
		
		
		/* ** sorting elements based on same direction  ** */ 
		for ( int i = 1; i < numbers.length; i+=2){
			
			System.out.println("current direction: " + checkDirection(numbers[i-1],numbers[i])+ " || up: " + up);
			if(checkDirection(numbers[i-1],numbers[i]) == up){
				if(up == true){  // if up
					ats.add(numbers[i-1]);
					ats.add(numbers[i]);
					System.out.println("ats: " + ats);
				}else{ // if down
					dts.add(numbers[i-1]);
					dts.add(numbers[i]);
					System.out.println("dts: " + dts);
				}
				
			}else{ // if the direction is opposite
				if(up == true){ // if the previous direction was up
					
					
					ls.addAll(ats);				
					System.out.println("ls: " + ls);
					up = false;
					ats.clear();
					dts.add(numbers[i-1]);
					dts.add(numbers[i]);
				}else{
					ls.addAll(dts);
					System.out.println("ls: " + ats);
					up = true;
					dts.clear();
					ats.add(numbers[i-1]);
					ats.add(numbers[i]);
				}
				
				//up = checkDirection(numbers[i-1],numbers[i]);
			}
		}
		if(ats.isEmpty()!= true){
			ls.addAll(ats);
		}else{
			ls.addAll(dts);
		}
		ls.add(0,Integer.valueOf(startPos)); // add startPos to index of 1
		System.out.println("========ArrayList: " +ls + "==========");
		ns.addAll(removeConsecutiveDups(ls));
		System.out.println("removed dups:" + ns);
		
		distanceBList.add(calculateDistance(ns));
		modeBList.add(ns);
		distance = 0;
			
			
	}// modeB() end
	
	public int calculateDistance(ArrayList<Integer> ns){
		for(int i =1 ; i < ns.size(); i++){
			if(ns.get(i) - ns.get(i-1) < 0){
				distance += -(ns.get(i) - ns.get(i-1));
			}else
				distance += (ns.get(i) - ns.get(i-1));
		}
		return distance;
	}
	
	
	public void setInitialDirection(int[] numbers){
		if(numbers[1] - numbers[0] > 0){  
			up = true;
		}else{
			up = false;
		}
	}
	
	public boolean checkDirection(int i, int distance){ // initial floor and destination
		if(distance - i > 0)
			return true;  // going up
		else
			return false; // going down
	}
	
	// remove consecutive duplicates in ArrayList => elevator won't hit the same floor continuously
	public static ArrayList<Integer> removeConsecutiveDups(ArrayList<Integer> input) {

		  ArrayList<Integer> newList = new ArrayList<Integer>();

		  // Always add first value
		  newList.add(input.get(0));

		  // Iterate the remaining values
		  for(int i = 1; i < input.size(); i++) {
		    // Compare current value to previous
		    if(input.get(i-1) != input.get(i)) {
		       newList.add(input.get(i));
		    }
		  }

		  return newList;
	}
	
	public ArrayList<ArrayList<Integer>> getModeAList(){
		return modeAList;
	}
	public ArrayList<ArrayList<Integer>> getModeBList(){
		return modeBList;
	}
	public ArrayList<Integer> getDistanceAList(){
		return distanceAList;
	}
	public ArrayList<Integer> getDistanceBList(){
		return distanceBList;
	}
}
