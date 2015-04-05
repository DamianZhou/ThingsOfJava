package Basic;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {

		long[] list = new long[5];
		list[0]=1024;
		
		for(int i=1;i<5;i++){
			list[i]=list[i-1]*1024;
			System.out.println(list[i]);
		}
		
		BigDecimal bd = new BigDecimal("1.8485E8");
		System.out.println(bd.divide(BigDecimal.valueOf(1000000)));
		
	}

}
