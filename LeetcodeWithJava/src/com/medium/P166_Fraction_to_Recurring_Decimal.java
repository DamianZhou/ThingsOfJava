package com.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class P166_Fraction_to_Recurring_Decimal {
	/**
	 * 2015/4/15
	 * @param numerator
	 * @param denominator
	 * @return
	 * 
	 * 1. 没有循环，直接退出
	 * 2. 小数位循环位置
	 * 3. Integer的最小值无法转换成对应的绝对值！需要使用Long来处理！
	 */
    public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return null;
        
        long n1 = numerator;
        long n2 = denominator; 
        
        int flag = n1*n2>0 ? 1:-1;
        n1=Math.abs(n1);
        n2=Math.abs(n2);
        
        Long left = (long) (n1%n2);
        if(left==0)
        	return (n1/n2)*flag+"";
        
        StringBuilder sb = new StringBuilder("");
        
        HashMap<Long,Integer> map = new HashMap<Long,Integer>(); //需要记住余数首次出现的位置
        Long temp=(long) 0;
        int index=0;
        
        //初始 Map 为空
        while(!map.containsKey(left)){
        	map.put(left, index);
        	temp = (long) (left*10/n2); //总是个位数结果,所以直接使用index表示位置即可
            sb.append(temp);
            left = left*10%n2;
            index++;
            if(left==0){
            	//除尽直接退出
            	sb.insert(0, (n1/n2)*flag+".");
            	return sb.toString();
            }
        }
        sb.insert(map.get(left),"(");
        if(flag<0)
        	sb.insert(0, "-"+(n1/n2)+".");   //整数部分可能为0 ，不能使用 乘法！
        else
        	sb.insert(0, (n1/n2)+"."); 
        sb.append(")");
        
        return sb.toString();
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
            hashMap.put(remainder, result.length());	//直接用数组的长度表示 index
            result.append(10 * remainder / den);	//追加不重复部分
            remainder = 10 * remainder % den;
        }
        
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }
    
	public static void main(String[] args) {
//		System.out.println(fractionToDecimal(1, 3));
//		System.out.println(fractionToDecimal(4, 11));
//		System.out.println(fractionToDecimal(54, -13));
//		
//		//犯错测试
//		System.out.println(fractionToDecimal(1,5));		//0.2
//		System.out.println(fractionToDecimal(1,6)); 		//0.1(6)
//		System.out.println(fractionToDecimal(1,99)); 	// 0.(01)
//		System.out.println(fractionToDecimal(7,-12)); 	
		System.out.println(Integer.MAX_VALUE+"     "+Integer.MIN_VALUE);
		System.out.println(fractionToDecimal(-1, -2147483648)); //当涉及Integer的最大最小值，最小值无法转换成绝对值！
	}

}
