package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class P209_Minimum_Size_Subarray_Sum {

	/**
	 * 2015/05/15
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length==0) return 0;

		return 0;
	}
	
	/**
	 * 使用滑动窗口
	 * @param s
	 * @param nums
	 * @return
	 * @see https://leetcode.com/discuss/35626/java-solution-o-n-time-sliding-window
	 */
	public int minSubArrayLen_ref(int s, int[] nums) {
        int front=0;
        int end=0;
        int sum=0;
        int minSub = nums.length; //记录最短的窗口长度
        
        while(end < nums.length) {
            while(sum<s && end<nums.length)
                sum+=nums[end++];
            while(sum>=s && front<end) {
                minSub = Math.min(minSub, end-front);
                sum-=nums[front++];
            }
            
            System.out.println(front+" : "+end);
        }
        return minSub==nums.length? 0: minSub;
    }

	public static void main(String[] args) {
		P209_Minimum_Size_Subarray_Sum test = new P209_Minimum_Size_Subarray_Sum();

		int s=7;
		int[] nums = {2,3,1,2,4,3};

		System.out.println(test.minSubArrayLen_ref(s, nums));

	}

}
