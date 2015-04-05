package com.demo.io;

import java.util.Scanner;

public class iodemo {

	public static void main(String[] args) {
		
		//从 console 读取
		Scanner in = new Scanner(System.in);
		int count=3;
		while(in.hasNext() && count>0){
			count--;
			System.out.println("------"+in.next());
		}
		
		//从文件读取

	}

}
