package bestcode;

import java.util.Scanner;

public class Qihu360_t2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		while(n-- > 0){
			int politics = in.nextInt();
			int english = in.nextInt();
			int math = in.nextInt();
			int computer = in.nextInt();
			if( politics<60 || english<60 || math<90 || computer<90 )
				System.out.println("Fail");
			else{
				int sum = politics+english+math+computer;
				if(sum<310)
					System.out.println("Fail");
				else if(sum<350)
					System.out.println("Zifei");
				else
					System.out.println("Gongfei");
			}
		}
	}

}
