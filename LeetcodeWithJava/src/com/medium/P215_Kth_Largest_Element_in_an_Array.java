package com.medium;

import java.util.PriorityQueue;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class P215_Kth_Largest_Element_in_an_Array {

	/**
	 * 2015/05/24 
	 * 使用小顶堆，时间复杂度 O( length*logK)
	 * 适用于 n很大，k很小的情况
	 *  1 ≤ k ≤ array's length.
	 *  
	 *  Runtime: 328 ms 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(k); //默认小顶堆
		int i=0;
		//初始化堆
		for(;i<k;i++){
			heap.add(nums[i]);
		}

		int tmax=heap.poll(); //总是记录当前的第k大
		for(;i<nums.length;i++){
			if(nums[i]>tmax){
				heap.add(nums[i]);
				tmax=heap.poll();
			}
			//    		System.out.println(Arrays.toString(heap.toArray()));
		}
		return tmax;
	}

	//-------------------------------------------------------

	/**
	 * 2015/05/24
	 * 使用快排中分区的方式，获得第k大（或者前k大）
	 * Runtime: 356 ms
	 * @param nums
	 * @param k
	 * @return
	 * 
	 */
	public int findKthLargest_partition(int[] nums, int k) {
		
		int start=0;
		int end=nums.length-1;
		
		int index = numPartition(nums, start, end);
//		System.out.println("key="+index+"   "+Arrays.toString(nums));
		
		while(index!=k-1 ){
			if(index>k-1){
				end=index-1;
				index = numPartition(nums, start, end);
			}else{
				start=index+1;
				index = numPartition(nums, start, end);
			}
			
//			System.out.println("key="+index+"   "+Arrays.toString(nums));
		}
		return nums[index];
	}

	/**
	 * 逆序分区
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	int numPartition(int[] nums,int start,int end){
//		int index = (end-start)>>1 +start;
		int key=nums[start];
		int i=start;
		int j=end;
		while(i<j){
			while(j>i && nums[j]<key)
				j--;
			if(i<j){
				nums[i]=nums[j];
				i++;
			}
			
			while(i<j && nums[i]>key)
				i++;
			if(i<j){
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i]=key;
		return i;
	}




	public static void main(String[] args) {
		P215_Kth_Largest_Element_in_an_Array test = new P215_Kth_Largest_Element_in_an_Array();
//		int[] nums = {3,2,1,5,6,4};
		int[] nums={3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};

//		System.out.println(test.numPartition(nums, 0, nums.length-1));
		System.out.println(test.findKthLargest_partition(nums, 20));

	}

}
