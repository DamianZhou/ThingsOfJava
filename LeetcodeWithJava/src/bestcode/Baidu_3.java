package bestcode;

import java.util.Scanner;

public class Baidu_3 {

	public static boolean canHaveX(int x){
		if(x%7==0) return true;
		int left = 0;
		while(x>0){
			left = x%10;
			if(left==7)
				return true;
			x = (x-left)/10;
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n,m,k;
		do{
			n = input.nextInt();
			m = input.nextInt();
			k = input.nextInt();

			boolean flag = true;
			int count = 0;
			int b = m;
			int append = 2*(n-m);
			while(count<k){
				b += append;
				if(Baidu_3.canHaveX(b)){
					count++;
					if(count == k)
						break;
				}
				flag = !flag;
				if(flag)
					append = 2*(n-m);
				else
					append = 2*m-2;
				
				if(m==1 || m==n)
					append = 2*n-2;
				
			}
			System.out.println(b);
		}while(!(m==0 && n==0 && k==0));
	}

}
