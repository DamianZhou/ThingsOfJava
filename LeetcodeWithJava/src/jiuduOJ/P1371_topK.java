package jiuduOJ;

import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * 
 * @author Damian
 * @see http://ac.jobdu.com/problem.php?pid=1371
 */
public class P1371_topK {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n,k;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		while(in.hasNext()){
			n=in.nextInt();
			k=in.nextInt();
			int[] num = new int[n];
			for(int i=0;i<n;i++){
				num[i]=in.nextInt();
				heap.add(in.nextInt());
			}
			//---------
			Object[] ans=heap.toArray();
			for(Object o:ans)
				System.out.println(o.toString());
		}

	}

}
