package com.medium;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/sqrtx/
 * @see 牛顿迭代参考 http://my.oschina.net/zengsai/blog/4213
 */
public class P69_Sqrt_x {

	public static int sqrt(int x) {

		if(x<0)
			return -1;
		else if(x<2)
			return x;
		
		int oldPos=x;
		int a=x;
		int newPos=x>>>1;//针对 x>2 的情况,此时，x^2/2 比 x^(1/2)大
		
		//从右向左逼近，如果新的点在旧的点右边，表示旧的点已经是最优的了。
		while(newPos<oldPos){
			oldPos=newPos;
			newPos=(oldPos+a/oldPos)/2;			
		}
		
		return oldPos;
	}

	//参考------------------------------------------------------------------------------------------------------------------------------


	/**
	 *  牛顿迭代法（Newton's method）
	 * @param y
	 * @return
	 */
	private static int sqrt1(int y){
		int oldPos=y>>1;
		int newPos=0;

		while ( oldPos!=0 ){
			newPos=(oldPos+y/oldPos)/2;
			
			System.out.println("newPos="+newPos);

			if (newPos>=oldPos)
				return oldPos;

			oldPos=newPos;
		}
		return oldPos;
	}

	/**
	 * Java solution based on Newton's method without float
	 * 牛顿迭代法（Newton's method）
	 * 
	 * 
	 * @param y
	 * @return
	 */
	public int sqrt2(int y) {

		//initial guess
		long x = y >> 1;

		//see explanations below.
		for (long dy; (dy = x * x - y) > 0; x -= (dy - 1) / (x << 1) + 1);

		//x must be ⌊√y⌋ here, except when y == 1
		return y == 1 ? 1 : (int)x;

		/*
		 This code is reduced based on the fact that stopping the iteration at the first x*x<=y is OK, if y==0 or y>=2.

		To understand this, there are only two cases to be considered:

		When y>=6, the initial guessed root, which is half of y, must be greater than the actual root. And the guessed root will keep decreasing during the iteration.

		When y is in {0,2,3,4,5}, the initial guessed x is exactly ⌊√y⌋. That is, no iteration at all.

		P.S. (dy-1)/(x<<1)+1 is the ceiling of dy/(x<<1), to prevent zero that causes endless loop.
		 */

	}

	public static void main(String[] args) {
		System.out.println(sqrt(49));
	}

}
