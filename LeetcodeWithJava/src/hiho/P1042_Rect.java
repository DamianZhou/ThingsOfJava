package hiho;

import java.util.Scanner;

/**
 * 
 * @author DamianZhou
 * @see http://hihocoder.com/problemset/problem/1042
 * 
 * n*m
 * 输入
	第一行3个整数：n, m, L (1 <= n, m <= 100, 1 <= L <= 400)
	
	第二行4个整数：l, r, t, b (0 <= l < r <= m, 0 <= t < b <= n)表示水塘的左、右、上、下边界坐标。
	
	输出
	小Hi最大能圈住的面积
 */
public class P1042_Rect {
	public static int getMax(){
		//n*m
		int n,m,L;
		int l,r,t,b;
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		L=in.nextInt();
		
		l=in.nextInt();		r=in.nextInt();
		t=in.nextInt();		b=in.nextInt();
		
		int left=l;
		int right=m-r;
		int top=t;
		int bottom = n-b;
		
		
		if(L<4) 
			return 0;
		return b;		
	}
	
	public static void main(String[] args) {

		

	}

}
