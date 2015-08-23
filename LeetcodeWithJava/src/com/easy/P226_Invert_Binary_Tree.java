package com.easy;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/invert-binary-tree/
 */
public class P226_Invert_Binary_Tree {

	/**
	 * 2015/06/23
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
    	
    	if(root==null) 
    		return root;
    	realInvertTree(root);
    	return root;
    }
    
    void realInvertTree(TreeNode root){
    	if(root==null) 
    		return;
    	
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    	realInvertTree(root.left);
    	realInvertTree(root.right);    	
    }
	
	public static void main(String[] args) {
		P226_Invert_Binary_Tree test = new P226_Invert_Binary_Tree();
		
		TreeNode root = CommonComponents.getTree();
		
		CommonComponents.printTree(root);
		
		System.out.println("\n");
		
		TreeNode invertedTree = test.invertTree(root);

		CommonComponents.printTree(invertedTree);

	}

}
