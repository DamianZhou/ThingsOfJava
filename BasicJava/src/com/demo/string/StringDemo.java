package com.demo.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StringDemo {
	
	/**
	 * String 默认初始化为null
	 * 必须手动设置为“”
	 */
	static void init(){
		String[] str= new String[10];
		int i; 
		for(i=0;i<str.length;i++)
			str[i]="";
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
