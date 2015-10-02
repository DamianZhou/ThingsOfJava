package com.medium;

/**
 * 【动态规划】
 * @author Damian
 * @see https://leetcode.com/problems/unique-paths-ii/
 */
public class P063_Unique_Paths_II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null || obstacleGrid[0].length<1)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] matrix = new int[m][n];
		int i,j;
		int value = 1;
		for(i=0;i<m;i++){
			if(obstacleGrid[i][0]==1)
				value=0;
			matrix[i][0]=value;
		}

		value = 1;
		for(j=0;j<n;j++){
			if(obstacleGrid[0][j]==1)
				value = 0;
			matrix[0][j]=value;
		}

		for(i=1;i<m;i++)
			for(j=1;j<n;j++){
				if(obstacleGrid[i][j]==1){
					matrix[i][j] = 0;
				}else
					matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
			}

		return matrix[m-1][n-1];
	}

	public static int uniquePaths(int m, int n) {

		int[][] matrix = new int[m][n];
		int i,j;
		for(i=0;i<m;i++)
			matrix[i][0]=1;
		for(j=0;j<n;j++)
			matrix[0][j]=1;

		for(i=1;i<m;i++)
			for(j=1;j<n;j++)
				matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];


		return matrix[m-1][n-1];
	}
	public static void main(String[] args) {
		P063_Unique_Paths_II test = new P063_Unique_Paths_II();
		
		int[][] obstacleGrid = {
				  {0,0,0},
				  {0,1,0},
				  {0,0,0}
		};
		
		int result = test.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
	}

}
