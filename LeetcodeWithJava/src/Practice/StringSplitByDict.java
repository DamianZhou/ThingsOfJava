package Practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringSplitByDict {

	private static int getNum(Set<String> set, String str) {
		int len=str.length();
		int[] num=new int[len+1];

		for(int i=1;i<=len;i++)
			if(set.contains(str.substring(0,i)))
				num[i]=1;
			

		for(int i=1;i<=len;i++){
			for(int j=i-1;j>=0;j--){
				if(set.contains(str.substring(j,i))){
					num[i]=(num[i]+num[j])%10000;
				}
			}
		}
		return num[str.length()];
	}
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		cin.nextLine();

		Set<String> set=new HashSet<String>();//去重

		for(int i=0;i<=T-1;i++){
			set.add(cin.nextLine());
		}

		String str=cin.nextLine();
		System.out.println(getNum(set,str));

	}

}
