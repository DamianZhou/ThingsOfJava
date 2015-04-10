package jiuduOJ;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author DamianZhou
 * @see http://ac.jobdu.com/problem.php?pid=1388
 */
public class P1388_JumpFloor {

	private static int getWays(int n){
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else
			return getWays(n-1)+getWays(n-2);
	}
	public static void main(String[] args) {

				System.out.println(getWays(3));
//		Scanner in = new Scanner(System.in);
//		int n=in.nextInt();
//		System.out.println(getWays(n));	

	}

}
