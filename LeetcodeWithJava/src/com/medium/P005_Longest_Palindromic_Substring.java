package com.medium;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/longest-palindromic-substring/
 */
public class P005_Longest_Palindromic_Substring {

	public String longestPalindrome(String s) {
		if(s.length()==0)
			return "";
		return subLongestPalindrome(s, 0, s.length()-1);
	}

	public String subLongestPalindrome(String str,int s,int e) {
		if(isPalindromic(str, s, e))
			return str.substring(s, e+1);
		else if(isPalindromic(str, s+1, e))
			return str.substring(s+1, e+1);
		else if(isPalindromic(str, s, e-1))
			return str.substring(s, e);
		return subLongestPalindrome(str, s+1, e-1);
	}

	boolean isPalindromic(String str,int s,int e){
		int i = s;
		int j = e;
		if(j<i)
			return false;

		while(i<j){
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	//------------------------------------------------------------

	private int lo, maxLen;
	
	/**
	 * 
	 * @param s
	 * @return
	 * @see https://leetcode.com/discuss/56323/very-simple-clean-java-solution
	 */
	public String longestPalindrome_ref(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len-1; i++) {
			extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i+1); //assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	/**
	 * 从 j&k 为中间的最长回文串
	 * @param s
	 * @param j
	 * @param k
	 */
	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		//记录最大回文的位置
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}

	public static void main(String[] args) {
		P005_Longest_Palindromic_Substring test = new P005_Longest_Palindromic_Substring();
		String s = "abcssc";
		String result = test.longestPalindrome(s);
		System.out.println(result);
	}

}
