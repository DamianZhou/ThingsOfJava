package com.medium;

import java.util.LinkedList;

import sun.misc.Queue;

import com.common.CommonComponents;
import com.common.TreeNode;


/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author Damian
 * @see https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class P114_Flatten_Binary_Tree_to_Linked_List {

	static LinkedList<TreeNode> nodelist = new LinkedList<TreeNode>();

	/**
	 * 先序遍历
	 * @param root
	 */
	static void getList(TreeNode root){
		nodelist.add(root);
		if(root.left != null)
			getList(root.left);
		if(root.right!=null)
			getList(root.right);
	}

	/**
	 * 保持root节点的位置不变，交换树节点，交换节点值
	 * @param root
	 */
	public static void flatten(TreeNode root) {
		if(root==null) 
			return;

		getList(root);

		TreeNode newroot = nodelist.removeFirst();
		TreeNode temproot=newroot;

		while(nodelist.size()>0){
			temproot.right=nodelist.removeFirst();
			temproot.left=null;
			temproot=temproot.right;
		}
		temproot.left=temproot.right=null;

		if(newroot!=root){
			temproot=newroot;
			while(temproot.right!=root)
				temproot=temproot.right;

			if(temproot==newroot){
				newroot.right=root.right;
				root.right=newroot;
			}else{
				TreeNode second=newroot.right;
				temproot.right=newroot;
				newroot.right=root.right;
				root.right=second;
			}
			//交换数值
			newroot.val^=root.val;
			root.val^=newroot.val;
			newroot.val^=root.val;
		}
	}

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);


		n1.left=n2;
		n1.right=n5;
		n2.left=n3;
		n2.right=n4;
		n5.right=n6;

		CommonComponents.printTree(n1);
		flatten(n1);

		System.out.println();
		CommonComponents.printTree(n1);
	}

}
