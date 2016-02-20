package com.medium;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/ugly-number-ii/
 */
public class P264_Ugly_Number_II {

	/**
	 * 20150824 To be done
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		int[] uglyList = new int[n+1];
		uglyList[1]=1;
		int index = 1;
		LinkedList<Integer> queue2 = new LinkedList<Integer>();
		LinkedList<Integer> queue3 = new LinkedList<Integer>();
		LinkedList<Integer> queue5 = new LinkedList<Integer>();
		while(index<n){    		
			queue2.add(uglyList[index]*2);
			queue3.add(uglyList[index]*3);
			queue5.add(uglyList[index]*5);
			if(queue2.peek()==uglyList[index])
				queue2.poll();
			if(queue3.peek()==uglyList[index])
				queue3.poll();
			if(queue5.peek()==uglyList[index])
				queue5.poll();
			
			int a = queue2.peek();
			int b = queue3.peek();
			int c = queue5.peek();
			
			int min = Math.min(Math.min(a,b),c);			
			uglyList[++index]=min;
			
			if(min==a){
				queue2.poll();
			}else if(min==b){
				queue3.poll();
			}else
				queue5.poll();
		}

		return uglyList[n];

	}


	public static void main(String[] args) {
		P264_Ugly_Number_II test = new P264_Ugly_Number_II();
		int result = test.nthUglyNumber(1);
		System.out.println(result);
	}

}
