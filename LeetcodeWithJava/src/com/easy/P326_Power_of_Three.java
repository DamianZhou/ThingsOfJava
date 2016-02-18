package com.easy;
/**
 * 
 * @author Administrator
 * @see https://leetcode.com/problems/power-of-three/
 */
public class P326_Power_of_Three {
	
    public boolean isPowerOfThree(int n) {
     
    	if(n==3 || n==1)
    		return true;
    	else if(n<3 || n%3!=0)
    		return false;
    	else
    		return isPowerOfThree(n/3);
    }
    
    /**
     * https://leetcode.com/discuss/78532
     * 将n转换为3进制，判断是否完全转换
     * @param n
     * @return
     */
    public boolean isPowerOfThree_s1(int n) {
        return Integer.toString(n, 3).matches("10*");
    }

	public static void main(String[] args) {
		P326_Power_of_Three test = new P326_Power_of_Three();
		
		boolean result = test.isPowerOfThree_s1(81);
		System.out.println(result);

	}

}
