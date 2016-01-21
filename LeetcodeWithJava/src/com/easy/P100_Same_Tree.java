package com.easy;

import com.common.TreeNode;

public class P100_Same_Tree {
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
     
    	if(p == null && q == null)
    		return true;
    	else if( p==null || q==null || p.val != q.val)
    		return false;
    	else
    		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
