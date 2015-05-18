package com.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
	 * 打印 树
	 * @param root
	 */
	public static void printTree(TreeNode root){
		if(root==null) return;
		System.out.print(root.val+"-->");
		printTree(root.left);
		printTree(root.right);
	}

	/**
	 * 获得一棵树
	 * @return
	 */
	public static TreeNode getTree(){
		TreeNode root = new TreeNode(3);
		TreeNode c9 = new TreeNode(9);
		TreeNode c20 = new TreeNode(20);
		TreeNode c15 = new TreeNode(15);
		TreeNode c7 = new TreeNode(7);

		root.left=c9;
		root.right=c20;
		c20.left=c15;
		c20.right=c7;

		return root;
	}
	
	public static TreeNode getBSTree(){
		TreeNode root = new TreeNode(10);
		TreeNode c5 = new TreeNode(5);
		TreeNode c15 = new TreeNode(15);
		TreeNode c3 = new TreeNode(3);
		TreeNode c7 = new TreeNode(7);
		TreeNode c13 = new TreeNode(13);
		TreeNode c19 = new TreeNode(19);
		TreeNode c6 = new TreeNode(6);
		TreeNode c9 = new TreeNode(9);

		root.left=c5;
		root.right=c15;
		c5.left=c3;
		c5.right=c7;
		c15.left=c13;
		c15.right=c19;
		c7.left=c6;
		c7.right=c9;

		return root;
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {	 // 一次读入一行，直到读入null为文件结束
				System.out.println("line " + line + ": " + tempString);  // 显示行号
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close(); //关闭文件
				} catch (IOException e1) {
				}
			}
		}
	}
	
	/**
	 * 打印单链表
	 * @param head
	 */
	public static void printList(ListNode head){
		ListNode temp = head ;
		while(temp!=null){
			System.out.print(temp.val+" ---> ");
			temp=temp.next;
		}
		System.out.println();
	}

}
