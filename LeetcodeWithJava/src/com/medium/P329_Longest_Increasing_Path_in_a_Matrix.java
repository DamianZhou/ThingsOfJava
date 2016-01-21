package com.medium;

import java.util.BitSet;

/**
 * To be continue...
 * @author DamianZhou
 * @see https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class P329_Longest_Increasing_Path_in_a_Matrix {

	public int longestIncreasingPath(int[][] matrix) {
		if(matrix==null)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		BitSet flagBit = new BitSet(m*n);

		int maxlen = 0;
		int i,j;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				flagBit.clear();
				flagBit.set(i*n+j); //设置起始位置
				int len = getInfect(matrix, flagBit, m, n, i, j, 1);
				maxlen=Math.max(maxlen, len);
			}
		}

		return maxlen;

	}

	int getInfect(int[][] matrix,BitSet flagBit,int m,int n,int i,int j,int tlen){

		int left=tlen,right=tlen,up=tlen,down=tlen;

		if(i>0 && !checkUsed(flagBit,n,i-1,j) && matrix[i-1][j]>matrix[i][j]){
			flagBit.set((i-1)*n+j); 
			up = getInfect(matrix, (BitSet)flagBit.clone(),m,n,i-1,j, tlen+1);
			flagBit.clear((i-1)*+j);
		}

		if(i<m-1 && !checkUsed(flagBit,n,i+1,j) && matrix[i+1][j]>matrix[i][j]){
			flagBit.set((i+1)*n+j); 
			down = getInfect(matrix, (BitSet)flagBit.clone(),m,n,i+1,j, tlen+1);
			flagBit.clear((i+1)*+j);
		}

		if(j>0 && !checkUsed(flagBit,n,i,j-1) && matrix[i][j-1]>matrix[i][j]){
			flagBit.set(i*n+j-1); 
			left = getInfect(matrix, (BitSet)flagBit.clone(),m,n,i,j-1, tlen+1);
			flagBit.clear(i*n+j-1);
		}

		if(j<n-1 && !checkUsed(flagBit,n,i,j+1) && matrix[i][j+1]>matrix[i][j]){
			flagBit.set(i*n+j+1); 
			left = getInfect(matrix, (BitSet)flagBit.clone(),m,n,i,j+1, tlen+1);
			flagBit.clear(i*n+j+1);
		}

		return Math.max(Math.max(up,down), Math.max(left, right));
	}

	boolean checkUsed(BitSet flagBit,int n,int i,int j){
		return flagBit.get(i*n+j);
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
