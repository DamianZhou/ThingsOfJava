package com.easy;
/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/ugly-number/
 */
public class P263_Ugly_Number {
   /**
    * 20150824
    */
	public boolean isUgly(int num) {
		
		if(num<1) 
			return false;
		else if(num==1 || num==2 || num==3)
			return true;
		else{
			int temp = num;
			
			while(temp%2==0)
				temp=temp/2;
			while(temp%3==0)
				temp=temp/3;		
			while(temp%5==0)
				temp=temp/5;
			if(temp==1)
				return true;
			else
				return false;
		}
    }
	public static void main(String[] args) {
		P263_Ugly_Number test = new P263_Ugly_Number();
		System.out.println(test.isUgly(10));
		System.out.println(test.isUgly(100));
		System.out.println(test.isUgly(145));
	}

}
