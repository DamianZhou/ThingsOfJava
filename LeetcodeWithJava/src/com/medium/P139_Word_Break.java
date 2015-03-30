package com.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 【动态规划】
 * 给定一个单词和一个词典集合
 * 判断 该单词 是否可以用词典中的词组成
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/word-break/
 */
public class P139_Word_Break {
	static StringBuffer str = new StringBuffer("");
	public static boolean wordBreak1(String s, Set<String> dict) {
		return checkDict(s, 0, dict);

	}

	/**
	 * 问题1：["aaaa","aaa"]  ---> 最小匹配失效！
	 * @param s
	 * @param pos
	 * @param dict
	 * @return
	 */
	private static boolean checkDict(String s,int pos,Set<String> dict){
		if(pos==s.length()) return true;

		str.delete(0, Math.max(str.length(),0));
		for(int i=pos;i<s.length();i++){
			str.append(s.charAt(i));
			if(dict.contains(str.toString())){
				//				dict.remove(str.toString());			//可以重复利用
				return checkDict(s, i+1, dict);
			}
		}
		return false;
	}

	//-------------------------------
	/**
	 *   
	 * @param s
	 * @param dict
	 * @return
	 * @see https://leetcode.com/discuss/24572/accepted-java-solution
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		
		boolean[] breakable = new boolean[s.length()+1];	//保存各位置是否可以分解（默认为false）
		
		breakable[0] = true;

		for(int i=1;i<=s.length();i++){
			//针对 [0,i] 区间内，寻找匹配的单词
			//以 j 为基础，[0,j] 和 [j,i]
			for(int j=0;j<i;j++){
				
				if(breakable[j] && dict.contains(s.substring(j,i))){
					breakable[i] = true;
					break;
				}
			}
			
		}
		return breakable[s.length()];
	}
	//-------------------------------

	public static void main(String[] args) {
		String s = "aaaaaaa";
		HashSet<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("hello ");
		dict.add("aaaa");
		dict.add("aaa");

		if(wordBreak(s, dict))
			System.out.println("------OK-----");
		else
			System.out.println("------NO-----");

	}

}
