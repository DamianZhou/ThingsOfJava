package com.demo.bitop;

/**
 * 位操作demo
 * @author DamianZhou
 *
 */
public class TestBitOperation {
	public static void main(String args[]) {     
		int a = 60; 			/* 60 = 0011 1100 */       
		int b = 13; 			/* 13 = 0000 1101 */      
		int c = 0;      
		int d=2147483647;

		c = a & b;       		/* 12 = 0000 1100 */      
		System.out.println("a & b = " + c );      

		c = a | b;       		/* 61 = 0011 1101 */      
		System.out.println("a | b = " + c );      

		c = a ^ b;       		/* 异或：49 = 0011 0001 */      
		System.out.println("a ^ b = " + c );      

		c = ~a;         		 /* 非：-61 = 1100 0011 */      
		System.out.println("~a = " + c );      

		c = a << 2;     		/* 左移：240 = 1111 0000 */      
		System.out.println("a << 2 = " + c );      

		c = a >> 2;     		/* 右移：15 = 0000 1111 */      
		System.out.println("a >> 2  = " + c );       

		c = a >>> 2;     	/* 右移：15 = 0000 1111 */      
		System.out.println("a >>> 2 = " + c );   

		c = d >>> 2;     	/* 右移：15 = 0000 1111 */      
		System.out.println("d >> 2 = " + c );  
		
		c = d >>> 2;     	/* 右移：15 = 0000 1111 */      
		System.out.println("d >>> 2 = " + c );
		
		
		System.out.println(-4>>2 );
		System.out.println(-4>>>2 );
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-7));
		System.out.println(Integer.toBinaryString(-15));
		System.out.println(Integer.toBinaryString(15>>1));		//左边补0
		System.out.println(Integer.toBinaryString(-15>>1));		//左边补1
		System.out.println(Integer.toBinaryString(-15>>>1));	//左边补0
	}
}
