package com.easy;

import java.util.HashMap;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/word-pattern/
 */
public class P290_Word_Pattern {

	public boolean wordPattern(String pattern, String str) {
		if(pattern.length() <1 || str.length()<1)
			return false;

		String[] words = str.split(" ");
		if(words.length != pattern.length())
			return false;

		HashMap<Character, String> map_p = new HashMap<Character, String>();
		HashMap<String, Character> map_s = new HashMap<String, Character>();
		
		for(int i=0 ; i<pattern.length() ; i++){
			char ch = pattern.charAt(i);
			String word = words[i];
			//模式到字符串
			if(map_p.containsKey(ch)){
				if( !word.equals( map_p.get(ch) ) )
					return false;
			}else
				map_p.put(ch, word);
			
			//字符串到模式
			if(map_s.containsKey(word)){
				if(map_s.get(word) != ch)
					return false;
			}else
				map_s.put(word,ch);			

		}
		return true;
	}

	public static void main(String[] args) {
		P290_Word_Pattern test = new P290_Word_Pattern();
		
		System.out.println( test.wordPattern("abbc", "dog cat cat fish") );
		

	}

}
