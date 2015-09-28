package com.easy;

import java.util.Arrays;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/move-zeroes/
 */
public class P283_Move_Zeroes {

	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length<2)
			return ;
		int firstpos = 0;
		
		for(int i = 0; i<nums.length; i++ ){
			if(nums[i]!=0){
				nums[firstpos] = nums[i];
				firstpos++;
			}
		}
		
		while(firstpos<nums.length)
			nums[firstpos++] = 0;

	}

	public static void main(String[] args) {
		P283_Move_Zeroes test = new P283_Move_Zeroes();
		int[] nums = {0, 0, 0, 0, 0};
		System.out.println( Arrays.toString(nums) );
		test.moveZeroes(nums);
		System.out.println( Arrays.toString(nums) );
		
	}

}
