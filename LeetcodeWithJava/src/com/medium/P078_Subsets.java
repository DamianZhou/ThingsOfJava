package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/subsets/
 */
public class P078_Subsets {
	/**
	 * 2015/05/18-未完成
	 * 返回数组的所有子集，元素升序、不重复
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		int len = nums.length;
		if(len==0){
			result.add(null);
			return result;
		}


		return result;

	}


	/**
	 * 2015/05/18
	 * 使用位运算,遍历所有的值，【对应位】为1则加入到组合
	 * @param nums 不同元素组成的数组
	 * @return
	 * @see http://blog.csdn.net/u012118523/article/details/24884803
	 */
	public List<List<Integer>> subsets_ref1(int[] nums) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		Arrays.sort(nums); //数组排序

		int len = nums.length;
		int max = 1<<len; // 2^len 种组合 1000

		LinkedList<Integer> temp = null;
		for(int i=0;i<max;i++){
			temp = new LinkedList<Integer>();

			System.out.println("position status: "+Integer.toBinaryString(i));

			int j = i;
			int index = 0;
			while(j>0){
				if((j&1)==1){ 	
					//最后一位为1则将对应数加入到当前组合中 
					temp.add(nums[index]);
				}
				index++;
				j=j>>1; //判断了这一位是否为1后, 要右移
			}//while

			result.add(temp); //判断完了一种组合，加入到结果集中  
		}
		return result;
	}

	/**
	 * 2015/05/18
	 * 基于DFS的递归。temp需要实现隔离的功能。
	 * @param nums
	 * @param temp
	 * @param level
	 * @param result
	 * @see http://blog.csdn.net/u012118523/article/details/24884803
	 */
	public void subsets_ref2(int[] nums,LinkedList<Integer> temp,int level,List<List<Integer>> result) {

		LinkedList<Integer> mytemp = new LinkedList<>(temp); //复制一个新的LinkedList，隔离不同分支的操作

		if(level == nums.length){
			result.add(mytemp);
			System.out.println(Arrays.toString(mytemp.toArray()));
			return;
		}

		subsets_ref2(nums,mytemp,level+1,result);//不添加新节点的左子树

		mytemp.add(nums[level]);
		subsets_ref2(nums,mytemp,level+1,result);//添加新节点的右子树
	}



	/**
	 * 使用递归，迭代更新
	 * @param nums
	 * @param index
	 * @return
	 */
	public List<List<Integer>> subsets_ref3(int[] nums,int index) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		if(index==nums.length){
			LinkedList<Integer> temp = new LinkedList<Integer>();
			result.add(temp);
		}else{
			int a = nums[index]; //扣留元素
			List<List<Integer>> subResult = subsets_ref3(nums,index+1);
			
			for(int i=0;i<subResult.size();i++){
				LinkedList<Integer> sublist1 = new LinkedList<Integer>(subResult.get(i));//原列表
				result.add(sublist1);
				
				//向子集中添加扣留元素
				LinkedList<Integer> sublist2 = new LinkedList<Integer>(sublist1);//新列表
				sublist2.add(0,a);
				result.add(sublist2);
			}
		}
		return result;
	}


	public static void main(String[] args) {
		P078_Subsets test = new P078_Subsets();
		int[] nums ={9,12,17};



		//------------------------Test1-----------------------
		//		List<List<Integer>> result = test.subsets_ref1(nums);

		/*
		 	9 , 
			12 , 
			9 , 12 , 
			17 , 
			9 , 17 , 
			12 , 17 , 
			9 , 12 , 17 , 
		 */

		//------------------------Test2-----------------------
		//		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		//		LinkedList<Integer> temp = new LinkedList<Integer>();
		//		test.subsets_ref2(nums, temp, 0, result);

		/*
			17 , 
			12 , 
			12 , 17 , 
			9 , 
			9 , 17 , 
			9 , 12 , 
			9 , 12 , 17 , 		
		 */

		//------------------------Test3-----------------------
		List<List<Integer>> result = test.subsets_ref3(nums,0);

		//-----------------------------------------------
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" , ");
			}
			System.out.println();
		}

	}

}
