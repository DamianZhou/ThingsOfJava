package com.medium;

import java.util.LinkedList;
import java.util.List;

import com.common.CommonComponents;
import com.common.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {
	/**
	 * 2015/05/18
	 * 之字访问二叉树
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		if(root==null) return result;

		LinkedList<TreeNode> contain = new LinkedList<>();
		LinkedList<TreeNode> t_contain = new LinkedList<>();

		boolean flag=true; //	true从左到右，false从右到左
		LinkedList<Integer> list;
		TreeNode temp = root;
		contain.add(temp);

		while(contain.size()>0){
			list = new LinkedList<Integer>();
			if(flag){
				//从左到右输出
				while(contain.size()>0){
					temp=contain.poll();
					list.add(temp.val);
					if(temp.left!=null)
						t_contain.push(temp.left);
					if(temp.right!=null)
						t_contain.push(temp.right);
				}
				flag=false;
			}else{
				//从右到左输出
				while(contain.size()>0){
					temp=contain.poll();
					list.add(temp.val);
					if(temp.right!=null)
						t_contain.push(temp.right);
					if(temp.left!=null)
						t_contain.push(temp.left);
				}
				flag=true;
			}
			result.add(list);
			LinkedList<TreeNode> t_swap = contain;
			contain = t_contain;
			t_contain = t_swap;
		}

		return result;

	}
	public static void main(String[] args) {
		P103_Binary_Tree_Zigzag_Level_Order_Traversal test = new P103_Binary_Tree_Zigzag_Level_Order_Traversal();
//		TreeNode root = CommonComponents.getTree();
		TreeNode root = CommonComponents.getBSTree();
		
		 List<List<Integer>> result = test.zigzagLevelOrder(root);
		 
		 for(int i=0;i<result.size();i++){
			 for(int j=0;j<result.get(i).size();j++){
				 System.out.print(result.get(i).get(j)+" , ");
			 }
			 System.out.println();
		 }

	}

}
