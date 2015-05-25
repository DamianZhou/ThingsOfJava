package Basic.collection.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	
	void minKDemo(){
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(4, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) { 
				return o1-o2; 	//小的在前
			}
		});
		
		int[]	nums = {3,6,8,9,1,4,17,67};
		for(int a : nums){
			heap.add(a);
		}
		
		System.out.println(heap.peek());
		System.out.println(heap.size());
		System.out.println(Arrays.toString(heap.toArray()));
	}

	public static void main(String[] args) {
		PriorityQueueDemo test = new PriorityQueueDemo();
		test.minKDemo();

	}

}
