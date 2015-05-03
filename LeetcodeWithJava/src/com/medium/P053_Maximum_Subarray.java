package com.medium;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/maximum-subarray/
 */
public class P053_Maximum_Subarray {
	
	/**
	 * 连续数字的和最大
	 * DP
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
    	
    	int len = nums.length;
    	if(len==0) return Integer.MIN_VALUE;
    	if(len == 1) return nums[0];
    	
    	int sum=nums[0];
    	int max = sum;
    	for(int i=1;i<len;i++){
    		sum = Math.max(sum+nums[i], nums[i]);	// i-1的 最大sum ， 在 i 处进行判断
     		max = Math.max(sum, max);
    	}
    	return max;
    }
	public static void main(String[] args) {
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

}
