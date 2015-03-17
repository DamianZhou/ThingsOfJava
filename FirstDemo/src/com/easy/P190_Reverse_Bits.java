package com.easy;

import com.common.CommonComponents;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as 00000010,10010100,00011110,10011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/reverse-bits/
 */
public class P190_Reverse_Bits {

	public static void main(String[] args) {

		int num=43261596;
		int ans=reverseBits(num);

		System.out.println(num+ " " + CommonComponents.IntToBinaryString(num) );
		System.out.println( ans+ " " +CommonComponents.IntToBinaryString( ans ));
	}

	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int num=0;
		int count=32;

		while (count>0){
			num=num<<1;
			if((n&1)==1)	num+=1;
			n=n>>>1;
			count--;
		}
		return num;
	}

}
