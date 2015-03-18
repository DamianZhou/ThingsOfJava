package com.easy;

import com.common.CommonComponents;

/**
 * Write a function that takes an unsigned integer and 
 * returns the number of  '1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3.
 * 
 * 找出二进制表示的数值中，1的个数
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/number-of-1-bits/
 *
 */
public class P191_Number_of_1_Bits {

	public static void main(String[] args) {

		int num=2147483647; //2147483647+1超出Java中的 int
		
		System.out.println( CommonComponents.IntToBinaryString(num) );
		
		System.out.println(hammingWeight(num));
		System.out.println(ANS_hammingWeight(num));
	}
	
   
	/**
	 * 常规的解法，
	 * 在Java中int默认第一个为符号位，2147483648无法通过
	 * 
	 *  you need to treat n as an unsigned value
	 * @param n
	 * @return
	 */
    public static int hammingWeight(int n) {
    	int count=0;
    	int left=0;
    	while(n>1){
    		left = n%2;
    		if (left==1) count++;
    		n=(n-left)/2;
    	}
        if (n==1) count++;
    	
    	return count;
    }
    
    /**
     * 使用位运算 比较末尾值并移位
     * @param n
     * @return
     */
    public static int ANS_hammingWeight(int n) {
    	   int count = 0;
    	   while(n != 0){
    	       if((n & 1) == 1){
    	           count++;
    	       }
    	       n = n >>> 1; //右移一位，使用0补充
    	   }
    	   return count;
    	}
    
}
