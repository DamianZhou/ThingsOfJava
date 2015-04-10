package com.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 * 
 * @author DamianZhou 2015/4/10
 * @see https://leetcode.com/problems/largest-number/
 */
public class P179_Largest_Number_redo {
    public static String largestNumber(int[] num) {
    	if(num.length<1) return "";
    	
    	ArrayList<String> array = new ArrayList<String>();
    	
    	for(int i=0;i<num.length;i++){
    		array.add(Integer.toString(num[i]));
    	}
    	
    	Collections.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//直接比较两个字符串拼接后的效果
				String s1=o1+o2;
				String s2=o2+o1;
				return s2.compareTo(s1);//降序
			}
		});

    	StringBuilder sb = new StringBuilder("");
    	for(int i=0;i<array.size();i++){
    		sb.append(array.get(i));
    	}
    	
    	//去除多余的0
    	int i=0;
    	while(i<sb.length()){
    		if(sb.charAt(i)!='0')
    			return sb.substring(i);
    		else
    			i++;
    	}

    	return "0";  
		
    }
	public static void main(String[] args) {
		int[] num = {3, 30, 34, 5, 9};		// return 9534330
		int[] num1= {0,0};
		System.out.println(largestNumber(num1));
	}

}
