package Practice.HeadToOffice;

import com.common.ListNode;

public class P16_ReverseList {

	/**
	 * 翻转链表
	 * @param head
	 * @return
	 */
	private ListNode reverseList(ListNode head){
		if(head==null)
			return null;
		
		ListNode newHead = new ListNode(-1);
		ListNode first = null; 
		ListNode tempHead = head;
		
		ListNode temp;
		
		while(tempHead != null){
			// temp取出一个元素
			temp=tempHead;
			tempHead=tempHead.next;
			//添加元素到新链表
			temp.next=first;
			newHead.next=temp;
			first = newHead.next;
		}
		
		return newHead.next;
	}
	
	
	public static void main(String[] args) {
		P16_ReverseList test = new P16_ReverseList();
		
		ListNode head = null;
		
//		head = CommonComponents.getList();
		head = new ListNode(2);
		
		
		ListNode temp=head;
		while(temp!=null){
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
		System.out.println();
		
		head = test.reverseList(head);
		temp=head;
		while(temp!=null){
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
		
		
	}

}
