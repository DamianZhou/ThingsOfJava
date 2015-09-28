package bestcode;

import java.util.Scanner;

/**
 * 
 * @author Damian
 * @http://acm.acmcoder.com/showproblem.php?pid=2017
 */
public class P2017_StringCal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str= null ;
		while( n-- > 0 ){
			str = in.next();
			int count =0;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)>='0' && str.charAt(i)<='9')
					count++;
			}
			System.out.println(count);
		}
		

	}

}
