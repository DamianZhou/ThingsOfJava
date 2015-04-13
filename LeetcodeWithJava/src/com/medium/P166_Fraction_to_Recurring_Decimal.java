package com.medium;

import java.util.HashMap;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class P166_Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        
    	return "";
    }
    
    /**
     * 
     * @param numerator
     * @param denominator
     * @return
     * @see https://leetcode.com/discuss/31521/short-java-solution
     */
    public String fractionToDecimal_ref(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        
        long remainder = num % den;	//取余数
        if (remainder == 0)
            return result.toString();
        
        result.append(".");
        
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        
        while (!hashMap.containsKey(remainder)) {	
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);	//追加不重复部分
            remainder = 10 * remainder % den;
        }
        
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
