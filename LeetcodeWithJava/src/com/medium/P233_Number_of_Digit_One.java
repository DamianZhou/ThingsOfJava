package com.medium;

/**
 * 
 * @author zhoucaidong
 * @see https://leetcode.com/problems/number-of-digit-one/
 */
public class P233_Number_of_Digit_One {

	/**
	 * 20150712
	 * 计算 不大于n 的所有十进制数中的 1 的个数
	 * @param n
	 * @return
	 */
    public int countDigitOne(int n) {
    	if(n<=0)
    		return 0;
		return n;
        
    }
    
    int getDigitOneNum(int n){
    	
    	if(n<10){
    		return 1;
    	}else{
    		int leftDigit = n - n % 10;
    	}
    	
    	return 0;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
