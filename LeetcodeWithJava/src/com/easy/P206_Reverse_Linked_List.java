package com.easy;

import java.util.LinkedList;
import java.util.Stack;

import com.common.ListNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/reverse-linked-list/
 */
public class P206_Reverse_Linked_List {

	/**
	 * 旋转单链表 2015/05/06
	 * 使用栈
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
    	
    	Stack<ListNode> stack = new Stack<ListNode>();
    	
    	ListNode temp = head;
    	while(temp!=null){
    		stack.push(temp);
    		temp=temp.next;
    	}
    	
    	if(stack.size()==0)
    		return null;
    	else{
    		head = stack.pop();
    		temp = head;
    		while(stack.size()>0){
    			temp.next=stack.pop();
    			temp = temp.next;
    		}
    		temp.next=null;
    	}
    	return head;
    }
    
	public static void main(String[] args) {
		P206_Reverse_Linked_List test = new P206_Reverse_Linked_List();
		
		ListNode head = new ListNode(Integer.MAX_VALUE);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		
		
//		ListNode result = test.reverseList(head);
		ListNode result = test.reverseList(null);
		ListNode temp = result;
		while(temp!=null){
			System.out.print(temp.val +" --> ");
			temp=temp.next;
		}

	}

}
