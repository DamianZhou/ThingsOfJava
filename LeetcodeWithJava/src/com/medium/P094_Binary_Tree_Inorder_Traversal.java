package com.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class P094_Binary_Tree_Inorder_Traversal {

	/**
	 * 中序遍历
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	if(root==null) return result;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	pushToStack(root, stack);
    	TreeNode temp;
    	while(stack.size()>0){
    		temp = stack.pop();
    		result.add(temp.val);
    		if(temp.right!=null)
    			pushToStack(temp.right, stack);
    	}
		return result;
    }
    
    void pushToStack(TreeNode node,Stack<TreeNode> stack){
    	TreeNode temp = node;
    	while(temp!=null){
    		stack.push(temp);
    		temp=temp.left;
    	}
    }
	
	public static void main(String[] args) {
		P094_Binary_Tree_Inorder_Traversal test = new P094_Binary_Tree_Inorder_Traversal();
		
		TreeNode root = CommonComponents.getBSTree();
		
		List<Integer> result = test.inorderTraversal(root);
		
		System.out.print(Arrays.toString( result.toArray()));
		
		
	}

}
