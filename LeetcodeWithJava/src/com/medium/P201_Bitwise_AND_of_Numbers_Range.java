package com.medium;

import java.util.ArrayList;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class P201_Bitwise_AND_of_Numbers_Range {
	
	/**
	 * @param m
	 * @param n
	 * @return
	 */
	public static int rangeBitwiseAnd(int m, int n) {
		return n;
		
	}
	
	
	
	/**
	 * Time Limit Exceeded
	 * 
	 * 2014/4/16
	 * @param m
	 * @param n （最大为 2147483647）
	 * @return
	 * 
	 * 边界条件： i = Integer.MAX_VALUE 以后不能再升级
	 */
	public static int rangeBitwiseAnd1(int m, int n) {

		int base = Integer.MAX_VALUE;
		if(n==base) n=n^1; //调整n的大小，不影响结果
		
		for(int i=m;i<=n;i++){
			base = base & i;
			if(base == 0) return 0;
		}
		return base;
	}
	
	/**
	 * the result of a range bitwise is the common 'left header' of m and n.
	 * @param m
	 * @param n
	 * @return
	 * @see https://leetcode.com/discuss/32053/accepted-c-solution-with-simple-explanation
	 */
	public static int rangeBitwiseAnd_ref(int m, int n) {
	    int c=0;
	    while(m!=n){
	        m>>=1;
	        n>>=1;
	        ++c;
	    }
	    return n<<c;
	}
	public static void main(String[] args) {
		int result = rangeBitwiseAnd_ref(2147483647,Integer.MAX_VALUE);
		System.out.println(result);
		
//		System.out.println(Integer.MAX_VALUE-1 & Integer.MAX_VALUE);

	}

}
