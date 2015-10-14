package bestcode;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class dianping2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String str = "" ;
		while(in.hasNext()){
			str = in.next();
			if(str.equals("quit"))
				break;
			if(!map.containsKey(str))
				map.put(str, 1);
			else
				map.put(str, map.get(str)+1);
		}
		
		for(Entry<String, Integer> element : map.entrySet()){
			System.out.println(element.getKey()+":"+element.getValue());
		}
		
	}

}
