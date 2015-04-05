package com.hard;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/interleaving-string/
 */
public class P97_Interleaving_String {
	/**
	 * 参考
	 * 【DP】
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 * @see https://leetcode.com/discuss/22726/dp-solution-in-java
	 */
	public static boolean isInterleave(String s1, String s2, String s3) {
		if ((s1.length()+s2.length())!=s3.length()) return false;

		boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

		matrix[0][0] = true;

		for (int i = 1; i < matrix[0].length; i++){
			matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1)); //纯s1的情况
		}

		for (int i = 1; i < matrix.length; i++){
			matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1)); //纯s2的情况
		}

		//向右取s1，向下取s2
		for (int i = 1; i < matrix.length; i++){
			for (int j = 1; j < matrix[0].length; j++){
				matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1))) || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
			}
		}

		return matrix[s2.length()][s1.length()];        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
