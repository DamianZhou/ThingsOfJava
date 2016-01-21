package com.easy;

import com.common.CommonComponents;
import com.common.ListNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/odd-even-linked-list/
 */
public class P328_Odd_Even_Linked_List {
	
    public ListNode oddEvenList(ListNode head) {
    	if(head==null)
    		return null;
    	ListNode oddhead = null;
    	ListNode evenhead = null;
    	ListNode oddnode = null;
    	ListNode evennode = null;
    	ListNode temp = head;
    	
    	while(temp != null){
    		if(oddhead == null && evenhead == null){
    			oddhead = temp;
    			evenhead = temp.next;
    			oddnode = oddhead;
    			evennode = evenhead;
    		}else{
	    		oddnode.next = temp;
	    		evennode.next = temp.next;
	    		oddnode = oddnode.next;
	    		evennode = evennode.next;
    		}
    		if(evennode != null)
    			temp = evennode.next;
    		else
    			temp = null;
    	}
    	oddnode.next=evenhead;
		return oddhead;
        
    }

	public static void main(String[] args) {
		P328_Odd_Even_Linked_List test = new P328_Odd_Even_Linked_List();
		
		ListNode head = CommonComponents.getList();
//		ListNode head = new ListNode(3);
		
		ListNode result = test.oddEvenList(head);
		
		ListNode t = result;
		while(t!=null){
			System.out.println(t.val);
			t=t.next;
		}

	}

}
