package com.easy;

/**
 * @author Damian
 * @see https://leetcode.com/problems/climbing-stairs/
 */
public class P070_Climbing_Stairs {
	
	
    public int climbStairs(int n) {
        if(n<1)
       	 return 0;
        else if(n==1)
       	 return 1;
        else if(n==2)
       	 return 2;

        int sub1 = 1;
        int sub2 = 2;
        int result = -1;
        int target = 3;
        while(target<=n){
        	result = sub1+sub2;
        	sub1 = sub2;
        	sub2 = result;
        	target++;
        }
        return result;
        
       }
	
	
	/**
	 * 直接使用递归 Time Limit Exceeded
	 * @param n
	 * @return
	 */
    public int climbStairs_TLE(int n) {
     if(n<1)
    	 return 0;
     else if(n==1)
    	 return 1;
     else if(n==2)
    	 return 2;
     else
    	 return climbStairs(n-1) + climbStairs(n-2);
    }
	public static void main(String[] args) {
		P070_Climbing_Stairs test = new P070_Climbing_Stairs();
		int result = test.climbStairs(4);
		System.out.println(result);
	}

}
