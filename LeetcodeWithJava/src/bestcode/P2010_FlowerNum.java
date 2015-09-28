package bestcode;

import java.util.Scanner;

public class P2010_FlowerNum {

	/**
	 * “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
	 * @param m
	 * @param n
	 */
	public static boolean getFlowerNum(int m,int n){
		boolean flag = false;
		
		int a,b,c;
		int sum=0;
		for(int val=m;val<=n;val++){
			c = val %10;
			b = ((val-c)/10)%10;
			a = val / 100;
			
			sum = a*a*a+b*b*b+c*c*c;
			if(sum==val){
				if(flag)
					System.out.print(" "+val);
				else{
					System.out.print(val);
					flag = true;
				}
			}
		}//for
		return flag;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m,n;
		while(input.hasNextInt()){ 
			m = input.nextInt();
			n = input.nextInt();
			boolean result = P2010_FlowerNum.getFlowerNum(m, n);
			if(!result)
				System.out.println("no");
			else
				System.out.println();
		}//while

	}

}
