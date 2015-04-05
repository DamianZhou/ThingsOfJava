package com.medium;

import java.util.LinkedList;
import java.util.List;

import com.common.*;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class P95_Unique_Binary_Search_Trees_II {
	
	/**
	 * 
	 * @param n
	 * @return
	 * @see https://leetcode.com/discuss/24305/divide-and-conquer-f-i-g-i-1-g-n-i
	 */
	public List<TreeNode> generateTrees(int n) {
	    return generateSubtrees(1, n);
	}

	private List<TreeNode> generateSubtrees(int s, int e) {
	    List<TreeNode> res = new LinkedList<TreeNode>();
	    if (s > e) {
	        res.add(null); // empty tree
	        return res;
	    }

	    for (int i = s; i <= e; ++i) {
	        List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
	        List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

	        for (TreeNode left : leftSubtrees) {
	            for (TreeNode right : rightSubtrees) {
	                TreeNode root = new TreeNode(i);
	                root.left = left;
	                root.right = right;
	                res.add(root);
	            }
	        }
	    }
	    return res;
	}
	public static void main(String[] args) {

	}

}
