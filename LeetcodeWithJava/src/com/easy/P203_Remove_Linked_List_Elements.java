package com.easy;

import com.common.ListNode;

/**
 * 1. 如果val 连续出现，必须将其一起删掉
 * @author DamianZhou 2015、04、30
 * @see https://leetcode.com/problems/remove-linked-list-elements/
 */
public class P203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
    	
    	if(head==null) return null;
    	
    	ListNode pre,temp;
    	pre = head;
    	temp=pre.next;
    	//先忽略头结点，直接处理后面的值，最后处理头结点
    	while(temp!=null){
    		while(temp!=null && temp.val==val){
    			temp=temp.next;
    		}    		
    		// temp 为null 或者 指向一个非val节点
    		pre.next=temp;
    		if(temp==null) break;
    		else{
    			pre=temp;
    			temp=temp.next;
    		}
    	}
    	
    	if(head.val==val)
    		head=head.next;
		return head;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(2);
		
		a.next=b;
		b.next=c;
		c.next=d;
		
		P203_Remove_Linked_List_Elements test = new P203_Remove_Linked_List_Elements();
		
		test.removeElements(a, 1);

	}

}
