package com.medium;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class P105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal extends CommonComponents {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		return buildTreeIntern(preorder, inorder, 0, 0, preorder.length);

	}

	public static TreeNode getNode(int[] preorder,int p1,int p2,int[] inorder,int i1,int i2){
		int value=preorder[p1];
		int pos=-1;
		for(int i=i1;i<=i2;i++){
			if(inorder[i]==value){
				pos=i;
				break;
			}
		}
		
		TreeNode node = new TreeNode(value);
		node.left=getNode(preorder,p1+1,p1+(pos-i1),inorder,i1,i1+pos-1);
		node.right=getNode(preorder,p1+(pos-i1)+1,p2,inorder,i1+pos+1,i2);
		
		return node;
	}

	/**
	 * 将下标转换成 size 传递
	 * @param preorder
	 * @param inorder
	 * @param preIndex
	 * @param inIndex
	 * @param size
	 * @return
	 */
	private static TreeNode buildTreeIntern(int[] preorder, int[] inorder, int preIndex, int inIndex, int size) {
	    if(size <= 0) {
	      return null;
	    }

	    TreeNode rv = new TreeNode(preorder[preIndex]);

	    for(int i = 0; i < size; i++) {
	      if(preorder[preIndex] == inorder[inIndex + i]) {
	        rv.left = buildTreeIntern(preorder, inorder, preIndex + 1, inIndex, i);
	        rv.right = buildTreeIntern(preorder, inorder, preIndex + i + 1, inIndex + i + 1, size - i - 1);
	        break;
	      }
	    }
	    return rv;
	  }
	
	
	
	public static void main(String[] args) {
		int[] preOrder={5,3,1,2,8,6,9};
		int[] inOrder={1,3,2,5,6,8,9};

		TreeNode ans = buildTree(preOrder, inOrder);

		printPreOrder(ans);

	}

}
