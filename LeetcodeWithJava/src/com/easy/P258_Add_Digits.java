package com.easy;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/add-digits/
 */
public class P258_Add_Digits {
	
	/**
	 * 求数根
	 * @param num
	 * @return
	 * 计算公式，参见 @see https://en.wikipedia.org/wiki/Digital_root
	 */
	public int addDigits_formula(int num) {
		
		int val  = num - 9*( (num-1)/9 );
		return val;
		
	}
	
	/**
	 * 每个元素贡献的值是一定的，可以部分累计
	 * @param num
	 * @return
	 */
    public int addDigits(int num) {
    	int left = num % 10;
    	num = (num - left) / 10;
    	int result = 0;
    	
    	while(num != 0){
    		result += left;
    		if(result>9)
    			result = result%10 + result/10;
    		left = num % 10;
    		num = (num-left)/10;
    	}
		result += left;
		if(result>9)
			result = result%10 + result/10;
    	return result;
    }

	public static void main(String[] args) {
		P258_Add_Digits test = new P258_Add_Digits();
		int num = 38;
		int result = test.addDigits_formula(num);
		
		System.out.println(result);

	}

}
