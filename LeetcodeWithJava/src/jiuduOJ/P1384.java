package jiuduOJ;

import java.util.Scanner;

/**
 * 从左到右递增，从上到下递增
 * @author Damian
 * @see http://ac.jobdu.com/problem.php?pid=1384
 * 
 * 1. 使用 BitSet 超时
 */
public class P1384 {

	/**
	 * 
	 * @param num
	 * @param i
	 * @param j
	 * @param flag 横查找标志true，竖查找标志false
	 * @return
	 */
	private static void binarySearch(int[][] num,int t){
		int i=0;
		int j=num.length;
		while(i<=j){
			int mid=(i+j)/2;
			//		System.out.println(num[mid][0]);
			if(num[0][mid]==t){
				System.out.println("Yes");
				return; 
			}
			else if(num[mid][0]>t){
				j=mid-1;
			}else{
				i=mid+1;
			}
		}

		int row=j;
		//结果可能在第j行(取小的)
		i=0;
		j=num[row].length;
		while(i<=j){
			int mid=(i+j)/2;
			//		System.out.println(num[mid]);
			if(num[row][mid]==t){
				System.out.println("Yes");
				return; 
			}
			else if(num[row][mid]>t)
				j=mid-1;
			else
				i=mid+1;
		}
		System.out.println("No");
	}

	public static void main(String[] args) {

		//		int num[] = {1,2,3,4,8};
		//		int[][] num={{	1, 2, 3},
		//				{		4, 5, 6},
		//				{		7, 8, 9}};
		//		System.out.println(binarySearch(num, 6));

		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			int t = in.nextInt();

			int[][] num = new int[m][n];
			int i,j;
			for(i=0;i<m;i++)
				for(j=0;j<n;j++){
					num[i][j]=in.nextInt();
				}
			if(t<num[0][0] || t>num[m-1][n-1])
				System.out.println("No");
			else
				binarySearch(num, t);
		}//while
	}

}
