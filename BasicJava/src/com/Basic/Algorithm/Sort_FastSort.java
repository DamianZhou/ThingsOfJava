package com.Basic.Algorithm;

import java.util.Arrays;

public class Sort_FastSort {

	void fastSort(int[] nums,int start,int end){
		if(end==start) return;
		int pos = Partition(nums,start,end) ;
		fastSort(nums, start, (pos-1)>start?pos-1:start);
		fastSort(nums, (pos+1)<end?pos+1:end, end);
	}

	/**
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 */
	void quickSort(int[] nums,int start,int end){
		if(start<end){
			int pos = Partition(nums,start,end) ;
			quickSort(nums, start, pos-1); 
			quickSort(nums, pos+1, end); 
		}
	}

	/**
	 * 分区方法
	 * @param nums
	 * @param start
	 * @param end
	 * @return 返回元素最终的位置
	 */
	int Partition(int[] nums, int start, int end){
		int temp = nums[start];
		int i=start;
		int j=end;

		while(i<j){

			while(nums[j]>temp && j>i)
				j--;
			if(i==j) break;
			nums[i++] = nums[j];

			while(nums[i]<temp && i<j)
				i++;
			if(i==j) break;
			nums[j--]=nums[i];
		}
		nums[i]=temp;

		return i;
	}

	public static void main(String[] args) {
		Sort_FastSort test = new Sort_FastSort();

//		int[] nums = {5,2,7,8,6,3};
//				int[] nums = {5,4,3,2,1};
				int[] nums = {5,6,7,8,9,1};

		//		int[] nums = {5,6,2,1};

		//		test.Partition(nums, 0, nums.length-1);

//		test.fastSort(nums, 0, nums.length-1);
		test.quickSort(nums, 0, nums.length-1);

		System.out.println(Arrays.toString(nums));

	}

}
