package com.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class P145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	LinkedList<Integer> result = new LinkedList<Integer>();

		if(root==null) return result;
		
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.add(root);
		while(stack.size()>0){
			temp=stack.pop();
			result.addFirst(temp.val); //插入到前面
			if(temp.left!=null)
				stack.add(temp.left);
			if(temp.right!=null)			
				stack.add(temp.right);
		}
		
		return result;       
    }
    
    
	public static void main(String[] args) {
		P145_Binary_Tree_Postorder_Traversal test = new P145_Binary_Tree_Postorder_Traversal();
		TreeNode root = CommonComponents.getBSTree();
		List<Integer> result = test.postorderTraversal(root);
		
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));

	}

}
