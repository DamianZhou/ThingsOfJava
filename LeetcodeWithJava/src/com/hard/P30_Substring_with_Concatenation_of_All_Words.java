package com.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * You are given a string S, and a list of words L, that are all of the same length. 
 * 给定字符串S，和多个长度相同的单词L
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L 
 * exactly once and without any intervening characters.
 * 找到S的字串中是一连串的L单词（全部）的。


	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]

	You should return the indices: [0,9].
	(order does not matter).
 *	
 * @author DamianZhou
 * @see https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class P30_Substring_with_Concatenation_of_All_Words {
	public static  List<Integer> findSubstring1(String S, String[] L) {

		return null;
	}

	public static  List<Integer> findSubstringHelper(String S, String[] L) {

		int wlen=L[0].length(); //单词的长度
		int Llen=L.length; //单词的个数
		int[][] matrix= new int[Llen+1][S.length()];	//定义记录单词位置的数组,最后一行用于统计(默认为0)

		int k=Llen-1;
		int index=-1;
		while(k>=0){
			index=S.indexOf(L[k]);
			while(index!=-1){
				matrix[k][index]=k+1;
				index=S.indexOf(L[k],index+1);//下个位置开始找
			}
			k--;
		}

		for(int i=0;i<S.length();i++){
			for(int j=0;j<Llen;j++){
				matrix[Llen][i]+=matrix[j][i];
			}
		}

		return null;
	}

	//参考---------------------------
	public static List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		if (S == null || L == null || L.length == 0) return res;
		int len = L[0].length(); // length of each word

		Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
		for (String w : L) 
			map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

		for (int i = 0; i <= S.length() - len * L.length; i++) {
			//复制新的Map，使用Map记录元素
			Map<String, Integer> copy = new HashMap<String, Integer>(map);
			
			for (int j = 0; j < L.length; j++) { // checkc if match
				String str = S.substring(i + j*len, i + j*len + len); // next word
				if (copy.containsKey(str)) { // is in remaining words
					int count = copy.get(str);
					if (count == 1) 
						copy.remove(str);
					else 
						copy.put(str, count - 1);
					
					if (copy.isEmpty()) { // matches
						res.add(i);
						break;
					}
				} else 
					break; // not in L
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String S= "barfoothefoobarman";
		String[] L={"foo", "bar"};

		findSubstringHelper(S,L);
	}

}
