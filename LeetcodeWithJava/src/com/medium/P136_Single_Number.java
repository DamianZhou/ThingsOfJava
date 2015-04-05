package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/single-number/
 */
public class P136_Single_Number {
    public static int singleNumber(int[] A) {
    	if(A.length<1) return 0;
    	else if(A.length==1) return A[0];
    	
        int t=A[0];
        for(int i=1;i<A.length;i++){
        	t=A[i]^t;
        }
        return t;
    }
	public static void main(String[] args) {
		int[] A={1,1,2,2,3,4,4};
		System.out.println(singleNumber(A));

	}

}
