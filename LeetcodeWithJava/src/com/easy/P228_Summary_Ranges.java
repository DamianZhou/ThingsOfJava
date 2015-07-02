package com.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhoucaidong
 * @see https://leetcode.com/problems/summary-ranges/
 */
public class P228_Summary_Ranges {
	/**
	 * 20150702
	 * @param nums
	 * @return
	 */
	public List<String> summaryRanges(int[] nums) {

		ArrayList<String> result = new ArrayList<String>();
		int len = nums.length;
		if(len <1)
			return result;


		int current = nums[0];
		String start = String.valueOf(current);
		String end = start;
		for(int i=1;i<nums.length;i++){
			if(nums[i]==current+1){
				end = String.valueOf(nums[i]);
			}else{
				if(start.equals(end))
					result.add(start);
				else{
					result.add(start+"->"+end);
				}
				start = String.valueOf(nums[i]);
				end = start;
			}
			current = nums[i];
		}


		//可能for一次都没执行
		if(end==null)
			result.add(start);
		else{
			if(start.equals(end))
				result.add(start);
			else{
				result.add(start+"->"+end);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		P228_Summary_Ranges test = new P228_Summary_Ranges();

//		int[] nums = {0,1,2,4,5,7};
		int[] nums = {1,2,3,6,7,8,10,11};
		

		List result = test.summaryRanges(nums);

		System.out.println(result);
	}

}
