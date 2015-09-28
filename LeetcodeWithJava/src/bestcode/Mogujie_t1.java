package bestcode;

import java.util.Scanner;

public class Mogujie_t1 {

	public static boolean isP(StringBuilder str){
		int i = 0;
		int j = str.length()-1;
		while(i<=j){
			if(str.charAt(i) == str.charAt(j)){
				i++;
				j--;
			}else
				return false;
		}
		return true;
	}


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String str = in.next();
		StringBuilder sb = new StringBuilder(str);
		if(sb.length()==1)
			System.out.println("YES");
		else{
			int j=sb.length()-1;
			while(sb.length()>1){
				if(sb.charAt(0) == sb.charAt(j)){
					sb.deleteCharAt(0);
					sb.deleteCharAt(j-1);
					j=sb.length()-1;
				}else{
					break;
				}
			}//while
			if(sb.length()==1 || sb.length()==0)
				System.out.println("YES");
			else{
				boolean l1 = isP(sb.append(sb.charAt(0)));
				sb.delete(sb.length()-1, sb.length());
				boolean l2 = isP(sb.insert(0, sb.charAt(sb.length()-1)));
				if(l1 || l2 )
					System.out.println("YES");
				else
					System.out.println("NO");
			}
				
		}
	}

}
