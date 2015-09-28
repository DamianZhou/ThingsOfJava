package Basic.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ListDemo {
	
	/**
	 * 测试两个List的 equal 方法
	 */
	void testListEqual(){
		
		ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		ArrayList<Integer> bl = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		ArrayList<Integer> cl = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,0));
		
		LinkedList<Integer> dl = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7));
		LinkedList<Integer> el = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,0));
		
		System.out.println("al==bl ? "+al.equals(bl));
		System.out.println("al==cl ? "+al.equals(cl));
		System.out.println("al==dl ? "+al.equals(dl));
		System.out.println("al==el ? "+al.equals(el));
		System.out.println("cl==el ? "+cl.equals(el));
		
	}
	
	
	void checkList(){
		int size = 20;
		ArrayList<Integer> list = new ArrayList<Integer>(50);
		list.ensureCapacity(size); //最小的初始容量
		for(int i=0;i<20;i++)
			list.add(i);
		list.trimToSize();//调整ArrayList的大小到当前size (确保不再调整后调用)
		
		//将list转换为数组
		Integer[] nums = new Integer[list.size()];
		list.toArray(nums);
		
	}
	
	

	public static void main(String[] args) {
		ListDemo test = new ListDemo();
		test.testListEqual();

	}

}
