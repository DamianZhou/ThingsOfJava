package com.medium;

import java.util.ArrayList;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/triangle/
 */
public class P120_Triangle {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle.size()==1)
			return triangle.get(0).get(0);

		int i,j,t1,t2,len;
		for(i=1;i<triangle.size();i++){
			triangle.get(i).set(0, triangle.get(i).get(0)+triangle.get(i-1).get(0));//第一个元素
			len=triangle.get(i).size();
			for(j=1;j<len-1;j++){
				t1=triangle.get(i-1).get(j-1);
				t2=triangle.get(i-1).get(j);
				triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(t1, t2));
			}
			triangle.get(i).set(len-1, triangle.get(i).get(len-1)+triangle.get(i-1).get(len-2));//最后一个元素
		}

		triangle.get(triangle.size()-1).sort(null);
		return triangle.get(triangle.size()-1).get(0);   
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		
		temp = new ArrayList<Integer>();
		temp.add(2);
		triangle.add(temp);
		
		temp = new ArrayList<Integer>();
		temp.add(3);
		temp.add(4);
		triangle.add(temp);
		
		temp = new ArrayList<Integer>();
		temp.add(6);
		temp.add(5);
		temp.add(7);
		triangle.add(temp);		
		
		temp = new ArrayList<Integer>();
		temp.add(4);
		temp.add(1);
		temp.add(8);
		temp.add(3);
		triangle.add(temp);		

		System.out.println(minimumTotal(triangle));

	}

}
