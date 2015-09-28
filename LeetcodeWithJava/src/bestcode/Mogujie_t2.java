package bestcode;

import java.util.Scanner;

public class Mogujie_t2 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int x = in.nextInt();
		int p = in.nextInt();
		int q = in.nextInt();
		
		double result = (double)x*p/(q*(n+1)-n*p);
		
		System.out.println(String.format("%.2f", result));

	}
}
