package com.easy;

import java.util.Stack;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/valid-parentheses/
 */
public class P20_Valid_Parentheses {
	public static boolean isValid(String s) {
		int len = s.length();
		int i=0;
		char c1,c2;
		Stack<Character> stack = new Stack<Character>();
		for(;i<len;i++){
			c1=s.charAt(i);
			switch(c1){
			case '(':
			case '[':
			case '{':
				stack.push(c1);
				break;
			case ')':
				if(stack.size()<=0)
					return false;
				c2=stack.pop();
				if(c2!='(')
					return false;
				break;
			case ']':
				if(stack.size()<=0)
					return false;
				c2=stack.pop();
				if(c2!='[')
					return false;
				break;
			case '}':
				if(stack.size()<=0)
					return false;
				c2=stack.pop();
				if(c2!='{')
					return false;
				break;


			}
		}
		if(stack.size()==0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		System.out.print(isValid("(()[]{})[{}]"));

	}

}
