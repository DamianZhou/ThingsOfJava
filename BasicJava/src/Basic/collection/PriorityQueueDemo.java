package Basic.collection;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	void checkHeap(int c,char d){
		
	}
	void checkHeap(int a,int b){
		int size = 20;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(50);
		
		ArrayList<Integer> list = new ArrayList<Integer>(50);
		list.trimToSize();//调整ArrayList的大小到当前size (确保不再调整后调用)
		list.ensureCapacity(size); //最小的初始容量
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
