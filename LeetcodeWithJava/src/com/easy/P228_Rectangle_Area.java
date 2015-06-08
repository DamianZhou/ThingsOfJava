package com.easy;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/rectangle-area/
 */
public class P228_Rectangle_Area {
	
	/**
	 * 计算两个矩形的并集
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		
		int r1 = (C-A)*(D-B);
		int r2 = (G-E)*(H-F);
		return r1+r2-computeJoinArea(A, B, C, D, E, F, G, H);
	}

	/**
	 * 计算两个矩形的交集
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 */
    public int computeJoinArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
    	if( A==C || B==D || E==F || F==H )
    		return 0;
    	
    	int x=0,y=0;
    	
    	if( (E>=A && E<=C) || (G>=A && G<=C) ){
    		if( (F>=B && F<=D ) || (H>=B && H<=G )){
    			//确认有交集
    			if(A>E){
    				x = Math.min(G-A, C-A);
    			}else{
    				x = Math.min(G-E, C-E);
    			}
    			
    			if(B>F)
    				y = Math.min(H-B, D-B);
    			else
    				y = Math.min(H-F, D-F);
    			
    			return x*y;
    		}else
    			return 0;
    	}else
    		return 0;
    	
    }
	
	
	public static void main(String[] args) {
		P228_Rectangle_Area test = new P228_Rectangle_Area();
		
//		int result = test.computeArea(-3	, 0, 3, 4, 0, -1, 9, 2);
		
		 int result = test.computeArea(0, 0, 0, 0, -1, -1, 1, 1); //should be 4
		
		System.out.println(result);
	}

}
