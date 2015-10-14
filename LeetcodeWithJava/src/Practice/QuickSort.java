package Practice;

import java.util.Arrays;

public class QuickSort {
	
	public static int count=0;

	private int getSplit(int[] nums,int startpos,int endpos){
		
		if(endpos<=startpos)
			return startpos;
		
		int base = nums[startpos];
		int temp_pos=startpos;
		int left=startpos+1;
		int right=endpos;
		
		while(left<right){
			
			while(nums[right]>base && left<right)
				right--;
			if(left<right){
				nums[temp_pos]=nums[right];
				temp_pos=right;
				left++;
			}
			while(nums[left]<base && left<right)
					left++;
			if(left<right){
				nums[temp_pos]=nums[left];
				temp_pos=left;
				right--;
			}
			
		}		
		nums[temp_pos]=base;
		return temp_pos;
	}
	
	
	private void quickSort(int[] nums,int spos,int epos){
		
		System.out.println(++count+Arrays.toString(nums));
		
		if(epos-spos<=0)
			return;
		int left  = spos;
		int right =  epos;
		int pos = getSplit(nums, left,right);
		if(pos-left>1)
			quickSort(nums, left, pos-1);
		if(right-pos>1)
			quickSort(nums,pos+1, right);
	}
	
	
	/**
	 * 参考 分区方法
	 * @param n
	 * @param left
	 * @param right
	 * @return
	 */
	private int partition(int n[], int left, int right) {
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
	
	
	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		
		int[] nums ={1,66,5,3,7,9,4,10};
//		int[] nums={4,2};
		System.out.println("original----"+Arrays.toString(nums));
//		test.getSplit(nums, 0, nums.length-1);
		test.quickSort(nums, 0, nums.length-1);
		System.out.println("new----"+Arrays.toString(nums));		

	}

}
