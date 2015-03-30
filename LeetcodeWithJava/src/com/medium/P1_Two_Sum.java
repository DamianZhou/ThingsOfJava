package com.medium;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 给定一组整数，找到两个数，使两个数的和为target
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.

 	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 * 
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/two-sum/
 */
public class P1_Two_Sum {


	/**
	 * 超时
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum1(int[] numbers, int target) {

		int ans[] = new int[2];
		int len=numbers.length;

		for(int i=0;i<len-1;i++)
			for(int j=i+1;j<len;j++)
				if(numbers[i]+numbers[j]==target){
					ans[0]=i;
					ans[1]=j;
					return ans;
				}

		return null;
	}

	/**
	 * 参考--------------------
	 * 使用HashTable
	 * hashTable中是存的是差值，当遍历遇到符合条件的差值的时候，即匹配成功
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

		for(int i = 0; i < numbers.length; i++){
			
			if(table.containsKey(numbers[i])){
				result[0] = table.get(numbers[i]) + 1;
				result[1] = i + 1;
			}
			table.put(target - numbers[i], i); //将期待的值放入HashTable中
		
		}

		return result;
	}

	public static void main(String[] args) {

		int[] numbers={3,2,4};
		int target=6;
		int[] ans=twoSum(numbers, target);
		System.out.println(ans[0]+"---"+ans[1]);


	}

}
