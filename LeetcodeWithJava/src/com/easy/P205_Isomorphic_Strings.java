package com.easy;

import java.util.HashMap;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/isomorphic-strings/
 */
public class P205_Isomorphic_Strings {
	
	/**
	 * 2015/04/30
	 * note: You may assume both s and t have the same length.
	 * 使用Hashmap映射，从 s 映射到 t
	 * 补充：s到t成立，t到s也成立才可以
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isIsomorphic(String s, String t) {
    	int len = s.length();
    	if(len==0) 
    		return true;
    	
    	HashMap<Character, Character> map = new HashMap<Character, Character>();
    	char a,b;
    	for(int i=0;i<len;i++){
    		a=s.charAt(i);
    		b=t.charAt(i);
    		
    		if(!map.containsKey(a) ){
    			if(map.containsValue(b)) //不能让不同的key映射到同一个值，否则 b 重复
    				return false;
    			else
    				map.put(a,b);
    		}else{
    			if(map.get(a)!=b) 
    				return false;
    		}
    	}
		return true;
    }
	public static void main(String[] args) {
		P205_Isomorphic_Strings test = new P205_Isomorphic_Strings();
		
//		String s="egg";
//		String t="add";
		
//		String s = "foo";
//		String t = "bar";
		
		//-------------------------------出错案例
//		String s = "ab";
//		String t = "aa";
		
		String s  = "aa";
		String t  = "ab";

		//-------------------------------
		
		if(test.isIsomorphic(s, t))
			System.out.println("OK");
		else
			System.out.println("No");

	}

}
