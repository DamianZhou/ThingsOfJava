package com.common;

public class CommonComponents {

	/**
	 * unsigned int 转化为 二进制格式的字符串
	 * @param n
	 * @return
	 */
	public static String IntToBinaryString(int n){
		String str="";
		int left=0;
		while(n>1){
			left = n%2;
			str=left+str;
			n= (n-left)/2;
		}

		str=n+str;
		return str;

	}

	/**
	 * 二分查找
	 * @param num
	 * @param start
	 * @param end
	 * @param target
	 * @return
	 */
	public static int BinarySearch(int[]num,int start,int end,int target){
		if(num[start]>target || num[end]<target)
			return -1;

		int mid=(start+end)>>>1;
		if(num[mid]==target)
			return mid;
		else if(num[mid]>target){
			end=mid-1;
			return BinarySearch(num, start, end, target);
		}else{
			start=mid+1;
			return BinarySearch(num, start, end, target);
		}

	}
	/**
	 * Definition for binary tree
	 * 二叉树节点定义
	 */
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; left=null;right=null;}
	}
	/**
	 * 打印 树
	 * @param root
	 */
	public static void printTree(TreeNode root){
		if(root==null) return;
		System.out.print(root.val+"-->");
		printTree(root.left);
		printTree(root.right);
	}

}
