package com.medium;

import java.util.Stack;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/basic-calculator/
 */
public class P224_Basic_Calculator {
	/**
	 * 2015/06/23
	 * @param s
	 * @return
	 */
	public int calculate(String s) {

		Stack<Character> opStack = new Stack<Character>();
		Stack<Integer> intStack = new Stack<Integer>();

		int len = s.length();

		if(len==0) 
			return 0;

		StringBuilder sb = new StringBuilder("");

		for ( char ch : s.toCharArray()){
			if(ch >= '0' && ch <= '9'){
				sb.append(ch);
				continue;
			}else{

				if(sb.length()>0){
					int tempvalue = Integer.parseInt(sb.toString());
					sb.delete(0, sb.length());

					if(opStack.size()>0){
						char op = opStack.peek();

						//此处可能有积压的加减号
						while( op == '+' || op == '-'){
							if( op == '+' ){
								tempvalue += intStack.pop();    					
								opStack.pop();
							}else if( op == '-' ){
								tempvalue = intStack.pop() - tempvalue;
								opStack.pop();
							}
							if(opStack.size()>0)
								op = opStack.peek();
							else{
								break;
							}
						}
					}

					intStack.push(tempvalue);
				}

				switch (ch) {
				case ' ':
					break;
				case '(': case '+': case '-':
					opStack.push(ch);
					break;
				case ')':
					opStack.pop();
					break;
				default:
					break;
				}
			}// ch is not a num

		}// for

		if(opStack.size()>0){
			int tempvalue = 0;
			if(sb.length()>0){
				tempvalue = Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
			}else{
				tempvalue = intStack.pop();
			}

			if(opStack.size()>0){
				char op = opStack.peek();
				if( op == '+' ){
					tempvalue += intStack.pop();    					
					opStack.pop();
				}else if( op == '-' ){
					tempvalue = intStack.pop() - tempvalue;
					opStack.pop();
				}
			}

			intStack.push(tempvalue);
		}		

		if(sb.length()>0)
			return Integer.parseInt(sb.toString());
		
		return intStack.pop();
	}
	public static void main(String[] args) {
		P224_Basic_Calculator test = new P224_Basic_Calculator();

//		String str = "(101+(4+5+2)-3)+(6+8)";
		
		//test
//		String str = "488";
		String str = "(1-(3-4))";

		System.out.println(test.calculate(str));
	}

}
