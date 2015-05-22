package com.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class P017_Letter_Combinations_of_a_Phone_Number {
	/**
	 * 2015/05/20
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<String>();
		if(digits.length()<1) return result;

		HashMap<Character, String> numMap = new HashMap<>(8);
		numMap.put('2', "abc");
		numMap.put('3',"def");
		numMap.put('4',"ghi");
		numMap.put('5',"jkl");
		numMap.put('6',"mno");
		numMap.put('7',"pqrs");
		numMap.put('8',"tvu");
		numMap.put('9',"wxyz");

		getWords(result, new StringBuilder(digits), new StringBuilder(), numMap);

		return result;

	}

	void getWords(LinkedList<String> result,StringBuilder numbers,StringBuilder tword,HashMap<Character, String> numMap){
		
		System.out.println("numbers="+numbers.toString()+" , tword"+tword.toString());
		
		if(numbers.length()==0){
			result.add(tword.toString());
			return;
		}

		char val = numbers.charAt(0);
		if(val=='1'){
			numbers.deleteCharAt(0);
			getWords(result, numbers, tword, numMap);
		}else{
			String word = numMap.get(val);
			for(int i=0;i<word.length();i++){
				tword.append(word.charAt(i));
				numbers.deleteCharAt(0);
				getWords(result, numbers, tword, numMap);
				numbers.insert(0, val);
				tword.deleteCharAt(tword.length()-1);
			}
		}

	}

	public static void main(String[] args) {
		P017_Letter_Combinations_of_a_Phone_Number test = new P017_Letter_Combinations_of_a_Phone_Number();
		List<String> result = test.letterCombinations("84261312");

		for(String str : result){
			System.out.println(str);
		}
		
	}

}
