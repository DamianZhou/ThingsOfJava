package com.easy;

import java.util.Arrays;

import com.sun.scenario.effect.Merge;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/merge-sorted-array/
 */
public class P88_Merge_Sorted_Array {
	/**
	 * B into A
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 *  2015/4/15
	 */
	public static void merge(int A[], int m, int B[], int n) {
		int last = m+n-1;
		int i=m-1;
		int j=n-1;

		if(n==0) return;
		if(m==0){
			while(j>=0){
				A[j]=B[j];
				j--;
			}
			return;
		}


		while(last>=0){
			if(A[i]>B[j]){
				A[last]=A[i--];
			}else{
				//相等的时候取B
				A[last]=B[j--];
			}
			if(j<0) return;
			if(i<0){
				while(j>=0){
					A[j]=B[j];
					j--;
				}
				return;
			}
			last--;
		}


	}
	public static void main(String[] args) {
		int[] A = {0,0,0,0,0,0,0,0};
		int[] B = {4,6,44};
		merge(A,0,B,3);
		System.out.println(Arrays.toString(A));


	}

}
