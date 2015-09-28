package Practice.HeadToOffice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P30_MinK {

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if( input == null || input.length==0 || input.length<k || k==0)
			return result;

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comparator);

		for(int i=0;i<input.length;i++){
			if(heap.size()<k || input[i]<heap.peek() )
				heap.add(input[i]);
			
			if(heap.size()>k)
				heap.poll();
		}

		for(int i=0;i<k;i++)
			result.add(heap.poll());
		return result;
	}

	Comparator<Integer> comparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	};


	public ArrayList<Integer> GetLeastNumbers_Solution_slow(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if( input == null || input.length==0 || input.length<k)
			return result;

		int start = 0;
		int end = input.length-1;
		int index = partition(input, start, end);

		while(index != k-1){
			if( index > k-1){
				end = index-1;
				index = partition(input, start, end);
			}else{
				start = index+1;
				index = partition(input, start, end);				
			}
		}//while


		for(int i=0;i<k;i++)
			result.add(input[i]);
		return result;
	}


	//	void getMinK(int[] nums , int k){
	//		if( nums == null || nums.length==0 || nums.length<k)
	//			return ;
	//
	//		int start = 0;
	//		int end = nums.length-1;
	//		int index = partition(nums, start, end);
	//
	//		while(index != k-1){
	//			if( index > k-1){
	//				end = index-1;
	//				index = partition(nums, start, end);
	//			}else{
	//				start = index+1;
	//				index = partition(nums, start, end);				
	//			}
	//		}//while
	//
	//		for(int i=0;i<k;i++)
	//			System.out.print( nums[i]+","  );
	//
	//	}

	private int partition(int[] nums , int start , int end){

		//可以优化 桩 的选择策略: 使用 三数中值分割法，将中间值交换到start位置

		int val = nums[start];
		int pos = start;
		int i = start;
		int j = end;

		while( i<j ){
			while( nums[j] > val)
				j--;
			if(i<j){
				nums[pos] = nums[j];
				i++;
				pos=j;
			}
			while( nums[i] < val )
				i++;
			if(i<j){
				nums[pos]=nums[i];
				j--;
				pos=i;
			}
		}//while

		nums[pos] = val;
		return pos;
	}



	public static void main(String[] args) {
		P30_MinK test = new P30_MinK();

		int[] nums = { 4,5,1,6,2,7,3,8 };

		//		test.getMinK(nums, 7);

		ArrayList<Integer> result = test.GetLeastNumbers_Solution(nums, 6);

		System.out.println(Arrays.toString(result.toArray()));

	}

}
