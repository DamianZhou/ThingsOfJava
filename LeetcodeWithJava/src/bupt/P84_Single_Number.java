package bupt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author DamianZhou
 * @see http://code.bupt.edu.cn/problem/p/84/
 */
public class P84_Single_Number {

	private static void getSingle(){
		Scanner in = new Scanner(System.in);
		int n=0;
		long[] nums;
		long temp;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while(in.hasNext()){
			n=in.nextInt();
			for(int i=0;i<n;i++){
				temp = in.nextLong();
				if(map.containsKey(temp))
					map.put(temp, map.get(temp)+1);
				else
					map.put(temp, 1);
			}
			Iterator<Long> it =map.keySet().iterator(); 
			while(it.hasNext()){
				temp=it.next();
				if(map.get(temp)==1){
					System.out.println(temp);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		getSingle();
	}

}
