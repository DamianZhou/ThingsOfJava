package com.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 返回所有的排列组合
 * @author DamianZhou
 * @see https://leetcode.com/problems/permutations/
 */
public class P46_Permutations {
    public static List<List<Integer>> permute(int[] num) {
    	
    	int len = num.length;
    	List<ArrayList<Integer>> result = new LinkedList<ArrayList<Integer>>();
    	
    	
        return null;
    }
    
    private static LinkedList<Integer> getList(int[] num,int len){
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	
    	if(len==1){
    		list.add(num[0]);
    		return list;
    	}
    	
    	
    	
    	return null;
    }
    
    
    
	public static void main(String[] args) {
		int[] num = {1,2,3};
		
		permute(num);

	}

}
