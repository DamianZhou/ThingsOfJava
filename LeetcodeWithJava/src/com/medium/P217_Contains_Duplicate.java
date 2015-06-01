package com.medium;

import java.util.BitSet;
import java.util.HashSet;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/contains-duplicate/
 */
public class P217_Contains_Duplicate {

	public boolean containsDuplicate(int[] nums) {
		int len = nums.length;

		if(len<2) return false;

		//不能保证不含有负数，所以不能使用BitSet
		//    	BitSet bs = new BitSet(len+1);

		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int e : nums){
			if(hs.contains(e))
				return true;
			else
				hs.add(e);
		}
		return false;
	}

	public static void main(String[] args) {

		P217_Contains_Duplicate test = new P217_Contains_Duplicate();

		int[] nums = {-1,-8,-4,88,77,89,1,4};
		
		System.out.println(test.containsDuplicate(nums));

	}

}
