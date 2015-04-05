package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/powx-n/
 */
public class P50_Pow {
	/**
	 * Last executed input:	0.00001, 2147483647
	 * 时间复杂度 O(n)
	 * @param x
	 * @param n
	 * @return
	 */
	public static double pow1(double x, int n) {
		double result=x;
		if(n==0 || x==0) return 1;
		boolean flag=false;

		if(n<0){
			flag=true;
			n=-n;
		}

		while(n>1){
			result*=x;
			n--;
		}
		if(flag)
			return 1/result;
		else
			return result;
	}
	
	/**
	 * 递归
	 * @param x
	 * @param n
	 * @return
	 * @see https://leetcode.com/discuss/27692/share-my-clean-recursive-solution
	 */
    public static double pow(double x, int n) {
        return n > 0 ? power(x, n) : 1 / power(x, -n);
    }
    /**
     * 时间复杂度 O(logn)
     * @param x
     * @param n
     * @return
     */
    static double power(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1.0;
        double tmp = power(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.pow(0.00001, 2147483647));
		System.out.print(pow(0.00001, 2147483647));
	}

}
