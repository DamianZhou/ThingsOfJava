package com.easy;

import com.common.TreeNode;

/**
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * 判断所有的路径的结点和有没有指定的sum
 * 
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /     / \
          11  13  4
         /  \          \
        7    2         1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/path-sum/
 */
public class P112_Path_Sum {

	static boolean flag=false;

	public boolean hasPathSum(TreeNode root, int sum) {

		if(root==null)
			return false;
		getSum(root, sum);
		return flag;
	}

	public static void getSum(TreeNode root, int sum){
		int temp=root.val;
		if(root.left==null && root.right==null && root.val==sum) {//得到指定的值
			flag=true;
			return;
		}
		else{
			if(root.left!=null){
				root.left.val += temp;
				getSum(root.left,sum);
			}
			if(root.right!=null){
				root.right.val += temp;
				getSum(root.right,sum);
			}
		}
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
		
		t1.left=t2; t1.right=t3;
		t2.left=t4;
		t3.left=t5;t3.right=t6;
		t4.left=t7;
		t4.right=t8;
		t6.right=t9;
		
		getSum(t1, 28);
		if(flag)
			System.out.println("OK");
		else
			System.out.println("NO");
		
		

	}

}







