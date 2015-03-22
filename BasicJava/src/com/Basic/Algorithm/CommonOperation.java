package com.Basic.Algorithm;

public class CommonOperation {
	
	/**
	 * 打印数组
	 * @param a
	 * @param n
	 * @param i
	 */
	static void print(int a[], int n ,int i){  
		System.out.print(i+":");
		for(int j= 0; j<8; j++){  
			System.out.print(a[j]+" ");
		}  
		System.out.println();
	}  
}
