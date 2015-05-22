package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/combination-sum-ii/
 */
public class P40_Combination_Sum_II {
	
	/**
	 * 
	 * @param num
	 * @param target
	 * @return
	 * @see https://leetcode.com/discuss/6822/my-thoughts-and-solution-to-the-problem-java
	 */
	public List<List<Integer>> combinationSum2_ref2(int[] num, int target) {
        if(num.length==0) 
        	return new ArrayList<List<Integer>>();
        Arrays.sort(num); //sort the array of num so it's easier to manage
        List<List<Integer>> result = helper(num,target,0);
        if(result==null) 
        	return new ArrayList<List<Integer>>();
        return result;
    }
	/**
	 * 
	 * @param num
	 * @param target
	 * @param index
	 * @return
	 * @see https://leetcode.com/discuss/6822/my-thoughts-and-solution-to-the-problem-java
	 */
    public List<List<Integer>> helper(int[] num, int target, int index)
    {
        if(index>=num.length||num[index]>target) return null; //return null if you hit the end
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        HashSet<List<Integer>> s = new HashSet<List<Integer>>(); //check if there is no duplicates
        for(int i = index;i<num.length;i++)
        {
             //if num[i]> target you dont need to check the rest. 
             //but it's break here because you still want to keep the rest of the result.
            if(num[i]>target) break; 
            temp = new ArrayList<Integer>();
            //if it's found the rest of the numbers can be trimed, save some time on complexity
            if(num[i]==target) 
            {
                temp.add(num[i]);
                result.add(temp);
                return result;
            }
            ArrayList<List<Integer>> t = (ArrayList)helper(num,target-num[i],i+1);
            //t is the temporary ArrayList of the result of your recursion call
            // you want to add the value of your current num[i] in the beginning of each
            // returned List<Integer> and add it to result if it's not duplicated.
            if(t!=null)
            {
                for(List<Integer> a:t)
                {
                    a.add(0,num[i]);
                    if(!s.contains(a)) //make sure there is no duplicates
                    {
                        s.add(a);
                        result.add(a);
                    }
                }
            }
        }
        return result;
    }

	/**
	 * 2015/05/19 Time Limit Exceeded
	 * @param candidates
	 * @param target
	 * @return
	 * @see http://blog.csdn.net/yskyj/article/details/41076925
	 */
	public List<List<Integer>> combinationSum2_ref(int[] candidates, int target) {
		HashSet<List<Integer>> result = new HashSet<List<Integer>>();
		Arrays.sort(candidates);
		internalCombinationSum2(candidates, 0, 0, target, new LinkedList<Integer>(), result);
		return new LinkedList<>(result);
	}
	/**
	 * C中可能有重复的数据，
	 * 如果前一个数据能够放入，后面相同的就可以放入
	 * 如果前面的数据不能放入，那么后面也就不用放入，注意是按照升序排列的
	 * @param candidates
	 * @param start
	 * @param sum
	 * @param target
	 * @param temp
	 * @param result
	 */
	void internalCombinationSum2(int[] candidates, int start, int sum,int target,LinkedList<Integer> temp,HashSet<List<Integer>>result) {
		int len = candidates.length;
		if(sum==target){
			result.add(temp);
			System.out.println("----OK----"+Arrays.toString(temp.toArray()));
			return;
		}else if(sum>target || start>=len){
			return;
		}

		for(int i=start;i<len;i++){
			if(candidates[i]>target) break;
			temp.add(candidates[i]);
			System.out.println("----"+Arrays.toString(temp.toArray()));
			internalCombinationSum2(candidates, i+1, sum+candidates[i], target, new LinkedList<>(temp), result);
			temp.removeLast(); //恢复原貌，进入下一轮循环
		}

	}

	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * 2015/05/18 
	 * 实现逻辑，但是 Time Limit Exceeded
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		HashSet<List<Integer>> result = new HashSet<List<Integer>>();
		Arrays.sort(candidates);
		ArrayList<Integer> numlist = new ArrayList<Integer>(candidates.length);
		for(int i=0;i<candidates.length;i++)
			numlist.add(candidates[i]);
		getCombinationSum2(numlist, target, new LinkedList<Integer>(), result);
		return new LinkedList<>(result);
	}

	/**
	 * 2015/05/18 Time Limit Exceeded
	 * 优化：使用HashSet替换，依旧 Time Limit Exceeded
	 * @param numlist
	 * @param target
	 * @param tList
	 * @param result
	 */
	void getCombinationSum2(ArrayList<Integer> numlist, int target,LinkedList<Integer> tList,HashSet<List<Integer>> result){
		if(target<=0) return;
		for(int i=0;i<numlist.size();i++){
			if(tList.size()>0 && tList.get(tList.size()-1)>numlist.get(i))
				continue;
			LinkedList<Integer> temp = new LinkedList<Integer>(tList);
			int val = target-numlist.get(i);
			//			System.out.println("----"+Arrays.toString(temp.toArray()));
			temp.add(numlist.get(i));
			if(val==0){
					result.add(temp);
				//				System.out.println("----OK----"+Arrays.toString(temp.toArray()));
			}else{
				ArrayList<Integer> tnumList =  new ArrayList<Integer>(numlist);
				tnumList.remove(i);
				getCombinationSum2(tnumList, val, temp, result);
			}
		}
	}


	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
		P40_Combination_Sum_II test = new P40_Combination_Sum_II();
//		int[] candidates = {10,1,2,7,6,1,5};
//		int target = 8;

		int[] candidates = {9,21,25,14,12,12,33,34,23,31,25,7,11,20,30,13,22,25,13,27,31,15,12,26,11,20,25,6,15,5,5,11,22,17,20,29,25,10,20,5,6,32,29,5,17,17,13,5,29,13,19,25,15,26,8,14,33,28,15,5,21,7,12,8,19,27,24,31,25};
		int target= 24;

		List<List<Integer>> result = test.combinationSum2_ref(candidates, target);

		//-----------------------------------------------
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" , ");
			}
			System.out.println();
		}

	}

}
