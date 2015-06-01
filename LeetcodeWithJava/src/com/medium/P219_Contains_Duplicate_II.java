package com.medium;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 * @author Damian
 *@see https://leetcode.com/problems/contains-duplicate-ii/
 */
public class P219_Contains_Duplicate_II {

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
		int len = nums.length;
		
		if(len<2 || k<1) return false;
		
		HashSet<Integer> hs = new HashSet<Integer>();
    	LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int e : nums){
			if(hs.contains(e))
				return true;
			else{
				if(list.size()>k-1){
					int t = list.removeFirst();
					hs.remove(t);
				}
				list.add(e);
				hs.add(e);
			}
		}
    	
    	return false;
        
    }
	
	public static void main(String[] args) {
		P219_Contains_Duplicate_II test = new P219_Contains_Duplicate_II();
		

		int[] nums = {-1,-8,-4,88,77,89,1,4};
		
		System.out.println(test.containsNearbyDuplicate(nums,3));

	}

}
