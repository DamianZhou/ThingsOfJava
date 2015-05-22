package com.demo.numbers;

import java.util.Arrays;

public class IntegerDemo {
	
	static void change(int a,int b,Integer c,String s,int[] num){
		a=456;
		b=888;
		c=900;
		s=s+c;
		
		num[1]=a;
		num[2]=b;
		num[0]=c;
	}

	public static void main(String[] args) {
		int a=111;
		int b=123;
		
		int[] num={2,3,4};
		
		Integer c = new Integer(12);
		
		String s="23445";
		
		System.out.print(a+", "+b+", "+c+", "+Arrays.toString(num));
		
		change(a,b,c,s,num);
		
		System.out.print("\n"+a+", "+b+", "+c+", "+Arrays.toString(num));
		
		//-----------------------------------------------

	}

}
