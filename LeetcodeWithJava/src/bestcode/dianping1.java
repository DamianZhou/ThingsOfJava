package bestcode;

import java.util.Scanner;


public class dianping1 {
	
	public int getNum(int m){
		if(m<1)
			return 0;
		else if(m==1 || m==2)
			return 1;
		else if(m==3)
			return 2;
		else
			return 2*getNum(m-2)+getNum(m-3);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		if(m<1)
			return;
		int n_2=1;
		int n_1=1;
		int n  =2;
		int val = 0;
		for(int i=1;i<=3;i++){
			val = i<3?1:2;
			System.out.println("第"+i+"个月的兔子对数:"+val);
		}
		
		for(int i=4;i<=m;i++){
			val = n_2+2*n_1;
			System.out.println("第"+i+"个月的兔子对数:"+val);
			n_2=n_1;
			n_1=n;
			n = val;
		}
			

	}

}
