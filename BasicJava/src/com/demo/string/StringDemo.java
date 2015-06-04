package com.demo.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StringDemo {
	
	/**
	 * String 默认初始化为null
	 * 必须手动设置为“”
	 */
	 void init(){
		String[] str= new String[10];
		int i; 
		for(i=0;i<str.length;i++)
			str[i]="";
	}
	
	void testStringBuilder(){
		StringBuilder str = new StringBuilder("world!");
		
		str.insert(0, "hello ");
		System.out.println(str.toString());
		
		str.replace(0, 6, "");
		System.out.println(str.toString());		
		
		str.reverse();
		System.out.println(str.toString());		
		
		str.setCharAt(0, '$');
		System.out.println(str.toString());		
		
		str.toString().length(); //String 的 length 是通过函数获取的
	}
	
	void testSub(){
		String str = "012345";
		
		System.out.println(str.substring(2));
		System.out.println(str.indexOf('3'));
		System.out.println(str.subSequence(0, 1));
	}
	
	

	public static void main(String[] args) {
		StringDemo test = new StringDemo();
//		test.testStringBuilder();
		test.testSub();
		
		StringBuilder strb = new StringBuilder("147258");
		System.out.println(strb.reverse().toString());

	}

}
