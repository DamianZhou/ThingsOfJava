package bestcode;

import java.util.HashMap;
import java.util.Scanner;

public class Baidu_t1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String a = in.next();
		String b = in.next();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character ch : b.toCharArray()){
			if(!map.containsKey(ch))
				map.put(ch, 1);
			else{
				int num = map.get(ch);
				map.put(ch, num+1);
			}
		}
		
		for(Character ch:a.toCharArray()){
			if(map.containsKey(ch)){
				int num = map.get(ch);
				num--;
				if(num==0)
					map.remove(ch);
				else
					map.put(ch, num);
			}
		}
		
		if(map.size()==0)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
