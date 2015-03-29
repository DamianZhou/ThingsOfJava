package com.medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class P24_Swap_Nodes_in_Pairs {

    public static ListNode swapPairs(ListNode head) {
    	
    	if (head==null || head.next==null){
    		return head;
    	}
    	
    	ListNode node = null;
    	ListNode temp = null;
    	
    	//首先设置新的Head
    	if (head.next!=null){
    		temp=head;
    		head=head.next;
    		temp.next=head.next;
    		head.next=temp;
    	}
    	
    	node=head.next;	//记录待交换节点的地址
    	while(node.next!=null && node.next.next!= null){
    		temp=node.next;
    		node.next=temp.next;
    		temp.next=node.next.next;
    		node.next.next=temp;
    		
    		node=node.next.next;//调整node位置
    	}
    	
		return head;
        
    }
    
	public static void printListNode(ListNode node){
		System.out.print(node.val+"-->");
		if (node.next!=null)
			printListNode(node.next);
	}
	
	
	public static void main(String[] args) {
		ListNode n1= new ListNode(1);
		ListNode n2= new ListNode(2);
		ListNode n3= new ListNode(3);
		ListNode n4= new ListNode(4);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		printListNode(n1);
		System.out.println();
		ListNode ln=swapPairs(n1);
		
		printListNode(ln);
	}

}

/*
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
