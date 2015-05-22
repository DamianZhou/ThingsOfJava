package com.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/combinations/
 */
public class P077_Combinations {

	/**
	 * 2015/05/20
	 * 在1到n中找到长度为k的所有组合
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
		LinkedList<List<Integer>> result = new LinkedList<>();

		if(n<k || n<1 || k<0) return result; 

		LinkedList<Integer> num = new LinkedList<>();
		for(int i=1;i<=n;i++){
			num.add(i);
		}

		getAllCombinations(result, new LinkedList<Integer>(),num, k);

		return result;
	}

	void getAllCombinations(LinkedList<List<Integer>> result, LinkedList<Integer> tlist,LinkedList<Integer> num, int level ){
		//    	System.out.println("level="+level+" , tlist="+Arrays.toString(tlist.toArray())+" , num="+Arrays.toString(num.toArray()));
		if(level==0){
			result.add(new LinkedList<>(tlist));
			return;
		}

		for(int i=0;i<num.size();i++){
			int val = num.get(i);
			if(tlist.size()>0 && tlist.get(tlist.size()-1)>val)
				continue;
			tlist.add(val);
			num.remove(i);
			getAllCombinations(result, tlist, num, level-1);
			
			//重复利用 num&tlist ，恢复原貌
			num.add(i, val);
			tlist.remove(tlist.size()-1);
		}
	}

	public static void main(String[] args) {
		P077_Combinations test = new P077_Combinations();
		List<List<Integer>> result = test.combine(6, 5);

		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" , ");
			}
			System.out.println();
		}

	}

}
