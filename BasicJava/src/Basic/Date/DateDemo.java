package Basic.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
	     // 初始化 Date 对象
	       Date date = new Date();
	       
	       SimpleDateFormat ft1 =  new SimpleDateFormat ("yyyy-MM-dd  hh:mm:ss");
	       SimpleDateFormat ft2 =  new SimpleDateFormat ("yyyy-MM-dd  HH:mm:ss:SS");//添加微秒
	       SimpleDateFormat ft3 =  new SimpleDateFormat ("G E D F W w yyyy-MM-dd  hh:mm:ss a zzz");
	       SimpleDateFormat ft4 =  new SimpleDateFormat ("E yyyy-MM-dd  hh:mm:ss a zzz");
	       SimpleDateFormat ft5 =  new SimpleDateFormat ("E yyyy-MM-dd  hh:mm:ss a zzz");
	        
	       // 使用 toString() 函数显示日期时间
	       System.out.println(date.toString());
	      
	       System.out.println("Current Date: " + ft1.format(date));
	       System.out.println("Current Date: " + ft2.format(date));
	       System.out.println("Current Date: " + ft3.format(date));
	}

}
