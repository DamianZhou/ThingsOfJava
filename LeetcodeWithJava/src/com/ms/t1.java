package com.ms;

import java.util.Scanner;
import java.util.regex.Pattern;

public class t1 {
	public static void getval(){
		Scanner in = new Scanner(System.in);
		int x=in.nextInt();
		int y=in.nextInt();
		int z=in.nextInt();

		String str = in.next();

		char t;
		int i=0;
		int len = str.length();
		int count=0;
		int max=0;
		int cr=0,cy=0,cb=0;
		for(i=0;i<len;i++){
			t=str.charAt(i);
			switch(t){
			case 'R':
				cr++;
				break;
			case 'Y':
				cy++;
				break;
			case 'B':
				cb++;
				break;
			}
			count=cr+cb+cy;
			max=max>count?max:count;
			if((Math.abs(cr-cy)==x && Math.abs(cy-cb)==y && Math.abs(cb-cr)==z)||
					(Math.abs(cr-cy)==y && Math.abs(cy-cb)==z && Math.abs(cb-cr)==x)||
					(Math.abs(cr-cy)==z && Math.abs(cy-cb)==x && Math.abs(cb-cr)==y)){
				count=cr=cy=cb=0;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		getval();
//		Scanner in = new Scanner(System.in);
//		int x=in.nextInt();
//		int y=in.nextInt();
//		int z=in.nextInt();
//
//		String str = in.next();
//
//		char t;
//		int i=0;
//		int len = str.length();
//		int count=0;
//		int max=0;
//		int cr=0,cy=0,cb=0;
//		for(i=0;i<len;i++){
//			t=str.charAt(i);
//			switch(t){
//			case 'R':
//				cr++;
//				break;
//			case 'Y':
//				cy++;
//				break;
//			case 'B':
//				cb++;
//				break;
//			}
//			count=cr+cb+cy;
//			max=max>count?max:count;
//			if((Math.abs(cr-cy)==x && Math.abs(cy-cb)==y && Math.abs(cb-cr)==z)||
//					(Math.abs(cr-cy)==y && Math.abs(cy-cb)==z && Math.abs(cb-cr)==x)||
//					(Math.abs(cr-cy)==z && Math.abs(cy-cb)==x && Math.abs(cb-cr)==y)){
//				count=cr=cy=cb=0;
//			}
//		}
//		System.out.println(max);

	}
}
