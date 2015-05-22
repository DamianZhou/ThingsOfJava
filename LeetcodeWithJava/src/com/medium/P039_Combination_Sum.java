package com.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/combination-sum/
 */
public class P039_Combination_Sum {

	/**
	 * 2015/05/18
	 * @param candidates 正整数、可重复使用同一元素
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		getCombinationSum(candidates,target,new LinkedList<Integer>(),result);

		return result;
	}

	void getCombinationSum(int[] candidates, int target,LinkedList<Integer> tList,LinkedList<List<Integer>> result){
		if(target<=0) return;
		int len = candidates.length;
		LinkedList<Integer> temp = null;

		for(int i=0;i<len;i++){
			if(tList.size()>0 && candidates[i]<tList.get(tList.size()-1)) //递增
				continue;

			temp = new LinkedList<Integer>(tList);
			temp.add(candidates[i]);
			int val = target-candidates[i];

			//			System.out.println("----"+Arrays.toString(temp.toArray()));

			if(val==0){
				//				System.out.println("----OK----"+Arrays.toString(temp.toArray()));
				result.add(temp); //去除重复项（通过递增实现）
			}else{
				getCombinationSum(candidates,val,temp,result);
			}
		}
	}

	public static void main(String[] args) {
		P039_Combination_Sum test = new P039_Combination_Sum();

		int[] candidates = {2,3,4,6,7};
		int target = 7;
		List<List<Integer>> result = test.combinationSum(candidates, target);

		//-----------------------------------------------
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" , ");
			}
			System.out.println();
		}

	}

}
