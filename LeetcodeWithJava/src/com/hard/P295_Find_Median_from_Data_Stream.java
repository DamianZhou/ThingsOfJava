package com.hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P295_Find_Median_from_Data_Stream {
	
	PriorityQueue<Integer> heapLeft = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	}); //大顶堆
	PriorityQueue<Integer> heapRight = new PriorityQueue<Integer>(); //小顶堆

	int allcount = 0;
	int leftcount = 0;

    // Adds a number into the data structure.
    public void addNum(int num) {
        heapRight.add(num);
        allcount++;
        if( leftcount < ((allcount-1)/2)){
        	heapLeft.add( heapRight.poll() );
        	leftcount++;
        }
        balanceHeap();
    }
    
    // Returns the median of current data stream
    public double findMedian() {
    	if( (allcount&1) == 1)
    		return heapRight.peek();
    	else{
    		int t = heapRight.poll();
    		double result = (double)(heapRight.peek() + t)/2;
    		heapRight.add(t);
    		return result;
    	}       
    }
    
    public void balanceHeap(){
    	if(heapLeft.size() == 0)
    		return;
    	int left = heapLeft.peek();
    	int right = heapRight.peek();
    	
    	while(left>right){
    		heapLeft.poll();
    		heapRight.poll();
    		heapLeft.add(right);
    		heapRight.add(left);
    		
    		left = heapLeft.peek();
        	right = heapRight.peek();
    	}
    }
	


	public static void main(String[] args) {
		P295_Find_Median_from_Data_Stream test = new P295_Find_Median_from_Data_Stream();
		
		
//		test.addNum(6);
//		test.addNum(10);
//		test.addNum(2);
//		test.addNum(6);
//		test.addNum(5);
//		test.addNum(0);
//		test.addNum(6);
//		test.addNum(3);
//		test.addNum(1);
//		test.addNum(0);
//		test.addNum(0);
		
		double result;
		test.addNum(2);
		result = test.findMedian();
		System.out.println(result);
		test.addNum(3);
		result = test.findMedian();
		System.out.println(result);
	}

}
