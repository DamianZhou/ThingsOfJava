package com.hard;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. 
 * If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * @author DamianZhou
 * @see https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class P33_Search_in_Rotated_Sorted_Array {

    public static int search(int[] A, int target) {
		return checkList(A, 0, A.length-1, target);
        
    }
    
    /**
     * 循环数组二分查找
     * @param num
     * @param start
     * @param end
     * @param target
     * @return
     */
    private static int checkList(int[] num,int start,int end,int target){
    	
    	if(num[start]==target) return start;
    	if(num[end]==target) return end;
    	
    	//可能出现 左边最大值和右边最小值 和 只有一个值传递 情况
    	if(end<=start+1)
    		return -1;
    	
    	int mid=(start+end)>>>1;

    	if(num[mid]==target)
    		return mid;
    	else if(num[mid]>num[start]){
    		//左边有序，右边无序
    		if(num[mid]>target && target>=num[start]){
    			return BinarySearch(num, start, mid-1, target); //优先考虑【顺序部分】的处理
    		}else{
    			return checkList(num, mid+1, end, target);
    		}
    	}else{
    		//左边无序，右边有序
    		if(num[mid]<target && target<=num[end])
    			return BinarySearch(num, mid+1, end, target);
    		else
    			return checkList(num, start, mid-1, target);
    	}
    }
    
    /**
     * 标准二分查找
     * @param num
     * @param start
     * @param end
     * @param target
     * @return
     */
    private static int BinarySearch(int[]num,int start,int end,int target){
    	if(num[start]>target || num[end]<target)
    		return -1;
    	
    	int mid=(start+end)>>>1;
    	if(num[mid]==target)
    		return mid;
    	else if(num[mid]>target){
    		end=mid-1;
    		return BinarySearch(num, start, end, target);
    	}else{
    		start=mid+1;
    		return BinarySearch(num, start, end, target);
    	}
    	
    }
    
    /**
     * 参考
     * @param A
     * @param target
     * @return
     * @see https://leetcode.com/discuss/22678/revised-binary-search
     */
    public static  int search1(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            System.out.println("--------mid="+A[mid]);
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        System.out.println("--------lo="+A[lo]);
        return A[lo] == target ? lo : -1;
    }
	public static void main(String[] args) {
		int[] num1={1,3,5,6};
		int[] num2={11,14,14,15,26,26,1,3,5,6,7,9,10};

		System.out.println(search1(num2,14));
		System.out.println("---------------------");
	}

}
