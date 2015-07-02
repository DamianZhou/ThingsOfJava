package com.medium;

import java.util.Arrays;
import java.util.LinkedList;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author zhoucaidong
 * @see https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class P230_Kth_Smallest_Element_in_a_BST {

	/**
	 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 * 
	 * The optimal runtime complexity is O(height of BST).
	 * 暂未优化...
	 */
	
	
	/**
	 * 20150702
	 * @param root
	 * @param k
	 * @return
	 */
    public int kthSmallest(TreeNode root, int k) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	midOrder(root, list);
    	
    	System.out.println(Arrays.toString(list.toArray()));
    	
		return list.get(k-1);
    }
    
    void midOrder(TreeNode root,LinkedList<Integer> sb){
    	if(root== null)
    		return;
    	midOrder(root.left, sb);
    	sb.add(root.val);
    	midOrder(root.right, sb);
    }
	
	public static void main(String[] args) {
		P230_Kth_Smallest_Element_in_a_BST test = new P230_Kth_Smallest_Element_in_a_BST();
		
		TreeNode root = CommonComponents.getBSTree();
		System.out.println(test.kthSmallest(root, 5));

	}

}
