package bestcode;

import com.common.ListNode;

public class Baidu_Jump3 {

	int lastNumber(int n){
		if(n<1)
			return -1;
		else if(n==1)
			return 1;

		int listSize = n;

		ListNode head = null;
		ListNode temp = null;
		for(int i =1; i<=n; i++){
			ListNode node = new ListNode(i);
			if(head == null){
				head = node;
				temp = head;
			}else{
				temp.next = node;
				temp = temp.next;
			}
		}//for
		temp.next = head ; //循环链表

		ListNode pre = head;		
		while(listSize>1){
			pre = pre.next;
			pre.next = pre.next.next;
			listSize--;
			pre = pre.next;
		}
		return pre.val;
	}

	public static void main(String[] args) {
		Baidu_Jump3 test = new Baidu_Jump3();
		int result = test.lastNumber(5);
		System.out.println(result);

		result = test.lastNumber(6);
		System.out.println(result);
		
		result = test.lastNumber(2);
		System.out.println(result);
	}

}
