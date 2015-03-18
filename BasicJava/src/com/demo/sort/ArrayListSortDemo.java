package com.demo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListSortDemo {
	
	static void ArrayListSort(){
		int num[] = {3, 30, 34, 5, 9};

		List<Integer> listNums = new ArrayList<Integer>();
		
		for(int i=0;i<num.length;i++)
			listNums.add(num[i]);
		
		System.out.println(num.toString());
		
		//Java中对数组排序(参考C++的排序)
		Collections.sort(listNums, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(num.toString());
	}

	public static void main(String[] args) {
		ArrayListSort();
	}

}
