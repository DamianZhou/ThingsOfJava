package bestcode;

import java.util.Scanner;

public class CCMC_1 {
	
	public static String getReverse(String str){
		StringBuilder stb = new StringBuilder(str);
		
		int i = 0;
		int j = stb.length()-1;
		subReverse(stb, i, j);
		
		i=0;
		j=0;
		for(int t=0;t<stb.length();t++){
			if(stb.charAt(t)!=' ')
				continue;
			if(t == stb.length()-1 && i==0)
				break;
			j=t-1;
			subReverse(stb, i, j);
			i=j+2;
		}
		
		return stb.toString();
	}
	
	
	public static void subReverse(StringBuilder stb,int i,int j){
		char temp;
		while(i<j){
			temp = stb.charAt(i);
			stb.setCharAt(i, stb.charAt(j));
			stb.setCharAt(j, temp);
			i++;
			j--;
		}
	}
	
	
	public static String quickGetReverse(String str){
		StringBuilder stb = new StringBuilder();
		String[] strs = str.split(" ");
		for(int i=strs.length-1;i>=0;i--){
			stb.append(strs[i]);
			if(i!=0)
				stb.append(' ');
		}
		return stb.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String[] strs = new String[n];
		
		for(int i=0;i<n;i++){
			String temp = in.nextLine();
			strs[i] = quickGetReverse(temp);
		}
		
		for(String s : strs)
			System.out.println(s);
	}

}
