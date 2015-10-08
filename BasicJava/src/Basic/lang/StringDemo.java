package Basic.lang;

import java.util.HashMap;

public class StringDemo {
	
	void checkStringInMap(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		String str = "cat cat dog fish";
		String[] words = str.split(" ");
		
		map.put(1, words[0]);
		
		System.out.println(map.get(1));
		System.out.println( words[0].equals(map.get(1)) );
		System.out.println( "cat".equals(map.get(1)) );
		
	}
	

	public static void main(String[] args) {
		StringDemo test = new StringDemo();
		test.checkStringInMap();
	}

}
