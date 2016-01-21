package com.easy;

import com.common.ListNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class P237_Delete_Node_in_a_Linked_List {

    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
