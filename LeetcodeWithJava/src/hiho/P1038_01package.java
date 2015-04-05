package hiho;

import java.util.Scanner;


/**
 * [DP]
 * @author DamianZhou
 * @see http://hihocoder.com/problemset/problem/1038
 */
public class P1038_01package {

	/**
	 * 未优化空间，直接采用动态规划
	 * @param need
	 * @param value
	 * @param amount
	 * @return
	 */
	static int getMax(int[] need,int[] value,int amount){
		if(amount<0) return 0;

		int[][] matrix = new int[need.length+1][amount+1];//初始化为0

		int i=0,j=0;
		for(i=1;i<=need.length;i++){
			for(j=0;j<=amount;j++){
				if(j>=need[i-1]){
					int m1=(matrix[i-1][j-need[i-1]]+value[i-1]);	//添加新元素
					int m2=matrix[i-1][j];		//不添加新元素
					matrix[i][j] = Math.max(m1,m2 );
				}
				else
					matrix[i][j] = matrix[i-1][j]; //买不起
			}
		}
		return matrix[need.length][amount];
	}
	
	/**
	 * 优化空间利用
	 * 按照j从M到1的顺序，也就是跟之前相反的顺序来进行计算的话。
	 * 根据我们的状态转移方程，可以显然得出如果状态(iA, jA)依赖于状态(iB, jB)，那么肯定有iA = iB+1, jA>=jB。
	 * ------------> matrix[i][j] 只依赖之前的的数值
	 * 所以不难得出一个结论：我在计算best(i, j)的时候，
	 * 因为best(i, j+1..M)这些状态已经被计算过了，所以意味着best(i - 1, k)，k=j..M这些值都没有用了——所有依赖于他们的值都已经计算完了。
	 * 于是它们原有的存储空间都可以用来存储别的东西，
	 * 所以我不仿直接就将best(i, j)的值存在best(i-1, j)原有的位置上，就像这样。
	 * 
	 * @param need
	 * @param value
	 * @param amount
	 * @return
	 */
	static int getMaxWithMinSpace(int[] need,int[] value,int amount){
		if(amount<0) return 0;
		int[] matrix = new int[amount];
		int i=0,j=0;
		for(i=1;i<=need.length;i++){
			//每个 i  都代表一轮计算
			for(j=amount-1;j>=need[i-1];j--){
				matrix[j] = Math.max(matrix[j], matrix[j-need[i-1]]+value[i-1]);
			}
		}
		return matrix[amount-1];
		
	}

	public static void main(String[] args) {

		//		Scanner in = new Scanner(System.in);
		//		int n=in.nextInt();
		//		int m =in.nextInt();
		//		
		//		int[] need =  new int[n];
		//		int[] value = new int[n];
		////		float[] price = new float[n];
		//		
		//		for(int i=0;i<n;i++){
		//			need[i]=in.nextInt();
		//			value[i]=in.nextInt();
		//		}

		int m=1000;
		int[] need =  {144,487,210,567,1056};
		int[] value= {990,436,673,58,897};

//		int m=50;
//		int[] value =  {60,100,120};
//		int[] need= {10,20,30};
		
		int k= getMax(need, value,m);
		int p = getMaxWithMinSpace(need, value, m);
		System.out.println(k+","+p);


	}

}
