package com.medium;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author DamianZhou
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 相对上一题，允许重复
 */
public class P154_Find_Minimum_in_Rotated_Sorted_Array_II {

	/**
	 * 2015/4/16
	 * @param num
	 * @return
	 */
	public static int findMin(List<Integer> nums) {
		if(nums.size()==0)
			return 0;
		else if(nums.size()==1)
			return nums.get(0);
		
		//去除最右边的有影响的数字
		int len = nums.size()-1;
		while(nums.get(len)==nums.get(0)){
			nums.remove(len);
			len--;
			if(nums.size()==1)  return nums.get(0);
		}
		
		return BinarySearch(nums, 0, nums.size()-1);
	}

	private static int BinarySearch(List<Integer> nums,int start,int end){
		int mid = (start+end)/2;
		
		if(mid==start)
			return nums.get(start)<nums.get(end)?nums.get(start):nums.get(end); //只有两个值，直接返回
		
		if(nums.get(mid)>=nums.get(start) && nums.get(mid)>nums.get(end))
			return BinarySearch(nums, mid, end);
		else 	if(nums.get(mid)<nums.get(start) && nums.get(mid)<=nums.get(end))
			return BinarySearch(nums, start, mid);
		else	if(nums.get(mid)>=nums.get(start) && nums.get(mid)<=nums.get(end))	//已经有序
			return nums.get(start);
		else
			return nums.get(end);
		
	}


	public static void main(String[] args) {
		//		int[] num = {4,6,3};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		//错误提示
		// 1,3,3
		// 3,3,1,3
		
//		nums.add(42);
//		nums.add(42);
//				nums.add(51);
//				nums.add(64);
				nums.add(1);
		nums.add(32);
		nums.add(32);

		System.out.print(findMin(nums));
	}

}
