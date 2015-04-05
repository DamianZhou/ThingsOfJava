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
			/**
			 * 若返回值小于0，按照 [o1,o2] 排序   o1-o2 升序
			 * 若返回值大于0，按照 [o2,o1] 排序   o2-o1 降序
			 * @param o1
			 * @param o2
			 * @return
			 */
			@Override
			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2);
				return o2-o1;
			}
		});
		
		
		System.out.println(num.toString());
	}

	public static void main(String[] args) {
		ArrayListSort();
	}

}
