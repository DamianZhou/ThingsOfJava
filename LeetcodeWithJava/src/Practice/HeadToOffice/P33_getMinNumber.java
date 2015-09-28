package Practice.HeadToOffice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P33_getMinNumber {
	
    public String PrintMinNumber(int [] numbers) {
    	if(numbers.length==0)
    		return "";
    	else if(numbers.length==1)
    		return ""+numbers[0];
    	
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	for(int i =0;i<numbers.length;i++ )
    		nums.add(numbers[i]);
    	
		Collections.sort(  nums , intComparator);
		
		StringBuilder result = new StringBuilder("");
		
		for (int val : nums){
			result.append(val);
		}
		
		return  result.toString();
    	
    }

	int getMinNumber(ArrayList<Integer> nums){
		Collections.sort(  nums , intComparator);
		
		StringBuilder result = new StringBuilder("");
		
		for (int val : nums){
			result.append(val);
		}
		
		return Integer.parseInt( nums.toString() );
	}
	
	Comparator<Integer> intComparator = new Comparator<Integer>() {
		
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			StringBuilder s1 = new StringBuilder( Integer.toString(o1) );
//			StringBuilder s2 = new StringBuilder( Integer.toString(o2) );			
//			//数位对齐
//			while( s1.length() != s2.length() ){
//				if(s1.length()<s2.length()){
//					s1.append('0');
//				}else
//					s2.append('0');
//			}//while
//			return s1.toString().compareTo(s2.toString());
//		}
		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = ""+o1+o2;
			String s2 = ""+o2+o1;
			return s1.compareTo(s2);
		}
	};
	
	
	public static void main(String[] args) {
		
		

	}

}
