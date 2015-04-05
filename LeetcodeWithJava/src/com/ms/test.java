package com.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) throws IOException {
		int cr=4,cy=1,cb=2;
		int x=1;
		int y=2;
		int z=3;
		
		if(((Math.abs(cr-cy)==z ) && (Math.abs(cy-cb)==x) && (Math.cbrt(cb-cr)==y))){
		}
		System.out.println(Math.abs(cr-cy));
		System.out.println(Math.abs(cb-cy));
		System.out.println(Math.abs(cr-cb));
		if(Math.abs(cr-cy)==z&& (Math.abs(cy-cb)==x)&&(Math.cbrt(cb-cr)==y) ){
			System.out.println(Math.abs(cr-cy));
		}
		
//		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer bu = new StringBuffer("");
		String s="RYB";
		Scanner in = new Scanner(s);
		while(in.hasNext()){
			bu.append(in.next("[RYB]"));
		}
		System.out.println(bu.toString());
	}
}
