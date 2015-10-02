package com.medium;

import java.util.Arrays;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/perfect-squares/
 */
public class P279_Perfect_Squares {

	public int numSquares(int n) {
		int temp = n;
		int t = (int) Math.sqrt(temp);
		int left = temp - t*t;
		int count = 0;


		return n;

	}

	/**
	 * @param n
	 * @return
	 * @see https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics
	 */
	public int numSquares_ref(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		// dp[i] = the least number of perfect square numbers which sum to i. 
		// Note that dp[0] is 0.
		for (int i = 0; i <= n; i++) {
			
			// For each i, it must be the sum of some number (i - j*j) and a perfect square number (j*j).
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1); //比 dp[i - j * j]  多一次
			}
			System.out.println( Arrays.toString(dp) );
		}
		return dp[n];
	}

	public static void main(String[] args) {
		P279_Perfect_Squares test = new P279_Perfect_Squares();
		int result = test.numSquares_ref(9);
		System.out.println(result);
	}

}
