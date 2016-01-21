package bestcode;

import java.util.Scanner;

public class CMCC_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++){
			String str=in.nextLine();
			System.out.println(getKNum(str));
		}

		//path.printDistance();
	}

	private static int getKNum(String m) {
		if(m.length()==1){
			return 1;
		}else if(m.length()==2){
			return 2;
		}
		int num[]=new int[m.length()+1];
		num[0]=0;
		num[1]=1;
		num[2]=2;
		for(int i=3;i<=m.length();i++){
			num[i]=num[i-1]+num[i-2];
		}
		return num[m.length()];
	}
}