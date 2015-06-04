package com.hard;

import java.util.Arrays;

/**
 * O(log (m+n))
 * @author Damian
 * @see https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class P004_median_of_two_sorted_arrays {


	/**
	 * 二分查找
	 * @param p
	 * @param n
	 * @param x
	 * @return
	 */
	static int findPos(int[] p,int n,int x){
		int low=0,high=n-1,mid;
		while(low<=high){
			mid=(low+high)>>1;
		if(p[mid]<=x)
			low=mid+1;
		else 
			high=mid-1;
		}
		return low;
	}

	
	/**
	 * 未完成
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		return 0;
	}

	//----------------------------------------------------

	/**
	 * 2015/05/25
	 * 解析为 求第k小的子问题
	 * @param nums1
	 * @param nums2
	 * @return
	 * @see http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
	 */
	public double findMedianSortedArrays_ref(int[] nums1, int[] nums2) {
		int total = nums1.length+nums2.length;

		if( (total & 0x01) ==1){
			return findKth(nums1, 0, nums2, 0, total/2+1);
		}else{
			return (findKth(nums1, 0, nums2, 0, total/2) + findKth(nums1, 0, nums2, 0, total/2+1) )/2;
		}

	}

	/**
	 * 在两个有序数组中查找第k小的数
	 * 
	 * 每次比较 k/2 位置，然后剔除 k/2 大小的部分数组，动态调整k的值
	 * @param nums1
	 * @param start1 当前起始位置 
	 * @param nums2
	 * @param start2 当前起始位置 
	 * @param k 当前所求的第k小
	 * @return
	 */
	public static double findKth(int[] nums1, int start1 , int[] nums2,int start2, int k){
		//确保 nums1代表的是 待计算数值长度 较小的一个
		if (nums1.length-start1 > nums2.length-start2)
			return findKth(nums2, start2, nums1, start1 , k);

		if (nums1.length-start1 == 0) //nums1 为空的情况
			return nums2[k - 1+start2];

		if (k == 1) //递归退出条件 k=1
			return Math.min(nums1[start1], nums2[start2]);

		//divide k into two parts
		int pa = Math.min(k / 2, nums1.length-start1);
		int pb = k - pa;
		
		int midpos1 = start1+pa-1;
		int midpos2 = start2+pb-1;
		
		if (nums1[midpos1] < nums2[midpos2])
			return findKth(nums1, midpos1+1, nums2, start2, k - pa);
		else if (nums1[midpos1] > nums2[midpos2])
			return findKth(nums1, start1, nums2, midpos2+1, k - pb);
		else
			return nums1[midpos1];
	}


	public static void main(String[] args) {
		P004_median_of_two_sorted_arrays test = new P004_median_of_two_sorted_arrays();
		
		int[] A = {1,3,5,7,9,14}; // 6
		int[] B = {2,4,6,8,10}; // 5
		System.out.println(test.findMedianSortedArrays_ref(A, B));
	}

}
