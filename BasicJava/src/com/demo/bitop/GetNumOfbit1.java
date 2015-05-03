package com.demo.bitop;

public class GetNumOfbit1 {

	private static int getbitNum(int n){
		int count=0;
		int t=n;
		while(t!=0){
			System.out.println(Integer.toBinaryString(t));
			t=t&(t-1); //每次 t-1 都会在 t中【最右边的1】中减，左边的格式不变，右边完全翻转, 与操作以后抵消
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.print(getbitNum((int)(Math.pow(2, 32)-1)));
	}

}
