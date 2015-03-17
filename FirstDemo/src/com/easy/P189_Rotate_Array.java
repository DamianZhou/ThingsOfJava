package com.easy;

/**
 * Rotate an array of n elements to the right by k steps.
 * 向右循环移动 k步
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 至少3种实现方法。
 * 
 * [show hint]
 * Related problem: Reverse Words in a String II
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/rotate-array/
 */
public class P189_Rotate_Array {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5,6,7,8,9};

		printArray(nums);
		rotate2(nums,18);
		printArray(nums);


	}

	/**
	 * 转换1：申请完整数组，直接重排列
	 * @param nums
	 * @param k
	 */
	public static void rotate1(int[] nums, int k) {

		int[] list = new int[nums.length];
		int i=0;
		int  len=nums.length;

		for(i=k;i<len;i++)
			list[i-k]=nums[i];

		for(i=0;i<k;i++)
			list[len-k+i]=nums[i];

		for (i=0;i<nums.length;i++)
			nums[i]=list[i];
	}

	/**
	 * 错误！！！！
	 * @param nums
	 * @param k
	 */
	public static void rotate2(int[] nums, int k) {
		int i=0;
		int len=nums.length;
		int temp=0;
		
		k=k%len; //控制移动的步数在一个循环以内
		
		for (i=0;i<k;i++){
			temp=nums[i];
			nums[i]=nums[len-k+i];
			nums[len-k+i]=temp;
		}
	}


	/**
	 * 打印一维数组
	 * @param nums
	 */
	public static void printArray(int[] nums){
		for (int i=0;i<nums.length;i++){
			System.out.print(nums[i]+",");
		}
		System.out.println();
	}

}
