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

	public static void main(String[] args) {
		StringDemo test = new StringDemo();
		test.testStringBuilder();

	}

}
