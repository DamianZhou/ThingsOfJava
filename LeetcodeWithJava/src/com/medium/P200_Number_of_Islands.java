package com.medium;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/number-of-islands/
 */
public class P200_Number_of_Islands {
    public static int numIslands(char[][] grid) {
    	int count=0;
		// m*n
    	int m=grid.length;
    	if(m==0) return 0;
		int n=grid[0].length;
		if(n==0) return 0;
    	
		int i,j;
		for(i=0;i<m;i++)
			for(j=0;j<n;j++){
				if(grid[i][j]=='1'){
					count++;
					affectArea(grid, i, j);
				}
			}
		return count;
    }
    
    /**
     * 感染周围的区域，不计算在内
     * @param grid
     * @param i
     * @param j
     */
    public static void affectArea(char[][] grid,int i,int j){
    	if(i<grid.length && i>=0 && j<grid[0].length && j>=0){
    		if(grid[i][j]=='1'){
    			grid[i][j]='0';
    			affectArea(grid, i+1, j);
    			affectArea(grid, i-1, j);
    			affectArea(grid, i, j+1);
    			affectArea(grid, i, j-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		char[][] grid={
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}	
		};
		
		char[][] grid1={
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}	
		};
		
		System.out.println(numIslands(grid));
		System.out.println(numIslands(grid1));

	}

}
