package com.medium;

import java.util.Arrays;

/**
 * To be done
 * @author DamianZhou
 * @see https://leetcode.com/problems/remove-duplicate-letters/
 */
public class P316_Remove_Duplicate_Letters {

	public String removeDuplicateLetters(String s) {
		if(s==null || s.length()<2)
			return s;

		int[] flag = new int[26];
		Arrays.fill(flag, -1);

		StringBuilder stb = new StringBuilder(s);

		for(int i = 0 ; i<stb.length() ; i++){
			char temp = stb.charAt(i);
			if(flag[temp-'a']==-1) //首次出现
			flag[temp-'a'] = i;
			else{
				if(isRemoveable(flag, stb, flag[temp-'a'], i))
					stb.setCharAt(i, '-');
				else{
					stb.setCharAt(flag[temp-'a'], '-');
					flag[temp-'a'] = i;
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for(int i = 0;i<stb.length();i++)
			if(stb.charAt(i)!='-')
				result.append(stb.charAt(i));
		return result.toString();
	}

	/**
	 * 判断当前位置的字符是否需要替换
	 * 根据上一次出现位置及其之后的一个位置比较
	 * @param flag
	 * @param stb
	 * @param start 上次出现位置
	 * @param now 当前位置
	 * @return
	 */
	public boolean isRemoveable(int[] flag,StringBuilder stb,int start,int now){

		char base = stb.charAt(now);
		char next = stb.charAt(start+1);
		if(base>next)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		P316_Remove_Duplicate_Letters test = new P316_Remove_Duplicate_Letters();

		String str = "bcabc";
		String result = test.removeDuplicateLetters(str);
		System.out.println(result);
	}

}
