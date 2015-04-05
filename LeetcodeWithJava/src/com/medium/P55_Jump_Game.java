package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/jump-game/
 */
public class P55_Jump_Game {

	/**
	 * 从后向前，使用stack存储可能的步骤
	 * @param A
	 * @return
	 */
	public static boolean canJump1(int[] A) {
		return false;   

	}

	/**
	 * 贪心算法
	 * @param A
	 * @return
	 */
	public static boolean canJump(int[] A) {
		int len = A.length;
		if(len<=0) return false;
		int i;
		int maxIndex=A[0];
		for(i=0;i<len;i++){
			if(maxIndex<i)
				return false;
			if(maxIndex>=len-1)
				return true;
			if(maxIndex<A[i]+i)
				maxIndex= A[i]+i; 
		}
		return false;   
	}

	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		int[] B = {3,2,1,0,4};
		int[] C = {0,2,3};
		
		System.out.println(canJump(A));
		System.out.println(canJump(C));
	}

}
