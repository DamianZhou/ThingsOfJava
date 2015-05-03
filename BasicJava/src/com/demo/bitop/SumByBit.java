package com.demo.bitop;

/**
 * 参考剑指offer 47：不使用“+”实现加法运算
 * @author Damian
 *
 */
public class SumByBit {

	/**
	 * 1. 使用 异或 求得五进位的二进制和
	 * 2. 使用 与     求得进制
	 * 3. 对两个新值进行新的 “加运算”，知道进位为0
	 * @param a 非负整数
	 * @param b 非负整数
	 * @return
	 */
	private static int getSum(int a,int b){
				System.out.println(Integer.toBinaryString(a));
				System.out.println(Integer.toBinaryString(b));

		int tSum = a^b;
		int carry = (a&b)<<1;

		while(carry!=0){

						System.out.println(Integer.toBinaryString(tSum));
						System.out.println(Integer.toBinaryString(carry));

			tSum = tSum^carry;
			carry = (tSum&carry)<<1;
		}

		return tSum;
	}

	public static void main(String[] args) {
//		System.out.println( getSum(5, 10) );
		System.out.println( getSum(-1, -17) );
		
//		System.out.println(Integer.MAX_VALUE);

	}

}
