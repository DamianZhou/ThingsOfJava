package com.medium;
/**
 * 
 * @author Administrator
 * @see https://leetcode.com/problems/patching-array/
 */
public class P330_Patching_Array {

    public int minPatches(int[] nums, int n) {
    	
    	
    	
		return n;
        
    }
	
    /**
     * https://leetcode.com/discuss/82822
     * Let miss be the smallest sum in [0,n] that we might be missing. 
     * Meaning we already know we can build all sums in [0,miss).
     * @param nums
     * @param n
     * @return
     */
    int minPatches_s1(int[] nums, int n) {
        int miss = 1;  //最小子集之和
        int added = 0; //添加数值的个数
        int i = 0;
        while (miss <= n) {
        	
            if (i < nums.length && nums[i] <= miss) { 
            	//包含当前数值，直接扩充
                miss += nums[i++];
            } else {
            	//如果数组中没有新的数 || 当前数值较大，则新增miss大小的数，最小覆盖
                miss += miss;
                added++;
            }
            
        }
        return added;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
