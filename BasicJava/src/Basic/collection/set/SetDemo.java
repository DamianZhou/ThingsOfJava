package Basic.collection.set;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
	
	/**
	 * bit位
	 * 与集合无关
	 */
	void bitSetDemo(){
		
		BitSet bs = new BitSet(63);	//64
		
		BitSet[] bsArray = new BitSet[2]; 
		
		bs.set(20);
		
		bsArray[0] = new BitSet();			//64
		bsArray[1] = new BitSet(111);	//128
		
		System.out.println(bs.size());
		System.out.println(bsArray[0].size());
		System.out.println(bsArray[1].size());
		
	}
	
	/**
	 * Hash集合
	 */
	void hashSetDemo(){
		HashSet<Integer> hs = new HashSet<>(20);
		hs.add(22);
		hs.add(88);
		
		for(int e : hs)
			System.out.println(e);
	}
	
	/**
	 * 记录插入顺序的集合
	 * 红黑树实现
	 */
	void TreeSetDemo(){
		TreeSet<Integer> ts = new TreeSet<>( Arrays.asList(1,2,3,4,5) ) ;
		
		ts.add(22);
		ts.add(88);
		
		for(int e : ts)
			System.out.println(e);
	}
	
	void LinkedHashSetDemo(){
		LinkedHashSet<Integer> ls = new LinkedHashSet<>(20);
		ls.add(22);
		ls.add(88);
		
		for(int e : ls)
			System.out.println(e);
	}
	
	
	
	
	

	public static void main(String[] args) {
		SetDemo test = new SetDemo();
		
		
//		test.bitSetDemo();
		test.TreeSetDemo();

	}

}
