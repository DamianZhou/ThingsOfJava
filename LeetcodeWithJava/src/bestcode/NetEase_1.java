package bestcode;

import java.util.Scanner;

public class NetEase_1 {

	/*
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int HP1 = in.nextInt();
		int HP2 = in.nextInt();
		int A1 = in.nextInt();
		int A2 = in.nextInt();
		int t = in.nextInt();
		
		int skillToP2 = 0;
		int sklllToP1 = 0;
		
		while(t-- > 0){
			String p1 = in.next();
			String p2 = in.next();

			if(p1.equals("B")) //没有技能护盾
				skillToP2 = 2;
			
			if(p2.equals("B")){
				skillToP2 = 0; //消除致盲状态
				sklllToP1 = 1; //护盾状态,防护1次
			}
			
			if(p1.equals("A") && sklllToP1<=0) //没有攻击护盾
				HP2 -= A1;
			
			if(p2.equals("A") && skillToP2<=0) //没有致盲
				HP1 -= A2;
			
			sklllToP1--;
			skillToP2--;
			
			
			System.out.println("HP1="+HP1+",HP2="+HP2);
			if(HP1<=0 || HP2<=0)
				break;
		}
		
		if(HP1>HP2)
			System.out.println("NO");
		else
			System.out.println("YES");
		
	}

}
