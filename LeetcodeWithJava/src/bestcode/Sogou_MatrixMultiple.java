package bestcode;

import java.util.Scanner;

public class Sogou_MatrixMultiple {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		long[][] nums = new long[n+1][m+1];
		
		
		for(int i=0;i<n;i++){
			for(int j = 0 ;j<m ; j++){
				nums[i][j] = in.nextLong();
			}
		}
		
		//横向最大值
		for(int i=0;i<n;i++){
			long temp = 1l;
			for(int j=0;j<m;j++){
				temp = temp*nums[i][j];
			}
			nums[i][m] = temp;
		}
		
		//纵向最大值
		for(int j=0;j<m;j++){
			long temp = 1l;
			for(int i=0;i<n;i++){
				temp = temp*nums[i][j];
			}
			nums[n][j] = temp;
		}
		
		long max = Long.MIN_VALUE;
		

		for(int i = 0; i<n ; i++){
			for(int j=0;j<m;j++){
				long temp = (nums[i][m]/nums[i][j])*(nums[n][j]/nums[i][j]);
				max = max<temp?temp:max;
			}
		}
		System.out.println(max);
		
	}

}
