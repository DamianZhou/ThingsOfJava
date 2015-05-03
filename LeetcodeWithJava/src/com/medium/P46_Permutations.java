package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import sun.security.action.GetLongAction;

/**
 * 返回所有的排列组合
 * @author DamianZhou
 * @see https://leetcode.com/problems/permutations/
 */
public class P46_Permutations {

	/**
	 * 2015/04/25 参考 剑指offer
	 * @param num
	 * @return
	 */
	public static List<List<Integer>> permute(int[] num) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		getList(num,0,result);

		//遍历，仅为了验证
		for(int i=0;i<result.size();i++){
			ArrayList list = (ArrayList) result.get(i);
			for ( Object e : list){
				System.out.print(e+",");
			}
			System.out.println();
		}

		return result;
	}

	/**
	 * 选定from位置的值，遍历右边所有可能的排序
	 * @param num
	 * @param from
	 * @param result
	 */
	static void getList( int[] num, int from, List<List<Integer>> result){
		if(from==num.length){
			System.out.println("return------------"+Arrays.toString(num));
			ArrayList<Integer> list = new ArrayList<Integer>(num.length);
			for(int v : num)	list.add(v);
			result.add(list); //添加整个数组作为元素
		}else{
			for(int i=from;i<num.length;i++){ //选取第i位置的元素放在from位置，然后获取右边的排列
				int temp =  num[from];
				num[from] = num[i];
				num[i] = temp;

				System.out.println("i="+i+",from="+from+" num="+Arrays.toString(num));

				getList(num, from+1, result);

				//复原数组，进行下一轮调用
				temp =  num[from];
				num[from] = num[i];
				num[i] = temp;
			}
		}
	}



	public static void main(String[] args) {
		int[] num = {1,2,3};

		permute(num);

	}

}
