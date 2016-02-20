package com.medium;

import java.util.BitSet;
import java.util.LinkedList;

/**
 * @author DamianZhou
 * @see https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class P329_Longest_Increasing_Path_in_a_Matrix {
	
    public int longestIncreasingPath(int[][] matrix) {
		return 0;
        
    }
	
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	/**
	 * https://leetcode.com/discuss/81389/
	 * @param matrix
	 * @return
	 */
    public int longestIncreasingPath_s1(int[][] matrix) {
        if(matrix.length == 0) 
        	return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);//深度优先遍历
                max = Math.max(max, len);
            }
        }   
        return max;
    }

    /**
     * 深度优先遍历
     * https://leetcode.com/discuss/81389/
     * @param matrix
     * @param i
     * @param j
     * @param m
     * @param n
     * @param cache
     * @return
     */
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) 
        	return cache[i][j];//保存所有已经遍历过的结点
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) 
            	continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);//递归获取最大值
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

	public static void main(String[] args) {
		P329_Longest_Increasing_Path_in_a_Matrix test = new P329_Longest_Increasing_Path_in_a_Matrix();
		int[][] matrix = {
				{8,12,4},
				{6,14,8},
				{2,1,1}
		};
		int result = test.longestIncreasingPath(matrix);
		System.out.println(result);

	}

}
