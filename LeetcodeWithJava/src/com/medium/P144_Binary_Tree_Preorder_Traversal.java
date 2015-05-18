package com.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class P144_Binary_Tree_Preorder_Traversal {
    
	/**
	 * 二叉树前序遍历 2015/05/06
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();

		if(root==null) return result;
		
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.add(root);
		while(stack.size()>0){
			temp=stack.pop();
			result.add(temp.val);
			if(temp.right!=null)			
				stack.add(temp.right);
			if(temp.left!=null)
				stack.add(temp.left);
		}
		
		return result;
        
    }
	
	
	public static void main(String[] args) {
		P144_Binary_Tree_Preorder_Traversal test = new P144_Binary_Tree_Preorder_Traversal();
		TreeNode root = CommonComponents.getBSTree();
		List<Integer> result = test.preorderTraversal(root);
		
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));

	}

}
