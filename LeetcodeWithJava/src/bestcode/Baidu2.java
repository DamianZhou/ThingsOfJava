package bestcode;

import java.util.Scanner;

public class Baidu2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int left = n;
		int all = n;
		while(left>2){
			int free = left/3;
			all+=free;
			left = left%3 + free;
		}
		System.out.println(all);

	}

}
