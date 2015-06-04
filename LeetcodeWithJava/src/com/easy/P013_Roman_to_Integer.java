package com.easy;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/roman-to-integer/
 */
public class P013_Roman_to_Integer {

	/**
	 * I  1
	 * V 5
	 * X 10
	 * C 100
	 * D 500
	 * M 1000
	 */

	char[] chars = {'M','D','C','L','X','V','I'};

	/**
	 * 2015/06/03
	 * range from 1 to 3999
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		return getNum(s.toUpperCase());
	}

	int getNum(String substr){
		if(substr.length()==0) 
			return 0;

		if(substr.length()==1){
			return charToNum(substr.charAt(0));
		}
		
		int index = -1;
		for(char e : chars){
			index = substr.indexOf(e);
			
			if(index!=-1){
				return charToNum(e) 
						- getNum(substr.substring(0, index)) 
						+ getNum(substr.substring(index+1)) ;
			}			
		}
		return 0;
	}

	int charToNum(char ch){
		switch(ch){
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}

	}

	public static void main(String[] args) {
		P013_Roman_to_Integer test = new P013_Roman_to_Integer();
		
//		String str = "MMMCMXCIX"; //"VII";
		
		//test
		String str = "CCCLXXXIV"; //Output:	1834 		Expected:	1884
		System.out.println(test.romanToInt(str));
	}

}
