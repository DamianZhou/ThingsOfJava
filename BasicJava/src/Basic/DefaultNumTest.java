package Basic;

import java.math.BigDecimal;

public class DefaultNumTest {

	public static void main(String[] args) {
		
		int a = 0;
		long b = 0;
		String c = null;
		System.out.println("Default num is "+a+"---"+b+"---"+c);//必须初始化
		
		//-----------------------------------------------
		
        System.out.println(0.05+0.01);   
        System.out.println(1.0-0.42);   
        System.out.println(4.015*100);   
        System.out.println(123.3/100);   
		
		//-----------------------------------------------
		
		double t = 1.33;
		BigDecimal biga = new BigDecimal(0.05+0.01);
		BigDecimal bigb = new BigDecimal(1.0-0.42);
		BigDecimal bigc = new BigDecimal(4.015*100);
		BigDecimal bigd = new BigDecimal(3);
		BigDecimal bigt = new BigDecimal(t);
		
		BigDecimal bige = new BigDecimal("12.3");
		
		
		if(biga.compareTo(bigb)<0)
			System.out.println("min="+biga.setScale(5, BigDecimal.ROUND_HALF_UP).add(BigDecimal.valueOf(10)));

		System.out.println(biga.add(bigb).add(bigc).divide(bigd));
		

	}

}
