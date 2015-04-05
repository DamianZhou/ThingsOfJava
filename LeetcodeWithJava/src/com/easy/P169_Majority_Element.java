package com.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/majority-element/
 */
public class P169_Majority_Element {
	public static int majorityElement(int[] num) {
		if(num.length==0) return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int val;
		for(int i=0;i<num.length;i++){
			if(map.containsKey(num[i])){
				val=map.get(num[i])+1;
				map.put(num[i], val);
			}
			else
				map.put(num[i], 1);
		}
		Integer[] array=(Integer[]) map.keySet().toArray();
		int len = num.length>>2;
		for(int i=0;i<array.length;i++)
			if(map.get(array[i])>len)
				return array[i];

		return 0;
	}
	
	/**
	 * 
	 * @param num
	 * @param n
	 * @return
	 * @see https://leetcode.com/discuss/29148/my-c-solution-10ms
	 * 相互消耗，最后保留个数最多的。
	 */
	int majorityElement1(int num[]) {
	    int cnt = 0, res = 0;
	    int n=num.length;
	    for (int i = 0; i < n; ++i) {
	        if (cnt == 0) res = num[i];//消耗掉之前的数字，保留最新值
	        if (res == num[i]) 
	        	++cnt;
	        else 
	        	--cnt;
	    }
	    return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
