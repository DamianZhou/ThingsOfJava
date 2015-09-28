package bestcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Qunar_t2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		HashSet<Integer> set3 = new HashSet<Integer>();
		int temp = Integer.MIN_VALUE;
		
		int len1 = input.nextInt();
		while( len1-- >0 ){
			temp = input.nextInt();
			set1.add(temp);
		}
		
		int len2 = input.nextInt();
		while(len2-- > 0){
			temp = input.nextInt();
			if(set1.contains(temp))
				set2.add(temp);
		}
		
		int len3 = input.nextInt();
		while(len3-- > 0){
			temp = input.nextInt();
			if(set2.contains(temp))
				set3.add(temp);
		}
		
		if(set3.size()==0){
			System.out.println("");
			return;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>(set3);
		Collections.sort(result);
		for(int i=0;i<result.size();i++){
			if(i==0)
				System.out.print(result.get(i));
			else
				System.out.print(" "+result.get(i));
		}
		System.out.println();
	}
}
