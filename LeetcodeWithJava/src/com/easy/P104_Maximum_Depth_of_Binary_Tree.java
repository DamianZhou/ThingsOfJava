package com.easy;

import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class P104_Maximum_Depth_of_Binary_Tree {
	
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else{
        	int left  = 1+maxDepth(root.left);
        	int right = 1+maxDepth(root.right);
        	return Math.max(left, right);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
