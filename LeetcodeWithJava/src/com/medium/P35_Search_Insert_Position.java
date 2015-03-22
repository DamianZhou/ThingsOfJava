package com.medium;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 在有序数组中找到目标值的位置
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/search-insert-position/
 */
public class P35_Search_Insert_Position {

	/**
	 * 最简单的查找(通过)
	 * @param A
	 * @param target
	 * @return
	 */
	public static  int searchInsert1(int[] A, int target) {

		int i=0;
		for(i=0;i<A.length;i++){
			if(A[i]>=target)
				return i;
		}
		return A.length;
	}

	/**
	 * 二分查找
	 * @param A
	 * @param target
	 * @return
	 */
	public static  int searchInsert(int[] A, int target) {
		return BinarySearch(A, 0, A.length-1, target);

	}

	/**
	 * 二分查找插入位置
	 * @param num
	 * @param start
	 * @param end
	 * @param target
	 * @return
	 */
	private static int BinarySearch(int[] num,int start,int end,int target){

		System.out.println("start="+start+",end="+end);
		
		if(target<=num[start])
			return start;

		if(target>num[end]) //等于的时候，位置在前
			return end+1;

		int mid=(start+end)>>>1;
		if(num[mid]==target){
			int t=mid-1;
			while(num[t]==target)
				t--;
			return t+1;
		}else if(num[mid]>target){
			if(num[mid-1]<target)
				return mid;
			end=mid-1;			
			return BinarySearch(num, start, end, target);
		}else{
			if(num[mid+1]>target)
				return mid+1;
			
			start=mid+1;
			return BinarySearch(num, start, end, target);
		}

	}


	public static void main(String[] args) {

		int[] num1={1,3,5,6};
		int[] num2={1,3,5,6,7,9,10};

		System.out.println(searchInsert(num1,5));
		System.out.println("---------------------");
		System.out.println(searchInsert(num1,2));
		System.out.println("---------------------");
		System.out.println(searchInsert(num1,7));
		System.out.println("---------------------");
		System.out.println(searchInsert(num1,0));

	}

}
