package com.easy;
/**
 * @author zhoucaidong
 * @see https://leetcode.com/problems/power-of-four/
 */
public class P342_Power_of_Four {

	/**
	 * 使用二进制的方式
	 * @param num
	 * @return
	 */
	public boolean isPowerOfFour(int num) {
		if(num<1)
			return false;
		while( num>3 && ((num>>2)<<2)==num){
			num=num>>2;
		}
		if(num==1)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		P342_Power_of_Four test = new P342_Power_of_Four();
		System.out.println(test.isPowerOfFour(516));
	}

}
