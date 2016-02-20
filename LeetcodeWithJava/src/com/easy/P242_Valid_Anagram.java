package com.easy;

import java.util.HashMap;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/valid-anagram/
 */
public class P242_Valid_Anagram {
	public boolean isAnagram(String s, String t) {
		if(s==null || t==null || s.length()!=t.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch : s.toCharArray()){
			if(!map.containsKey(ch))
				map.put(ch, 1);
			else{
				int val = map.get(ch);
				map.put(ch, val+1);
			}
		}
		for(char ch : t.toCharArray()){
			if(!map.containsKey(ch))
				return false;
			else{
				int val = map.get(ch);
				val--;
				if(val<0)
					return false;
				else if(val>0)
					map.put(ch, val);
				else
					map.remove(ch);
			}
		}
		if(map.size()==0)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		P242_Valid_Anagram test = new P242_Valid_Anagram();
		boolean result = test.isAnagram("anagram", "nagaram");
		System.out.println(result);
	}

}
