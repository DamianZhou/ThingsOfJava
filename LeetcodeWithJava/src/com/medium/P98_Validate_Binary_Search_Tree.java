package com.medium;

import java.util.Stack;

import com.common.CommonComponents;


/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
		The left subtree of a node contains only nodes with keys less than the node's key.
		The right subtree of a node contains only nodes with keys greater than the node's key.
		Both the left and right subtrees must also be binary search trees.
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * {10,5,15,#,#,6,20}
 * 
 * @author Damian
 * @see https://leetcode.com/problems/validate-binary-search-tree/
 */
public class P98_Validate_Binary_Search_Tree extends CommonComponents {

	public static boolean isValidBST(TreeNode root) {
		if(root==null) 
			return true;
		else
			return checkBinarySearchTree(root);   
	}

	/**
	 * 错误：单纯的比较单个节点，无法判断整棵树
	 * @param root
	 * @return
	 */
	static boolean checkBinarySearchTree(TreeNode root){	
		if(root.left==null && root.right==null)
			return true;
		else if(root.left!=null && root.right==null){
			if(root.val >root.left.val)
				return checkBinarySearchTree(root.left);
		}else if(root.left==null && root.right!=null){
			if(root.val<root.right.val)
				return checkBinarySearchTree(root.right);
		}else{
			if(root.val>root.left.val && root.val<root.right.val)
				return (checkBinarySearchTree(root.left) && checkBinarySearchTree(root.right));
		}
		return false;
	}

	//参考---------------------------------------------------
	static Stack stack = new Stack();

	public static void inOrder(TreeNode root){

		if(root != null){
			inOrder(root.left);
			stack.push(root.val);
			inOrder(root.right);
		}
	} 

	/**
	 * 先序遍历，所有右边的值都在后面！
	 * @param root
	 * @return
	 */
	public static boolean isValidBST2(TreeNode root){

		if(root == null){
			return true;
		}

		inOrder(root);
		int i = (int) stack.pop();

		while(!stack.isEmpty()){
			int j = (int) stack.pop();
			if(i <= j){
				return false;
			}
			i = j;
		}

		return true;
	}


	public static void main(String[] args) {

		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);


		n2.left=n1;
		n2.right=n3;

		n3.right=n5;
//		n3.left=n6;

		if(isValidBST2(n2))
			System.out.println("OK");
		else
			System.out.println("NO");


	}

}
