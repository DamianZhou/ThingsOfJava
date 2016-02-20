package com.medium;

import java.util.ArrayList;
import java.util.Stack;

import com.common.CommonComponents;
import com.common.TreeNode;

public class P236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	
	/**
	 * 左右都包含【待查找结点】的节点，一般是唯一的
	 * https://leetcode.com/discuss/45386
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor_s1(TreeNode root, TreeNode p, TreeNode q) {
		System.out.println(root==null?"--":root.val);
		
	    if (root == null || root == p || root == q) //如果是末尾或者是目标节点，就返回
	    	return root;
	    TreeNode left  = lowestCommonAncestor_s1(root.left, p, q);
	    TreeNode right = lowestCommonAncestor_s1(root.right, p, q);
	    
	    //如果左边为null，则返回右边
	    //如果左边非空，右边为null，则返回左边
	    //如果左右都非空，则返回根节点
	    return left == null ? right : (right == null ? left : root);
	}
	
	
	
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null || p==null || q==null)
			return null;
		//		ArrayList<TreeNode> list2 = getAncestor(root, q); 
		//		ArrayList<TreeNode> list1 = getAncestor(root, p);

		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		getAncestor_re(root, p,list1);
		ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
		getAncestor_re(root, q,list2); 

		if(list1==null || list2==null)
			return null;

		int i=0;
		while(i<list1.size() && i<list2.size() && list1.get(i)==list2.get(i))
			i++;
		return list1.get(i-1);
	}


	void getAncestor_re(TreeNode root, TreeNode node ,ArrayList<TreeNode> list){
		list.add(root);
		if(root==node)
			return;
		if(root.left==null && root.right==null)
			return;

		if(root.left!=null)
			getAncestor_re(root.left, node, list);
		if(root.right!=null)
			getAncestor_re(root.right, node, list);

		list.remove(list.size()-1);
	}

	/**
	 * 深度优先遍历查找节点
	 * @param root
	 * @param node
	 * @return
	 */
	ArrayList<TreeNode>  getAncestor(TreeNode root, TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		pushNewNode(stack, temp);
		while(stack.size()>0){
			temp = stack.pop();
			if(temp==node){
				ArrayList<TreeNode> list = new ArrayList<TreeNode>(stack);
				list.add(temp);
				return list;
			}

			if(temp.right!=null){
				pushNewNode(stack, temp.right);
			}

		}
		return null;
	}

	void pushNewNode(Stack<TreeNode> stack,TreeNode node){
		if(node==null)
			return;
		TreeNode temp = node;
		stack.push(temp);
		while(temp.left!=null){
			temp=temp.left;
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		P236_Lowest_Common_Ancestor_of_a_Binary_Tree test = new P236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		TreeNode root = CommonComponents.getBSTree();

		TreeNode t9 = root.left.right.right;
		TreeNode t3 = root.left.left;

		TreeNode result = test.lowestCommonAncestor_s1(root, t3, t9);
		System.out.println(result.val);
	}

}
