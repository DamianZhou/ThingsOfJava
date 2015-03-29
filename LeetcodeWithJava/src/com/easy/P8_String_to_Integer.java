package com.easy;

/**
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * 
 * 只有第一个正负号有效，后面的全是无效字符！！！！！！！！！
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/string-to-integer-atoi/
 */
public class P8_String_to_Integer {

	/**
	 * 想多了...只有第一个正负号是有效字符，后面的+/-都算无效字符
	 * @param str
	 * @return
	 */
	public static int atoi1(String str) {
		StringBuilder s=new StringBuilder(str.trim());
		if(s.length()==0) 		return 0;	//去除空串

		int flag=0;//正负标志
		Boolean change=false;

		//去除多余的加号 "+-2"
		int index=-1;    	
		// 去除多余字符 "  -0012a42"  == -12
		StringBuilder ans =  new StringBuilder("");
		for(index=0;index<s.length();index++){
			String c=s.substring(index, index+1);
			int a=c.compareTo("0");
			if(a==-3){
				flag -= 1;
				change=true;
			}else if (a==-5){
				flag += 1;
				change=true;
			}else if((a>=0 && a<=9))
				ans.append(c);
			else
				break;
		}

		if(ans.length()==0) return 0;

		if(flag<0)
			flag=-1;
		else if(flag==0 && change==true)
			flag=0;
		else
			flag=1;

		//剔除过大的数
		try{
			return flag*Integer.parseInt(ans.toString());
		}catch(Exception e){
			if(flag==-1)
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}


	}

	//参考---
	public static int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;

		// trim white spaces
		str = str.trim();

		char flag = '+';

		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;

		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == '-')
			result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;
	}

	public static void main(String[] args) {

				String str="+++-+2";
//		String str=  "  ++1";
		System.out.println( atoi(str));
		System.out.println("+".compareTo("0"));



	}

}
