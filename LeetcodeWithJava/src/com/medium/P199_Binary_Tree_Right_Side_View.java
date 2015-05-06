package com.medium;

import java.util.LinkedList;
import java.util.List;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class P199_Binary_Tree_Right_Side_View {

	/**
	 * 只读右节点，没有每层都读取
	 * @param root
	 * @return
	 */
	public static List<Integer> rightSideView_err(TreeNode root) {
		TreeNode temp = root;
		LinkedList<Integer> list =  new LinkedList<Integer>();
		while(temp!=null){
			list.add(temp.val);
			temp=temp.right;
		}

		return list;

	}

	/**
	 * 按层遍历
	 * 取最左边的元素用 Stack
	 * 取最右边的元素用 Queue
	 * @param root
	 * @return
	 */
	public static List<Integer> rightSideView(TreeNode root) {
		TreeNode temp = root;
		LinkedList<Integer> list =  new LinkedList<Integer>();
		if(root==null) return list;

		LinkedList<TreeNode> pqueue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> cqueue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue = null; 
		cqueue.add(temp);

		while(cqueue.size()>0){
			//首先切换 栈 
			queue=cqueue;
			cqueue=pqueue;
			pqueue=queue;
			while(pqueue.size()>0){
				temp = pqueue.poll();
				if(pqueue.size()==0) 
					list.add(temp.val);
				if(temp.left!=null)
					cqueue.add(temp.left);
				if(temp.right!=null)
					cqueue.add(temp.right);   		
			}
		}

		return list;
	}
	public static void main(String[] args) {
		TreeNode root = CommonComponents.getTree();
		rightSideView(root);

	}

}
