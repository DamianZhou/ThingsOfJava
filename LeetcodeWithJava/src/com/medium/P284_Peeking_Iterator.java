package com.medium;

import java.util.ArrayList;
import java.util.Iterator;

import com.common.ListNode;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/peeking-iterator/
 */
public class P284_Peeking_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PeekingIterator implements Iterator<Integer> {
	ListNode head = null;
	ListNode temp = null;
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		while(iterator.hasNext()){
			int data = iterator.next();
			if(head==null){
				head = new ListNode(data);
				temp = head;
			}else{
				temp.next = new ListNode(data);
				temp = temp.next;
			}
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(head == null)
			return null;
		else
			return head.val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(hasNext()){
			temp = head;
			head = head.next;
			return temp.val;
		}else
			return null;
	}

	@Override
	public boolean hasNext() {
		if(head == null)
			return false;
		else
			return true;
	}
}
