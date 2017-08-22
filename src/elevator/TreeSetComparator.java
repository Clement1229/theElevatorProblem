package elevator;

import java.util.Comparator;
import java.util.HashSet;

//customized sorting order by implements Comparator
public class TreeSetComparator implements Comparator<Integer>{
	
	HashSet<Integer> hs = new HashSet<Integer>();
	
	public TreeSetComparator(HashSet<Integer> s){
		hs.addAll(s);
	}
	@Override
	public int compare(Integer arg0, Integer arg1) {
		if(arg0 > arg1)	return -1;
		if(arg0 < arg1)	return 1;
		else return 0;
		
	}
}
