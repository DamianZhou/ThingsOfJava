package bestcode;

import java.util.HashSet;
import java.util.Scanner;
/**
 * 
 * @author Damian
 * @see http://acm.acmcoder.com/showproblem.php?pid=2072
 */
public class P2072_CountWords {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while(in.hasNextLine()){
			String[] data  = in.nextLine().split("\\s*");	
			 if( data.length==1 ){
				if("#".equals(data[0]))
					break;
				else if("".equals(data[0]))
					System.out.println( 0 );
				else
					System.out.println( 1 );
			 }else{
				HashSet<String> set = new HashSet<String>();
				for(String val : data)
					if(!"".equals(""))
						set.add(val);
				System.out.println( set.size() );
			}
		}

	}

}
