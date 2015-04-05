package com.medium;

import com.common.ListNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/rotate-list/
 */
public class P61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
    	if(k==0) return head;
    	ListNode temp = head;
    	ListNode tail=null;
    	int count=0;
    	while(temp!=null){
    		count++;
    		tail=temp;
    		temp=temp.next;
    	}
    	k=count-k%count;
    	
    	ListNode pre=null;
    	temp=head;
    	while(k>1){
    		temp=temp.next;
    		k--;
    	}
    	pre=temp;
    	
    	tail.next=head;
    	head=pre.next;
    	pre.next=null;  	
		return head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
