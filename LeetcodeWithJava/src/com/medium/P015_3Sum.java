package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/3sum/
 */
public class P015_3Sum {

	/**
	 * 2015/05/09 未完成
	 * @param nums
	 * @return
	 * 
	 * 非递减数列（(ie, a ≤ b ≤ c)）、每个元素不超过2个
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		int len = nums.length;
		if(len <= 3) return result;    	

		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		if(nums[0]>=0 || nums[len-1]<=0) return result; //无法获取到0

		int changepos = findChangePoint(nums, 0, len-1);
		int left = 0 , right = len-1;
		int a,b,sum,pos;

		while(right>changepos && left<changepos){
			a=nums[left];
			b=nums[right];
			sum = a+b;
			pos= changepos;
			if(sum==0)
				if(nums[pos]==0) 
					result.add(new ArrayList<Integer>( Arrays.asList(a,nums[pos],b) ) );
				else if(nums[pos]<0){
					while(pos<=right){
						if(nums[pos]+a+b == 0) 
							result.add(new ArrayList<Integer>( Arrays.asList(a,nums[pos],b) ) );
						pos++;
					}
				}else{
					while(pos>=left){
						if(nums[pos]+a+b == 0) 
							result.add(new ArrayList<Integer>( Arrays.asList(a,nums[pos],b) ) );
						pos--;
					}  				
				}
			right--;
			left++;

		}

		//找到正负的分界点
		System.out.println(findChangePoint(nums, 0, len-1));

		return result;

	}

	/**
	 * 2015/05/09
	 * 正负的分界点
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	int findChangePoint(int[] nums, int start, int end){

		if(end ==  start) 
			return start;
		else if( (end-start)==1) 
			return start; //取较小的数

		int mid = (start+end)>>1;
				if(nums[mid]==0) 
					return mid;
				else if(nums[mid]>0) 
					return findChangePoint(nums, start, mid);
				else 
					return findChangePoint(nums, mid, end);

	}

	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum_ref(int[] nums) {
		return null;
		
	}
	
	public static void main(String[] args) {
		P015_3Sum test = new P015_3Sum();
		int[] nums = {-1,1,2 ,-1, -4,0};

		List<List<Integer>>  result = test.threeSum(nums);

		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.toString(result.get(i).toArray()));
		}

	}

}
