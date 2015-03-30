package com.Basic.Algorithm;

public class CommonUtil {


	/*
	 * Definition for binary tree
	 * 二叉树节点定义
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/**
	 * 打印数组
	 * @param a
	 * @param n
	 * @param i
	 */
	public static void printArray(int a[], int n ,int i){  
		System.out.print(i+":");
		for(int j= 0; j<8; j++){  
			System.out.print(a[j]+" ");
		}  
		System.out.println();
	}  
}
