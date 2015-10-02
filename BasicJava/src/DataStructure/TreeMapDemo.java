package DataStructure;

import java.util.TreeMap;

public class TreeMapDemo {
	
	void testTreeMap(){
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		map.put(1, 1);
		
		map.put(11, 11);
		map.put(12, 12);
		map.put(13, 13);
		map.put(14, 14);
		
		map.remove(11);
		
		for(int key : map.keySet()){
			System.out.println(key);
		}
		
	}

	public static void main(String[] args) {
		TreeMapDemo test = new TreeMapDemo();
		test.testTreeMap();

	}

}
