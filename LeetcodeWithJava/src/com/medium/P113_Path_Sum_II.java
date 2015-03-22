package com.medium;

import java.util.LinkedList;
import java.util.List;

import com.common.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /     / \
          11  13  4
         /  \        / \
        7    2    5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * 
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/path-sum-ii/
 */
public class P113_Path_Sum_II {

	public List<List<Integer>> pathSum1(TreeNode root, int sum) {
		if(root==null)
			return null;

		return null;

	}	

	public void getSumWithPath(TreeNode root, int sum){

	}

	//参考--------------------------------------------------------------------------

	public static List<List<Integer>> ans; //二维链表

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		ans = new LinkedList<List<Integer>>();
		helper (new LinkedList<Integer>(),root,sum);
		return ans;
	}

	public static void helper  (List<Integer> l , TreeNode root, int sum){
		if (root ==null) return;
		l.add(root.val);
		if (root.left==null && root.right==null && root.val==sum){
			ans.add(new LinkedList<Integer>(l));
		}else{
			//先序遍历
			helper (l,root.left, sum-root.val); //每次对sum作减法
			helper (l,root.right, sum-root.val);
		}
		l.remove(l.size()-1);//删除最后一个元素
	}


	public static void main(String[] args) {
		TreeNode t1 =  new TreeNode(5);
		TreeNode t2 =  new TreeNode(4);
		TreeNode t3 =  new TreeNode(8);
		TreeNode t4 =  new TreeNode(11);
		TreeNode t5 =  new TreeNode(13);
		TreeNode t6 =  new TreeNode(4);
		TreeNode t7 =  new TreeNode(7);
		TreeNode t8 =  new TreeNode(2);
		TreeNode t9 =  new TreeNode(1);
		TreeNode t10 =  new TreeNode(5);

		t1.left=t2; t1.right=t3;
		t2.left=t4;
		t3.left=t5;t3.right=t6;
		t4.left=t7;
		t4.right=t8;
		t6.right=t9;
		t6.left=t10;

		List<List<Integer>> test=pathSum(t1, 22);
		System.out.print(test.get(0).toString());
	}

}
