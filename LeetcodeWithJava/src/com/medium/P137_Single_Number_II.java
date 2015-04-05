package com.medium;

import java.util.HashMap;
import java.util.Iterator;


/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/single-number/
 */
public class P137_Single_Number_II {
	/**
	 * Accepted
	 * @param A
	 * @return
	 */
	public static int singleNumber(int[] A) {
		if(A.length<1) return 0;
		else if(A.length==1) return A[0];

		int temp;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int i;
		for(i=0;i<A.length;i++){
			temp = A[i];
			if(map.containsKey(temp))
				map.put(temp, map.get(temp)+1);
			else
				map.put(temp, 1);
		}
		Iterator<Integer> it =map.keySet().iterator(); 
		while(it.hasNext()){
			temp=it.next();
			if(map.get(temp)==1){
				return temp;
			}
		}
		return 0;

	}
	
	/**
	 * 使用位运算
	 * Integer是32位的，针对每一位，求和，然后对3求余，剩下的即是single number
	 * @param A
	 * @return
	 * @see http://www.acmerblog.com/leetcode-single-number-ii-5394.html
	 */
	public static int singleNumber1(int A[]) {
	    int[] count = new int[32];
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        for (int j = 0; j < A.length; j++) {
	            if (((A[j] >> i) & 1)==1) { 			//右移i位,当前位
	                count[i]++;
	            }
	        }
	        result |= ((count[i] % 3) << i);		//左移i位，添加到指定位置
	    }
	    return result;
	}
	
	/**
	 * 使用掩码变量
	 * ones   代表第ith 位只出现一次的掩码变量
		twos  代表第ith 位只出现两次次的掩码变量
		threes  代表第ith 位只出现三次的掩码变量
	 * @param A
	 * @param n
	 * @return
	 */
	static int singleNumber2(int A[]) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	    	//对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
	        twos |= ones & A[i];
	        ones ^= A[i];		// 异或3次 和 异或 1次的结果是一样的

	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	
	public static void main(String[] args) {
		int[] A={1,1,1,2,2,3,4,4,4,2};
		System.out.println(singleNumber2(A));

	}

}
