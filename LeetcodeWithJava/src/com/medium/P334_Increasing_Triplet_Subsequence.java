package com.medium;
/**
 * 
 * @author Administrator
 * @see https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class P334_Increasing_Triplet_Subsequence {
	
	/**
	 * https://leetcode.com/discuss/86708/java-two-variable-solution-explanation
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3) return false;
        int one = Integer.MAX_VALUE; //最小值
        int two = Integer.MAX_VALUE; //已经有匹配的第二个值
        for(int num:nums){
            if(num>one){
                if(num>two){
                    return true;
                }else{
                    two = num;
                }
            }else{
                one = num;
            }
        }
        return false;
    }
	
    /**
     * 非连续子数组
     * @param nums
     * @return
     */
    public boolean increasingTriplet_wrong(int[] nums) {
    	
    	if(nums==null || nums.length<3)
    		return false;
    	
    	boolean result = false;
    	
    	for(int i=1;i<nums.length-1;i++){
    		if(nums[i]>nums[i-1] && nums[i]<nums[i+1]){
    			result = true;
    			break;
    		}else if(nums[i]>=nums[i+1]){
    			i=i+1;
    		}
    	}
    	
    	return result;
        
    }

	public static void main(String[] args) { 
		P334_Increasing_Triplet_Subsequence test = new P334_Increasing_Triplet_Subsequence();
		
//		int[] nums = {1,2,1,4,5};
//		int[] nums = {5,1,5,5,2,5,4};
		int[] nums = {8,3,4,2,7};
		boolean result = test.increasingTriplet(nums);
		System.out.println(result);
	}

}
