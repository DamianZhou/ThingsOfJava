package bestcode;

import java.util.Scanner;

public class Baidu_1 {

	public static boolean isX(int value){

		if(value%7==0)
			return true;

		int v = 0;
		while(value>0){
			v = value%10;
			if(v==7)
				return true;
			value = (value-v)/10;
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		while(!(m==0 && n==0 && k==0)){
			boolean LToR = true;
			int hitCount = 0;
			int base = m;
			int addNum = 2*(n-m);
			while(hitCount<k){
				base += addNum;
				if(Baidu_1.isX(base)){
					hitCount++;
//					System.out.println("base="+base+" addNum="+addNum+" hitcount="+hitCount);
					if(hitCount == k)
						break;
				}
				LToR = !LToR;
				if(LToR)
					addNum = 2*(n-m);
				else
					addNum = 2*m-2;
				
				if(m==1 || m==n)
					addNum = 2*n-2;
				
			}
			System.out.println(base);
			
			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();
		}



	}

}
