package com.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/repeated-dna-sequences/
 */
public class P187_Repeated_DNA_Sequences {
	/**
	 * 暴力破解
	 * Memory Limit Exceeded
	 * @param s
	 * @return
	 */
    public static List<String> findRepeatedDnaSequences(String s) {
        LinkedList<String> list = new LinkedList<String>();
        int len=s.length();
        if(len<10) 
        	return list;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int i;
        String str=null;
        for(i=0;i<len-9;i++){
        	str=s.substring(i,i+10);
        	if(map.containsKey(str)){
        		map.put(str, map.get(str)+1);
        	}else
        		map.put(str, 1);
        }
        
		Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
        	str=it.next();
        	if(map.get(str)>1)
        		list.add(str);
        }
        
        return list;
    }
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		findRepeatedDnaSequences(s);		
	}

}
