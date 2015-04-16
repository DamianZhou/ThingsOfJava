package com.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. 查找中间元素
 * You may assume no duplicate exists in the array.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class P153_Find_Minimum_in_Rotated_Sorted_Array_I {

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

		return myBinarySearch(nums,0,nums.size()-1);
	}

	/**
	 * 向波谷逼近
	 * @param num
	 * @param start
	 * @param end
	 * @return
	 */
	private static int myBinarySearch(List<Integer> num,int start,int end){
		//		System.out.println("s="+start+"    e="+end);

		int mid = (start+end)/2; //mid偏向于左边的值
		
		if(num.get(mid)>num.get(start) && num.get(mid)>num.get(end) )
			return myBinarySearch(num,mid,end);
		else if(num.get(mid)<num.get(start) && num.get(mid)<num.get(end) )
			return myBinarySearch(num,start,mid);
		else if(num.get(mid)>=num.get(start) && num.get(mid)<num.get(end) ) //已经是有序
			return num.get(start);
		else{
			return num.get(end);
		}


	}




	/**
	 * 查找最小值
	 * @param num 循环有序数组
	 * @return
	 */
	public static int findMin(int[] num) {

		//直接遍历
		int len=num.length;
		int i=0;

		for(i=0;i<len-1;i++){
			if(num[i]>num[i+1])
				return num[i+1];
		}

		return num[0];

	}

	//参考：二分查找-------------------------------------------------------------------------------------------------
	public static int findMin1(int[] num) {
		return binarySearch(num, 0, num.length-1);
	}

	private static int binarySearch(int[] num, int begin, int end){
		while(begin < end){

			int middle = (begin+end)/2;

			if(num[middle] > num[middle+1])  //判断middle的右情况
			return num[middle+1];

			if(num[middle] > num[end]) 
				begin = middle+1;
			else 
				end = middle;
		}
		return num[begin];
	}
	//-------------------------------------------------------------------------------------------------


	public static void main(String[] args) {
		//		int[] num = {4,6,3};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//		nums.add(51);
		//		nums.add(64);
		nums.add(42);
		nums.add(32);

		System.out.print(findMin(nums));
	}

}
