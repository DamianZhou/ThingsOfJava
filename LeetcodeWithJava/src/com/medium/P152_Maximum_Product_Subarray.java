package com.medium;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/maximum-product-subarray/
 */
public class P152_Maximum_Product_Subarray {
	/*
	 * 解题思路：
	 * 需要求最大乘积，以0为分界点，分别计算不同区间的最大值
	 * 
	 * 对每个子区间的计算，计算负数的个数，
	 * 如果是负数的个数为偶数，则直接求积；
	 * 如果负数的个数为奇数，则以最左和最右两个负数为分割点，计算左右两边的乘积大小，比较得到较大的一半
	 */
	
    public int maxProduct(int[] nums) {
    	if(nums==null || nums.length<1)
    		return 0;
    	int tempMax = Integer.MIN_VALUE;
    	int start=0;
    	boolean zeroflag = false;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0){
    			int temp = subMaxProduct(nums, start, i-1);
    			tempMax = temp>tempMax?temp:tempMax;
    			start=i+1;
    			zeroflag=true;
    		}
    		if(i == nums.length-1){
    			int temp = subMaxProduct(nums, start, i);
    			tempMax = temp>tempMax?temp:tempMax;
    		}
    	}
    	
		if(tempMax<0 && zeroflag)
			return 0;
		else
			return tempMax;
        
    }
    int subMaxProduct(int[] nums,int start,int end){
    	if(start>end)
    		return 0;
    	else if(start==end)
    		return nums[start];
    	
    	int negativeNum = 0;
    	for(int i=start;i<=end;i++){
    		if(nums[i] < 0)
    			negativeNum++;
    	}
    	if(negativeNum%2==0){
    		int maxP=1;
    		for(int i=start;i<=end;i++)
    			maxP *= nums[i];
    		return Math.abs(maxP);
    	}else{
    		int subLeft=1;
    		int subRight=1;
    		int i=0;
    		int j=0;
    		for(i=start;i<=end;i++){
    			subLeft *= nums[i];
    			if(nums[i]<0)
    				break;
    		}
    		for(j=end;j>=start;j--){
    			subRight *= nums[j];
    			if(nums[j]<0)
    				break;
    		}
    		//取最大的乘积
    		if(Math.abs(subLeft)<Math.abs(subRight)){
        		int maxP=1;
        		for(i=i+1;i<=end;i++)
        			maxP *= nums[i];
        		return maxP;
    		}else{
        		int maxP=1;
        		for(j=j-1;j>=start;j--)
        			maxP *= nums[j];
        		return maxP;
    		}
    		
    	}
    }
    
	public static void main(String[] args) {
		P152_Maximum_Product_Subarray test = new P152_Maximum_Product_Subarray();
		
		int[] nums = {2,3,0,-2,-1,4,2};
		
		int result = test.maxProduct(nums);
		System.out.println(result);
	}

}
