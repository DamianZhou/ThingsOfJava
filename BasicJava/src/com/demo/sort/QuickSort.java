package com.demo.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Damian
 *
 */
public class QuickSort {
	
	
	/**
	 * 快速交换排序
	 * @param n
	 * @param left
	 * @param right
	 */
	static void quicksort(int n[], int left, int right) {
		int dp;
		if (left < right) {
			dp = partition(n, left, right);
			System.out.println(Arrays.toString(n));
			quicksort(n, left, dp - 1);
			quicksort(n, dp + 1, right);
		}
	}

	static int partition(int n[], int left, int right) {
		int pivot = n[left]; //默认取第一个
		
		while (left < right) {
			while (left < right && n[right] >= pivot) //右边的小值
				right--;
			if (left < right)
				n[left++] = n[right];
			
			while (left < right && n[left] <= pivot) //左边的大值
				left++;
			if (left < right)
				n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}
	
	public static void main(String[] args){
		int[] num = {7,5,4,1,54,69,9,23};
		System.out.println(Arrays.toString(num));
		quicksort(num, 0, num.length-1);
	}
}
