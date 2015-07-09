package com.easy;

import java.util.Stack;

/**
 * 
 * @author zhoucaidong
 * @see https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class P232_Implement_Queue_using_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Implement Queue using Stacks 
 * @author zhoucaidong
 *
 */
class MyQueue {
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> helperStack = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(stack.size()>0)
        	helperStack.push(stack.pop());
        
        helperStack.pop();
        
        while(helperStack.size()>0)
        	stack.push(helperStack.pop());
    }

    // Get the front element.
    public int peek() {
        while(stack.size()>0)
        	helperStack.push(stack.pop());
        
        int result = helperStack.peek();
        
        while(helperStack.size()>0)
        	stack.push(helperStack.pop());
        
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
		return stack.size()>0?false:true;
    }
}
