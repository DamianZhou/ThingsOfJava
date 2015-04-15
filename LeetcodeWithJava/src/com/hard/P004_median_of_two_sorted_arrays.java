package com.hard;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class P004_median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int lenA=A.length;
        int lenB=B.length;
        int k = (lenA+lenB)/2;
        
        
    	return 0;
    }
	public static void main(String[] args) {
		int[] A = {1,3,5,7,9};
		int[] B = {2,4,6,8,10};
		System.out.println(findMedianSortedArrays(A, B));
	}

}
