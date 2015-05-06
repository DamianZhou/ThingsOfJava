package com.easy;

import java.util.LinkedList;
import java.util.List;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 二叉树按层遍历
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class P102_Binary_Tree_Level_Order_Traversal  {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		if(root==null) return new LinkedList<List<Integer>>();
		
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
		
		LinkedList<Integer> tlist =  new LinkedList<Integer>();
		TreeNode temp;
		
		list1.add(root);
		while(list1.size()>0){
			temp=list1.remove(0);
			tlist.add(temp.val);
			if(temp.left!=null)
				list2.add(temp.left);
			if(temp.right!=null)
				list2.add(temp.right);
			
			if(list1.size()==0 && list2.size()>0){
				ans.add(tlist);
				tlist = new LinkedList<Integer>();
				while(list2.size()>0)
					list1.add(list2.remove(0));
			}
		}//while
		ans.add(tlist);
		return ans;
	}

	public static void main(String[] args) {
		TreeNode root = CommonComponents.getTree();
		levelOrder(root);

	}

}
