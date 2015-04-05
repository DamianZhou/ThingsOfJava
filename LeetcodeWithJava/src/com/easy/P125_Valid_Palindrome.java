package com.easy;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/valid-palindrome/
 */
public class P125_Valid_Palindrome {
	public static boolean isPalindrome(String s) {
		s=s.toLowerCase();
		int i=0;
		int j=s.length()-1;
		char s1;
		char s2;
		while(i<j){
			s1=s.charAt(i);
			s2=s.charAt(j);
			
			Character.isLetterOrDigit(s1);
			
			while(!((s1>='a' && s1<='z') || (s1 >='0' &&  s1<='9')) && i<j){
				i++;
				s1=s.charAt(i);
			}
			while(!((s2>='a' && s2<='z') || (s2 >='0' &&  s2<='9')) && i<j){
				j--;
				s2=s.charAt(j);
			}
			if(s1!=s2)
				return false;
			else{
				i++;
				j--;
			}

		}

		return true;
	}
	
	/**
	 * Character.isLetterOrDigit 判断字母或者数字！
	 * @param s
	 * @return
	 * @see https://leetcode.com/discuss/28869/short-accepted-java-solution
	 */
	public boolean isPalindrome_better(String s) {
        s = s.toLowerCase();
        int lo = 0, hi = s.length()-1;
        while(lo < hi) {
            while(!Character.isLetterOrDigit(s.charAt(lo)) && lo < hi) lo++;
            while(!Character.isLetterOrDigit(s.charAt(hi)) && lo < hi) hi--;
            if(s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// ",." true
		// "1a2" false

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(",."));
		System.out.println(isPalindrome("1a2"));

	}

}
