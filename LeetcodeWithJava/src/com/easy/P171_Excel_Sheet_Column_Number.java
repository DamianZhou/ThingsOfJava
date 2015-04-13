package com.easy;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/excel-sheet-column-number/
 */
public class P171_Excel_Sheet_Column_Number {
    public static int titleToNumber(String s) {
    	String str = s.toLowerCase();
    	int len = str.length();
    	char c;
    	int i=0,result=0;   	
    	for(i=0;i<len;i++){
    		c=str.charAt(i);
    		result=result*26+(c+1-'a');
    	}
    	return result;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}

}
