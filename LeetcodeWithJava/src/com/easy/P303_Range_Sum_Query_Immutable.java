package com.easy;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/range-sum-query-immutable/
 */
public class P303_Range_Sum_Query_Immutable {





	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 1));
		System.out.println(numArray.sumRange(1, 2));
	}

}

class NumArray {
	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
	int[] tempSum = null;
	public NumArray(int[] nums) {
		tempSum = new int[nums.length+1];
		tempSum[0]=0;
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			tempSum[i+1]=sum;
		}
	}

	public int sumRange(int i, int j) {
		return tempSum[j+1]-tempSum[i];
	}
}