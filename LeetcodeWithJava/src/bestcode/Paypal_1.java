package bestcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Paypal_1 {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			Queue<Integer> player1 = new LinkedList<Integer>();
			Queue<Integer> player2 = new LinkedList<Integer>();
			
			int k = cin.nextInt();
			while(k-- > 0 )
				player1.add( cin.nextInt());
			
			k = cin.nextInt();
			while(k-- > 0)
				player2.add(cin.nextInt());
			
			getPlayResult(player1, player2);
		}

	}
	
	public static void getPlayResult(Queue<Integer> player1,Queue<Integer> player2){
		
		int a,b;
		
		int count = 0;
		
		while(player1.size()>0 && player2.size()>0 && count++ <1500){
			a = player1.poll();
			b = player2.poll();
			
			if(a>b){
				player1.add(b);
				player1.add(a);
			}else{
				player2.add(a);
				player2.add(b);
			}

		}
		
		if(player1.size()==0)
			System.out.println(count+" "+2);
		else if(player2.size()==0)
			System.out.println(count+" "+1);
		else
			System.out.println(-1);
		
	}

}
