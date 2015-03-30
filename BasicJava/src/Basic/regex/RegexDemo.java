package Basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String str1="hdfs://192.168.129.63:9000/txt_to_orc/out/2008/20150323170646/SH000003/2008";
		String str2="hdfs://192.168.129.63:9000/txt_to_orc/stockout/20150326095734/SH120482/SH120482";

//		String pattern = "(.*)(SH[0-9]{6})/([0-9]{4})(.*)";
		String pattern1 = "(.*)(SH[0-9]{6})/([0-9]{4})$";
		String pattern2 = "(.*)(SH[0-9]{6})/SH([0-9]{6})$";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern2);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(str2);
		
	      if (m.find( )) {
	          System.out.println("Found value: " + m.group(0) );
	          System.out.println("Found value: " + m.group(1) );
	          System.out.println("Found value: " + m.group(2) );
	          System.out.println("Found value: " + m.group(3) );
	          
	          String filepath=m.group(1)+m.group(2)+"/"+(Integer.parseInt(m.group(3))-1); //获取上一个文件名
	          System.out.println(filepath);
	       } else {
	          System.out.println("NO MATCH");
	       }

	}

}
