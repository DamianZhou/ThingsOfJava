package hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 100 days
 * 简单贪心
	首先，补提交卡应该连续使用，其次，补提交卡应该全部用掉（如果补提交卡多于未提交天数则额外处理）
	所以，依次遍历未提交日期，计算：从当前位置开始，用M张补提交卡覆盖后面连续M个数字，此时的连续提交天数。
 * @author DamianZhou
 * @see http://hihocoder.com/problemset/problem/1051
 */
public class P1051_MaxDay {

	public static void main(String[] args) {
		int totalDay = 100;
		Scanner incount = new Scanner(System.in);
		int count = incount.nextInt();
		for(int i = 0;i < count;i++) {
			int  N= incount.nextInt();
			int M = incount.nextInt();
			int[] abDays = new int[N+2];
			for(int j = 1;j <= N;j++){
				abDays[j] = incount.nextInt();
			}
			int res = -1;
			if(M >= N){
				res = totalDay;
				System.out.println(res);
				continue;
			}
			
			abDays[0] = 0;
			abDays[N+1] = totalDay+1;

			int tempMax = res;
			if(M < N)
			{        
				for(int k = M+1;k <= N+1;k++)
				{
					tempMax = abDays[k] - abDays[k-M-1]-1;

					System.out.print(tempMax+"-->");
					
					if(tempMax > res)

						res = tempMax;
				}
			}
			System.out.println();
			System.out.println(res);
		}
		incount.close();
	}
}
