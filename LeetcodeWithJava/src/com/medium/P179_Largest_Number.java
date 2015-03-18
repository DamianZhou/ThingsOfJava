package com.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Damian:每个数字按照最后一位扩充，就得到该数字的最大可能的值
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/largest-number/
 */
public class P179_Largest_Number {

	//参考---------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * 比较两个数的“作用”大小
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int compareString(String s1, String s2){
		String tmp1 = s1 + s2;
		String tmp2 = s2 + s1;
		if(tmp1.compareTo(tmp2) > 0){
			return -1;
		}else if(tmp1.compareTo(tmp2) < 0){
			return 1;
		}
		return 0;

	}

	public static String largestNumber(int[] num) {

		List<String> listNums = new ArrayList<String>();

		for(int i = 0; i < num.length; ++i){
			listNums.add(Integer.toString(num[i]));
		}
		
		//Java中对数组排序(参考C++的排序)
		Collections.sort(listNums, new Comparator<Object>(){
			public int compare(Object s1, Object s2){
				return compareString((String)s1, (String)s2);
			}
		});

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < listNums.size();++i){    
			sb.append(listNums.get(i));
		}
		
		for(int i = 0;i < sb.length();++i){
			if(sb.charAt(i) != '0'){
				return sb.substring(i);	//去除可能的0
			}
		}
		
		return "0";
	}


	//误解---------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 错误！
	 * 拆成个位数比较
	 * 
	 * @param num
	 * @return
	 */
	@Deprecated
	public static String largestNumber1(int[] num) {
		String[] str= new String[10];
		int t,i; 

		for(i=0;i<str.length;i++)
			str[i]="";

		for(i=0;i<num.length;i++){
			int tnum=num[i];
			while(tnum>9){
				t=tnum%10;
				str[t]=str[t]+t;
				tnum=(tnum-t)/10;
			}
			str[tnum]=str[tnum]+tnum;
		}

		String ans="";
		for(i=0;i<10;i++){
			if (str[i]!=null)
				ans=str[i]+ans;
		}

		return ans;

	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
		int num[] = {3, 30, 34, 5, 9};
		System.out.print(largestNumber(num));
	}

}
