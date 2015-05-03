package com.medium;

import java.util.BitSet;

/**
 * prime numbers 素数
 * @author DamianZhou
 * @see https://leetcode.com/problems/count-primes/
 */
public class P204_Count_Primes {

	/**
	 * 2015/04/30  找出小于n的所有质数
	 * @param 非负整数n 
	 * @return
	 * 
	 * int 最大的正整数 2147483647, 此处未考虑最大值
	 * For a bit set with a single set bit at position 100,000,000 it means allocation of about 12.5M memory.
	 */
	public int countPrimes(int n) {
		if(n<2) return 0;

		BitSet bs = new BitSet(n+1);
		int t = (int) Math.sqrt(1.0*n);
		bs.set(1);
		int k=1;
		for(int i=2;i<=t;i++){
			if( bs.get(i)) continue; //已经标注过就忽略
			for(k=2;k*i<=n;k++) 
				bs.set(k*i);
		}

		return bs.get(n)? n-bs.cardinality() : n-bs.cardinality()-1; //不包括自己
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println(Integer.MAX_VALUE);

		//----------------出错案例

		//		Input:	10000
		//		Output:	3334
		//		Expected:	1229
		
		//取极限值 bitset 报错：
		//Exception in thread "main" java.lang.IndexOutOfBoundsException: bitIndex < 0: -2147483648

		//---------------

		P204_Count_Primes test = new P204_Count_Primes();
		System.out.println(test.countPrimes(214748364));

	}

}
