package Basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class Test {
	
	private static void  testArray(){
		int[] num = {1,2,3,4,6,9,7};
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
	}

	public static void main(String[] args) {

		long[] list = new long[5];
		list[0]=1024;
		
		for(int i=1;i<5;i++){
			list[i]=list[i-1]*1024;
			System.out.println(list[i]);
		}
		
		BigDecimal bd = new BigDecimal("1.8485E8");
		System.out.println(bd.divide(BigDecimal.valueOf(1000000)));
		
		String str = "SH124665,2014-11-05_00:00:00,2,1.787,0.000,1.787,21.440,107.2,107.2,107.2,107.2,1000,1072000.0,107.2";
		
		System.out.println(str.split(",")[0]);
		
		testArray();
		
		System.out.println((new Date()).toString());
		System.out.println((new Date()).toLocaleString());
		System.out.println((new Date()).toGMTString());
		
		
		
		
	}

}
