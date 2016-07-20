package com.easy;
/**
 * 
 * @author hzzhoucaidong
 * @see https://leetcode.com/problems/sum-of-two-integers/
 */
public class P371_Sum_of_Two_Integers {

	/**
	 * һ�������㣬�õ���ǰλ��ֵ
	 * һ������㣬��������һλ���õ���λ��Ϣ
	 * @param a
	 * @param b
	 * @return
	 * @see http://www.cnblogs.com/kiven-code/archive/2012/09/15/2686922.html
	 */
	public int getSum(int a, int b) {
		int sum = a;
		int carry = b;

		while(carry!=0){
			int tmps = sum;
			sum = tmps ^ carry;
			carry = (tmps & carry) << 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		P371_Sum_of_Two_Integers test = new P371_Sum_of_Two_Integers();
		
		int result = test.getSum(12, 12);
		
		System.out.println(result);
	}

}
