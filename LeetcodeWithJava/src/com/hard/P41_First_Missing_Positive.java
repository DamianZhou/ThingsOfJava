package com.hard;

/**
 * 正整数 1，2，3，4，5，...
 * 找到当前数组最先丢失的正整数
 * @author DamianZhou
 * @see https://leetcode.com/problems/first-missing-positive/
 */
public class P41_First_Missing_Positive {
	
	/**
	 * 基于有序的情况
	 * @param A
	 * @return
	 */
	public static int firstMissingPositive(int[] A) {
		int i=0;
		int len=A.length;
		if(len==0 ) return 1;
		while(i<len && A[i]<=0)
			i++;
		if(i<len){
			if(A[i]!=1)	return A[i]-1;//首位置判断
			
			for(;i<len;i++){
				if(A[i]<=0)
					return A[i-1]+1;
				else if(i==len-1)
					return A[i]+1;
			}
		}


		return 1;
	}
	public static void main(String[] args) {
		int[] A ={3,4,-1,1};
		int[] B = {1,2,0};
		int[] C = {-1,2};
		int[] D = {0,6};
		int[] E = {2,1};
		System.out.println(firstMissingPositive(A));
		System.out.println(firstMissingPositive(B));
		System.out.println(firstMissingPositive(C));
		System.out.println(firstMissingPositive(D));
		System.out.println(firstMissingPositive(E));

	}

}
