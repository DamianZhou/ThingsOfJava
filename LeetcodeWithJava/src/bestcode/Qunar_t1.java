package bestcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Qunar_t1 {
	
	public static Comparator<String> comparator = new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			String[] str1 = o1.split("\\.");
			String[] str2 = o2.split("\\.");
			
			int v1 = Integer.parseInt(str1[0]);
			int v2 = Integer.parseInt(str2[0]);
			if(v1!=v2)
				return v2 - v1;
			
			v1 = Integer.parseInt(str1[1]);
			v2 = Integer.parseInt(str2[1]);
			return v2-v1;
		}
	};

	public static void main(String[] args) {
		ArrayList<String> valueList = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=0;i<n;i++)
			valueList.add(input.next());
		Collections.sort(valueList, comparator);
		String result = "no stable available";
		for(String val : valueList){
			int num = Integer.parseInt( val.split("\\.")[1]);
			if(num%2==0){
				result = val;
				break;
			}
		}
		System.out.println(result);
	}
}
