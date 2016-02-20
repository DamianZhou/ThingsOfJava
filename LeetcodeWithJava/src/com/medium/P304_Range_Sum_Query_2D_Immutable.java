package com.medium;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class P304_Range_Sum_Query_2D_Immutable {

	public static void main(String[] args) {
		int matrix[][] = {
				  {3, 0, 1, 4, 2},
				  {5, 6, 3, 2, 1},
				  {1, 2, 0, 1, 5},
				  {4, 1, 0, 1, 7},
				  {1, 0, 3, 0, 5}
				};
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(		numMatrix.sumRegion(0, 1, 2, 3));
		System.out.println(     numMatrix.sumRegion(1, 2, 3, 4));
	}

}




//Your NumMatrix object will be instantiated and called as such:
//NumMatrix numMatrix = new NumMatrix(matrix);
//numMatrix.sumRegion(0, 1, 2, 3);
//numMatrix.sumRegion(1, 2, 3, 4);
class NumMatrix {
	int[][] tempSum;
    public NumMatrix(int[][] matrix) {
    	if(matrix==null || matrix.length==0 || matrix[0].length==0)
    		return ;
    	int m=matrix.length;
    	int n=matrix[0].length;
        tempSum = new int[m][n+1];
        for(int i=0;i<m;i++){
        	tempSum[i][0]=0;
        	int sum=0;
        	for(int j=0;j<n;j++){
        		sum+=matrix[i][j];
        		tempSum[i][j+1]=sum;
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int sum=0;
    	for(int i=row1;i<=row2;i++){
    		sum+=(tempSum[i][col2+1]-tempSum[i][col1]);
    	}
		return sum;
        
    }
}
