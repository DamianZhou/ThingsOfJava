package com.medium;

import com.common.CommonComponents;
import com.common.ListNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/partition-list/
 */
public class P086_Partition_List {
	
    public ListNode partition(ListNode head, int x) {
    	if(head==null)
    		return null;
    	ListNode small = new ListNode();
    	ListNode big   = new ListNode();
    	
    	ListNode h1 = small;
    	ListNode h2 = big;
    	
    	ListNode temp = head;
    	while(temp!=null){
    		if(temp.val<x){
    			h1.next=temp;
    			temp=temp.next;
    			h1=h1.next;
    			h1.next=null;
    		}else{
    			h2.next=temp;
    			temp=temp.next;
    			h2=h2.next;
    			h2.next=null;    			
    		}
    	}
    	h1.next=big.next;
    	return small.next;
    }
    
    public static void main(String[] args){
    	
    	P086_Partition_List test = new P086_Partition_List();
    	ListNode head = CommonComponents.getList();
    	ListNode temp = head;
    	while(temp!=null){
    		System.out.print(temp.val+"-->");
    		temp=temp.next;
    	}
    	
    	System.out.println();
    	ListNode result = test.partition(head, 16);
    	
    	temp = result;
    	while(temp!=null){
    		System.out.print(temp.val+"-->");
    		temp=temp.next;
    	}
    	System.out.println("OK");
    }

}
