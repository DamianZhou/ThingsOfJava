package Basic.list;

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

	public static void main(String[] args) {
		ListDemo test = new ListDemo();
		test.testListEqual();

	}

}
