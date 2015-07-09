package com.easy;

/**
 * 
 * @author zhoucaidong
 * @see https://leetcode.com/problems/power-of-two/
 */
public class P231_Power_of_Two {

	/**
	 * 20150709
	 * @param n
	 * @return
	 */
    public boolean isPowerOfTwo(int n) {
    	if(n<1)
    		return false;
    	else if(n==1)
    		return true;
    	
    	// n>=2
    	n = n & (n-1); //去除二进制中，最后一个1
    	
    	if(n==0)
    		return true;
    	else
    		return false;
    }
    
	public static void main(String[] args) {
		P231_Power_of_Two test = new P231_Power_of_Two();
		
		System.out.println(test.isPowerOfTwo(3));
		System.out.println(test.isPowerOfTwo(4));
		System.out.println(test.isPowerOfTwo(Integer.MAX_VALUE));


	}

}
