package Practice.HeadToOffice;

import java.util.Stack;

public class P22_StackOrder {
	
	/**
	 * 判断是栈的弹出顺序
	 * @param 栈压入顺序 nums1
	 * @param 栈弹出顺序 nums2
	 * @return
	 */
	boolean isStackOrder(int[] nums1,int[] nums2){
		
		if(nums1 == null || nums2==null)
			return false;
		
		int i=0,j=0;
		Stack<Integer> stack = new Stack<Integer>();
		int temp=-1;
		while( i<nums1.length && j<nums2.length ){
			
			if( i<nums1.length && nums1[i] == nums2[j]){
				//当前值正好相等
				i++;
				j++;
			}else{
				if(stack.size()==0){
					//栈为空，直接压入
					stack.push(nums1[i]);
					i++;
				}else{
					//栈非空，判断栈顶是够可用
					temp = stack.peek();
					if(temp==nums2[j]){
						stack.pop();
						j++;
					}else{
						stack.push(nums1[i]);
						i++;						
					}
				}
			}//else 当前值不等
		}//while
		
		if(j==nums2.length)
			return true;
		else{
				while(stack.size()>0){
					temp = stack.pop();
					if( temp == nums2[j] )
						j++;
					else
						return false;
				}
				if(j==nums2.length)
					return true;
				else
					return false;
		}
	}
	
	public static void main(String[] args) {
		P22_StackOrder test = new P22_StackOrder();
		
		int[] nums1 = {1,2,3,4,5};
//		int[] nums2 = {4,5,3,2,1};
		int[] nums2 = {4,3,5,1,2};		
		System.out.print( test.isStackOrder(nums1, nums2) );

	}

}
