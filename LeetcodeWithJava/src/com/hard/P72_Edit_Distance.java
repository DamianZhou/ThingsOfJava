package com.hard;

/**
 * Given two words word1 and word2, 
 * find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:

	a) Insert a character 插入
	b) Delete a character 删除
	c) Replace a character 替换
 * 
 * 最差的情况下，步数是较长字符的长度。
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/edit-distance/
 */
public class P72_Edit_Distance {
	public int minDistance1(String word1, String word2) {

		return 0;
	}

	/*
	 * 参考： 动态规划
	 * In this 2D array dp, dp[i][j] means the operation needed to transform word1(0, i) to word2(0,j).

		There can be three conditions:
		
		1, word1[i] == word2[j] : then no operation needed. dp[i][j] == dp[i-1][j-1]
		
		2, Do one operation on word1[i-1][j]. dp[i][j] = dp[i-1][j] + 1
		
		3, Do one operation on word2[i][j-1]. dp[i][j] = dp[i][j-1] + 1
	 * 
	 */
	public static int minDistance(String word1, String word2) {
		if (word1.equals(word2)) {
			return 0;
		}
		
		if (word1.length() == 0 || word2.length() == 0) {
			return Math.abs(word1.length() - word2.length());
		}
		
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;	// word2 为空的时候
		}
		
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;	// word1 为空的时候
		}
		
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(	
							dp[i-1][j-1], 
							Math.min(dp[i-1][j], dp[i][j-1])
							) + 1;
				}
			}
		}
		
		return dp[word1.length()][word2.length()];
	}  
	
	public static void main(String[] args) {
		String w1="wor5d";
		String w2="world";
/*
          w  o  r  l  d
  [  [0, 1, 2, 3, 4, 5],
w  [1, 0, 1, 2, 3, 4],
o   [2, 1, 0, 1, 2, 3],
r    [3, 2, 1, 0, 1, 2],
5   [4, 3, 2, 1, 1, 2],
d   [5, 4, 3, 2, 2, 1]]
		
*/		
		System.out.println(minDistance(w1,w2));

	}

}
