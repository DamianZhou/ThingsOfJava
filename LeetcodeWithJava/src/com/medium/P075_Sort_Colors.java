package com.medium;

import java.util.Arrays;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/sort-colors/
 */
public class P075_Sort_Colors {
	
	public void sortColors(int[] nums) {
		
	}
	
	/**
	 * https://leetcode.com/discuss/17000
	 * @param nums
	 */
	public void sortColors_s1(int[] nums) {
		if(nums==null || nums.length<2)
			return;

		int n = nums.length;
		int second=n-1, zero=0;//指向待确定的数值
		
		for (int i=0; i<=second; i++) {
			while (nums[i]==2 && i<second) {
				//如果有2，一直调换到最后
				nums[i]=nums[second];
				nums[second]=2;
				second--;
			}
			while (nums[i]==0 && i>zero) {
				//如果有0，一直调换到最前
				nums[i]=nums[zero];
				nums[zero]=0;
				zero++;
			}
		}
	}

	public static void main(String[] args) {
		P075_Sort_Colors test = new P075_Sort_Colors();
		int[] nums = {0,1,2,0,1,2,0,1,2,0,1,2};
		test.sortColors(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
