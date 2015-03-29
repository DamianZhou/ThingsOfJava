package com.medium;


/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. 查找中间元素
 * You may assume no duplicate exists in the array.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class P153_Find_Minimum_in_Rotated_Sorted_Array {

	/**
	 * 查找最小值
	 * @param num 循环有序数组
	 * @return
	 */
	public static int findMin(int[] num) {
		
		//直接遍历
		int len=num.length;
		int i=0;
		
		for(i=0;i<len-1;i++){
			if(num[i]>num[i+1])
				return num[i+1];
		}

		return num[0];

	}
	
	//参考：二分查找-------------------------------------------------------------------------------------------------
    public static int findMin1(int[] num) {
        return binarySearch(num, 0, num.length-1);
    }

    private static int binarySearch(int[] num, int begin, int end){
        while(begin < end){
           
        	int middle = (begin+end)/2;
            
            if(num[middle] > num[middle+1])  //判断middle的右情况
            	return num[middle+1];
            
            if(num[middle] > num[end]) 
            	begin = middle+1;
            else 
            	end = middle;
        }
        return num[begin];
    }
	//-------------------------------------------------------------------------------------------------
	

	public static void main(String[] args) {
		int[] num = {4 ,5, 6, 7, 0, 1, 2};
		System.out.print(findMin1(num));
	}

}
