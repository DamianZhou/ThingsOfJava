package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/minimum-path-sum/
 */
public class P64_Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {
    	int width = grid[0].length;
    	int height = grid.length;
    	int i,j;
    	
    	if(grid.length==0)
    		return 0;
    	
    	if(height<2){
    		int result=0;
    		for(i=0;i<width;i++)
    			result+=grid[0][i];
    		return result;
    	}
    	if(width<2){
    		int result=0;
    		for(i=0;i<height;i++)
    			result+=grid[i][0];
    		return result;
    	}
    	
    		
    	
    	int[][] matrix = new int[height][width];
    	matrix[0][0]=grid[0][0];
    	for(i=1;i<width;i++){
    		matrix[0][i]=grid[0][i]+matrix[0][i-1];
    	}
    	for(j=1;j<height;j++)
    		matrix[j][0]+=grid[j][0]+matrix[j-1][0];
    	
    	for(i=1;i<height;i++)
    		for(j=1;j<width;j++)
    			matrix[i][j]=Math.min(matrix[i-1][j], matrix[i][j-1]) +grid[i][j];
    		
    	return matrix[height-1][width-1];    	
    }
	public static void main(String[] args) {
		int[][] num = new int[2][2];
		num[0][0]=1;
		num[0][1]=2;
		num[1][0]=1;
		num[1][1]=1;
		
		System.out.print(minPathSum(num));
		

	}

}
