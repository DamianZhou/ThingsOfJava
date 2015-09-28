package com.easy;

import java.util.ArrayList;
import java.util.List;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/binary-tree-paths/
 */
public class P257_Binary_Tree_Paths {
	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder stb = new StringBuilder();
		if(root == null)
			return result;
		else
			getTreePath(root, result, stb);

		return result;
	}

	public void getTreePath(TreeNode root , ArrayList<String> result , StringBuilder stb){
		String val = null;
		if(stb.length()==0)
			val = ""+root.val;
		else
			val = "->"+root.val;
		
		stb.append(val);
		
		if(root.left == null && root.right==null){
			result.add(stb.toString());
		}else{
			if(root.left!=null)
				getTreePath(root.left, result, stb);
			
			if(root.right!=null)
				getTreePath(root.right, result, stb);
		}
		
		stb.delete(stb.length()-val.length(),stb.length());
	}




	public static void main(String[] args) {
		P257_Binary_Tree_Paths test = new P257_Binary_Tree_Paths();
		
		TreeNode root = CommonComponents.getTree();
		
		List<String> result =  test.binaryTreePaths(root);
		for(String s : result)
			System.out.println(s);
	}

}
