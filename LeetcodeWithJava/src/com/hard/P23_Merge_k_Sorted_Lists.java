package com.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.common.CommonComponents;
import com.common.ListNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class P23_Merge_k_Sorted_Lists {

	/**
	 * 2015/05/09
	 * 使用堆来获取最小值
	 * 时间复杂度 O( nk*logk )
	 * 入堆中的复杂度为O（logk）
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		ListNode current = head;
		int len = lists.length;

		if(len==0) return null;

		PriorityQueue<ListNode> pqueue = new PriorityQueue<>(len, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});

		//初始化堆
		for(int i=0;i<len;i++){
			if(lists[i]!=null)
				pqueue.add(lists[i]);
		}
		if(pqueue.size()==0) return null; //全是空链表

		head=pqueue.poll();
		current=head;
		if(current.next!=null)
			pqueue.add(current.next);

		ListNode temp;
		while(pqueue.size()>0){
			temp = pqueue.poll();
			if(temp.next!=null)
				pqueue.add(temp.next);
			current.next=temp;
			current=current.next;
		}
		current.next=null;

		return head;
	}

	/**
	 * 使用分治的方法，两两进行二路归并【此处是非递归】
	 * 相对于同时取队列头，避免了排序比较的步骤
	 * @param lists
	 * @return
	 * 
	 * @see http://www.cnblogs.com/TenosDoIt/p/3673188.html
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode head = null;
		int len = lists.length;
		if(len==0) return null;
		
		while(len>1){ //此时的len表示，还需要归并的链表数
			int step = (len+1)/2;
			for(int i=0;i<len/2;i++){
				lists[i] = merge2Lists(lists[i], lists[i+step]);
			}
			len = step;
		}
		return lists[0];
	}

	/**
	 * 二路归并
	 * @return
	 */
	public ListNode merge2Lists(ListNode head1,ListNode head2){

		if(head1==null) return head2;
		if(head2==null) return head1;
		
		ListNode result;
		ListNode temp;
		ListNode t1 = head1;
		ListNode t2 = head2;
		
		//初始化
		if(t1.val<t2.val){
			result = t1;
			t1=t1.next;
		}else{
			result = t2;
			t2=t2.next;			
		}
		temp=result;
		
		while(t1!=null && t2!= null){
			if(t1.val<t2.val){
				temp.next = t1;
				t1=t1.next;
			}else{
				temp.next = t2;
				t2=t2.next;			
			}
			temp=temp.next;
		}
		
		if(t1!=null)
			temp.next=t1;
		else
			temp.next=t2;

		return result;   
	}

	public static void main(String[] args) {
		P23_Merge_k_Sorted_Lists test = new P23_Merge_k_Sorted_Lists();

		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);

		ListNode node11 = new ListNode(4);
		ListNode node12 = new ListNode(7);
		ListNode node13 = new ListNode(10);
		ListNode node14 = new ListNode(13);
		head1.next=node11;
		node11.next=node12;
		node12.next=node13;
		node13.next=node14;


		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(8);
		ListNode node23 = new ListNode(11);
		ListNode node24 = new ListNode(14);
		head2.next=node21;
		node21.next=node22;
		node22.next=node23;
		node23.next=node24;

		ListNode node31 = new ListNode(6);
		ListNode node32 = new ListNode(9);
		ListNode node33 = new ListNode(12);
		ListNode node34 = new ListNode(15);

		head3.next  =node31;
		node31.next=node32;
		node32.next=node33;
		node33.next=node34;

		//		CommonComponents.printList(head1);
		//		CommonComponents.printList(head2);
		//		CommonComponents.printList(head3);

		
		ListNode[] lists = new ListNode[]{head1,head2,head3};
		ListNode result ;

		//---------------------------------------

		//		result = test.mergeKLists(lists);
		//		CommonComponents.printList(result);

//		result = test.mergeKLists(new ListNode[3]);
//		CommonComponents.printList(result);
		
		//---------------------------------------
				
				result = test.mergeKLists2(lists);
				CommonComponents.printList(result);
		
	}

}
