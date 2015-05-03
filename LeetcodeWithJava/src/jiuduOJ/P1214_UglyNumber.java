package jiuduOJ;

import java.util.Scanner;

/**
 * 2015/04/25
 * @author Damian
 * @see http://ac.jobdu.com/problem.php?pid=1214
 *  
 */
public class P1214_UglyNumber {

	/**
	 * 1为第一个丑数
	 * 2,3,5
	 * @param index
	 * @return
	 */
	static int getUgly(int index){
		int[] uglyNum = new int[index+5];
		uglyNum[0]=1;
		uglyNum[1]=2;
		uglyNum[2]=3;
		uglyNum[3]=4;
		uglyNum[4]=5;
		
		
		if(index<=5) return uglyNum[index-1];
		
		//表示分别乘以 2，3，5以后，大于当前最大丑数的值的下标
		int ugly2Index = 2;
		int ugly3Index = 1;
		int ugly5Index = 1;
		
		int temp = 5;
		int newUgly=-1;
		while(temp<index){
			newUgly = Math.min(2*uglyNum[ugly2Index], Math.min(3*uglyNum[ugly3Index], 5*uglyNum[ugly5Index])); 
			uglyNum[temp-1]=newUgly;
			while(2*uglyNum[ugly2Index] <= newUgly ) ugly2Index++;
			while(3*uglyNum[ugly3Index] <= newUgly ) ugly3Index++;
			while(5*uglyNum[ugly5Index] <= newUgly ) ugly5Index++;
			temp++;
		}
		
		return newUgly;
		
	}
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n;
//		while(in.hasNext()){
//			n=in.nextInt();
//			System.out.println(getUgly(n));
//		}
//		System.out.println(getUgly(6));
		System.out.println(getUgly(1500));
	}

}
