package com.medium;

import java.util.BitSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/game-of-life/
 */
public class P289_Game_of_Life {

    public void gameOfLife(int[][] board) {
    	int height = board.length-1;
    	if(height<0) return;
    	int width = board[0].length-1;
    	if(width<0) return;
    	
    	BitSet oldLineState = new BitSet(width+1);
    	BitSet LineState = new BitSet(width+1);
    	
    	//save the first line's next state
    	for(int i=0;i<=width;i++){
    		boolean result = subIsLive(board, height, width, 0, i, board[0][i]);
    		if(result)
    			oldLineState.set(i);
    	}
    	
    	for(int i=1;i<=height;i++){
    		for(int j=0;j<=width;j++){
        		boolean result = subIsLive(board, height, width, i, j, board[i][j]);
        		if(result)
        			LineState.set(j);
    		}
    		
    		for(int j=0;j<=width;j++){
    			board[i-1][j] = oldLineState.get(j) == true ? 1:0;
    		}
    		//交换前后标记
    		BitSet temp = oldLineState;
    		oldLineState = LineState;
    		LineState = temp;
    		LineState.clear(0, LineState.length());
    	}
    	
		for(int j=0;j<=width;j++){
			board[height][j] = oldLineState.get(j) == true ? 1:0;
		}
    	
    }
    /**
     * 获取四周八个位置的存活细胞数量
     * @param board
     * @param height
     * @param width
     * @param m
     * @param n
     * @return
     */
    public int subGetNeighbourNum(int[][] board,int height,int width,int m,int n){
    	int count = 0;
    	
    	int pm = m-1;
    	int pn = n-1;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	pn += 1 ;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	pn += 1 ;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	
    	pm = m;
    	pn = n-1;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	pn += 2 ;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	
    	pm = m+1;
    	pn = n-1;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	pn += 1 ;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	pn += 1 ;
    	if(pm>=0 && pn>=0 && pm<=height && pn<=width)
    		count+=board[pm][pn];
    	
    	return count;
    }
    /**
     * 判断当前细胞在下一轮是否可以存活
     * @param board
     * @param height
     * @param width
     * @param m
     * @param n
     * @param currentState
     * @return
     */
    public boolean subIsLive(int[][] board,int height,int width,int m,int n,int currentState){
    	int count = subGetNeighbourNum(board, height, width, m, n);
    	if(currentState==1){
    		if(count==2 || count==3)
    			return true;
    	}else{
    		if(count==3)
    			return true;
    	}
    	return false;
    }
	
	public static void main(String[] args) {
		P289_Game_of_Life test = new P289_Game_of_Life();
		int[][] board = {
			    {1,0,1,0,1,0},
			    {0,1,0,1,0,1},
			    {1,0,1,0,1,0},
			    {0,1,0,1,0,1}
			};
		
		test.gameOfLife(board);
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++)
				System.out.print(board[i][j]+",");
			System.out.println();
		}

	}

}
