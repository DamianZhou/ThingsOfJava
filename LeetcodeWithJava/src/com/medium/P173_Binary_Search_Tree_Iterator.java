package com.medium;

import java.util.Stack;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class P173_Binary_Search_Tree_Iterator {

	public static void main(String[] args) {

		TreeNode root = CommonComponents.getBSTree();
		BSTIterator i = new BSTIterator(root);

		while(i.hasNext()){
			System.out.println(i.next());
		}

	}

}

/**
 * 实现二叉搜索树的 迭代器 2015/05/06
 * @author DamianZhou
 *
 */
class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		pushToStack(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return stack.size()>0?true:false;

	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp = stack.pop();
		if(temp.right!=null)
			pushToStack(temp.right);
		return temp.val;
	}

	/**
	 * 将左子树的节点添加到栈（递归地）
	 * @param node
	 */
	private void pushToStack(TreeNode node){
		TreeNode temp = node;
		while(temp!=null){
			stack.push(temp);
			temp=temp.left;
		}
	}
}