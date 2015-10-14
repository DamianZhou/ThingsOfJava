package bestcode;

import java.util.Scanner;

public class NetEase_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		int x0 = in.nextInt();
		int y0 = in.nextInt();
		
		int damage = 0;
		
		int len2_1 = (x0-x1)*(x0-x1)+(y0-y1)*(y0-y1);
		int len2_2 = (x0-x2)*(x0-x2)+(y0-y2)*(y0-y2);
		int len2_3 = (x0-x3)*(x0-x3)+(y0-y3)*(y0-y3);
		
		if(len2_1<=R*R)
			damage++;
		if(len2_2<=R*R)
			damage++;
		if(len2_3<=R*R)
			damage++;
		
		System.out.println(damage+"X");

	}

}
