package DataStructure.Demo;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapDemo {
	
	int[] initHeap(){
		
		
		return null;
	}
	
	/**
	 * 调整新节点到正确的位置
	 * @param heap
	 * @param pos
	 */
	void adjustUpside(int[] heap,int pos){
		int upPos = -1;
		while(pos>0){
			upPos = (pos-1)/2;
			if(heap[upPos]<heap[pos]){
				heap[upPos] = heap[upPos] ^ heap[pos];
				heap[pos] = heap[upPos] ^ heap[pos];
				heap[upPos] = heap[upPos] ^ heap[pos];
				pos=upPos;
			}else
				break;
		}
	}

	public static void main(String[] args) {
		HeapDemo test = new HeapDemo();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(5,8,3,2,1,8,9));
		int[] heap = new int[list.size()];
		
		
	}

}
