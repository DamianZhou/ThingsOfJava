package com.demo.numbers;

public class NumberToBinary {

	public static void main(String[] args) {
		int num=256;
		StringBuffer binaryStr = new  StringBuffer("");
		int temp;
		while(num>0){
			temp=num%2;
			binaryStr.insert(0, temp);
			num=(num-temp)/2;
		}
		System.out.println(binaryStr.toString());
	}

}
