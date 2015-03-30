package com.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 格雷码，二进制数字系统，连续的两个数只有一位不同
 * 
 * A gray code sequence must begin with 0.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/gray-code/
 */
public class P89_Gray_Code {

	public static  List<Integer> grayCode(int n) {
		if(n<0) return null;
		ArrayList<Integer>  ans = new ArrayList<Integer>();
		if(n==0){
			ans.add(0);
		}else
			getGreyCode(n, 1, ans);
		return ans;
	}

	public static void getGreyCode(int n , int count,ArrayList<Integer> list){

		if(count==1){
			list.add(0);
			list.add(1);
		}else if(count>n) 
			return ;
		else{
			int base = (int) Math.pow(2, count-1); //求 n 次方
			int len=list.size();
			for(int i=len-1;i>=0;i--){
				list.add(list.get(i)+base);
			}
		}
		count++;
		getGreyCode(n, count, list);
	}

	public static void main(String[] args) {
		List<Integer> test = grayCode(1);
		for(int i=0;i<test.size();i++)
			System.out.println(test.get(i));

	}

}
