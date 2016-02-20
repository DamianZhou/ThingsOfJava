package com.demo.sort;

public class QuickSortII {

	int partition(int[] nums,int start,int end){
		int mid = nums[start];
		int i=start;
		int j=end;
		while(i<j){
			while(nums[j]>=mid && j>i){
				j--;
			}
			if(i<j)
				nums[i++]=nums[j];
			
			while(nums[i]<mid && i<j){
				i++;
			}
			if(i<j)
				nums[j--]=nums[i];
		}
		nums[i]=mid;
		
		for(int e:nums){
			System.out.print(e+",");
		}
		System.out.println();
		return i;
	}

	void subQuickSort(int[] nums,int start,int end){
		if(start>=end)
			return;
		else{
			int midpos = partition(nums,start,end);
			subQuickSort(nums,start,midpos-1);
			subQuickSort(nums,midpos+1,end);
		}
	}

	void quickSort(int[] nums){
		if(nums == null || nums.length<2)
			return;
		subQuickSort(nums, 0, nums.length-1);
	}

	public static void main(String[] args) {
		QuickSortII test = new QuickSortII();
		
		int[] nums = {5,6,4,3,2,6,2,8,45,6,5,6,7};
		test.quickSort(nums);
		
		for(int e:nums)
			System.out.print(e+",");
	}
}
