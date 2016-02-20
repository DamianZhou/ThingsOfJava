package com.easy;

import java.util.ArrayList;


import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class P235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null || p==null || q==null)
    		return null;
    	ArrayList<TreeNode> list1 = getAncestor(root, p);
    	ArrayList<TreeNode> list2 = getAncestor(root, q); 
    	
    	if(list1==null || list2==null)
    		return null;
    	
    	int i=0;
    	while(i<list1.size() && i<list2.size() && list1.get(i)==list2.get(i))
    		i++;
		return list1.get(i-1);
    }
    
    ArrayList<TreeNode> getAncestor(TreeNode root, TreeNode node){
    	
    	 ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    	 TreeNode temp = root;
    	 while(temp.val!=node.val && temp!=null){
    		 list.add(temp);
    		 if(temp.val>node.val)
    			 temp = temp.left;
    		 else
    			 temp = temp.right;
    	 }
    	if(temp==null)
    		return null;
    	else{
    		list.add(temp);
    		return list;
    	}
    }
    
	public static void main(String[] args) {
		P235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree test = new P235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
		TreeNode tree = CommonComponents.getBSTree();
		TreeNode t3 = tree.left.left;
		TreeNode t9 = tree.left.right.right;
		
		TreeNode result = test.lowestCommonAncestor(tree, t3, t9);
		System.out.println(result.val);
	}

}
