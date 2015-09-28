package com.Basic.Algorithm;

public class Graph_MinPath {
	
	/**
	 * 最短路径 —— floyd方法
	 * @param 结点数 n
	 * @param 结点路径方阵 dist
	 */
	void floyd(int n , int[][] dist)	{
	   
		for(int k = 0; k < n; k ++){  //作为循环中间点的k必须放在最外一层循环 
	       
			for(int i = 0; i < n; i ++){
	            for(int j = 0; j < n; j ++){
	                if( dist[i][j]>=0 &&  dist[i][k]>=0 && dist[k][j]>=0 && dist[i][j] > dist[i][k] + dist[k][j]){
	                    dist[i][j] = dist[i][k] + dist[k][j];    //dist[i][j]得出的是i到j的最短路径 
	                }     
	            }    
	        }    
			
	    }    
		
		for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
            	System.out.print(String.format("%4d", dist[i][j]));
            }
            System.out.println();
		}
		
	}
	
	void testFloyd(){
		int n = 7;
		
		int[][] dist ={
				{0 , -1 , 5 , 7 , -1 , -1 , -1 },
				{-1 , 0 , -1 , -1 , 12 , -1 , -1 },
				{5 , -1 , 0 , -1 , 4 , -1 , -1 },
				{7 , -1 , -1 , 0 , -1 , 12 , -1 },
				{-1 , 12 , 4 , -1 , 0 , -1 , -1 },
				{-1 , -1 , -1 , 12 , -1 , 0 , 2 },
				{-1 , -1 , -1 , -1 , -1 , 2 , 0 }
		};
		
		floyd(n, dist);
	}
	

	public static void main(String[] args) {
		Graph_MinPath test = new Graph_MinPath();
		
		test.testFloyd();
		
		
		
	}

}
