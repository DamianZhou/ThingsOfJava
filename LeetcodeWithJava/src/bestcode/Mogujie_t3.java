package bestcode;

import java.util.BitSet;
import java.util.Scanner;

public class Mogujie_t3 {
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int p = in.nextInt();
		int n = in.nextInt();
		int[] basketball = new int[n];
		for(int i=0;i<n;i++)
			basketball[i] = in.nextInt();
		
		BitSet hasBall = new BitSet(n+1);
		hasBall.set(0, n, false);
		
		int count = 0 ;
		int val = -1;
		for(int num : basketball){
			val = num%p;
			if(!hasBall.get(val)){
				hasBall.set(val);
				count++;
			}else
				break;
		}
		System.out.println(++count);
	}
}
