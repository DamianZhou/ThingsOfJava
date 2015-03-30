package com.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 【动态规划】
 * @author Damian
 * @see https://leetcode.com/problems/word-break/
 */
public class P139_Word_Break_review {
    public static boolean wordBreak(String s, Set<String> dict) {
    	
    	boolean[] flagList = new boolean[s.length()+1]; //记录有效的位置
    	
    	flagList[0]=true;
    	
    	int i,j;
    	String t;
    	for(i=1;i<=s.length();i++){
    		for(j=i;j<=s.length();j++){
    			t=s.substring(i-1, j);//注意截取字符串的位置
    			if(flagList[i-1] && dict.contains( s.substring(i-1, j))){
    				flagList[j]=true;
    				if(j==s.length()) 
    					return true;
    			}
    		}
    	}
    	
		return false;
        
    }
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("hello");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("a");
		
		String s = "aahelloa";
		
		boolean ans = wordBreak(s, dict);
		if(ans)
			System.out.println("OK");
		else
			System.out.println("NO");

	}

}
