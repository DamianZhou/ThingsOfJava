package com.easy;

import java.util.HashSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/bulls-and-cows/
 */
public class P299_Bulls_and_Cows {
	
	/**
	 * @param secret
	 * @param guess
	 * @return
	 */
	public String getHint(String secret, String guess) {
		StringBuilder stb = new StringBuilder();

		boolean[] secretFlag = new boolean[10];
		int A = 0;
		int B = 0;
		for(int i=0;i<secret.length();i++)
			secretFlag[secret.charAt(i)-'0'] = true;
		
		for(int i = 0;i<guess.length();i++){
			if( secretFlag[ guess.charAt(i)-'0' ] ){
				if(guess.charAt(i) == secret.charAt(i))
					A++;
				else
					B++;
			}
		}
		
		stb.append(A);
		stb.append("A");
		stb.append(B);
		stb.append("B");

		return stb.toString();
	}
	
	
	public String getHint1(String secret, String guess) {
		StringBuilder stb = new StringBuilder();

		int[] secretFlag = new int[10];
		int A = 0;
		int B = 0;
		for(int i=0;i<secret.length();i++)
			secretFlag[secret.charAt(i)-'0']++;
		
		for(int i = 0;i<guess.length();i++){
			if( secretFlag[ guess.charAt(i)-'0']-- > 0){
				if(guess.charAt(i) == secret.charAt(i))
					A++;
				else
					B++;
			}
		}
		
		stb.append(A);
		stb.append("A");
		stb.append(B);
		stb.append("B");

		return stb.toString();
	}

	public static void main(String[] args) {
		P299_Bulls_and_Cows test = new P299_Bulls_and_Cows();
		String result;
		String secret = "1234";
		String guess = "0111";

		result = test.getHint(secret, guess);

		System.out.println(result);

	}

}
