package jiuduOJ;

import java.util.Scanner;

/**
 * 
 * @author Damian
 * @see http://ac.jobdu.com/problem.php?pid=1370
 */
public class P1370_MoreThanHalf {

	public static int checkHalf(int[] nums){
		if(nums.length==0) return -1;
		if(nums.length==1) return nums[0];
		int number=-1;
		int count = 0;
		for(int i=0;i<nums.length;i++){
			if(count==0) number=nums[i];
			if(nums[i]==number)
				count++;
			else
				count--;
		}
		if(count>0)
			return number;
		else
			return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		int i=0;
		while(in.hasNext()){
			n=in.nextInt();
			int[] num = new int[n];
			for(i=0;i<n;i++){
				num[i]=in.nextInt();
			}
			System.out.println(checkHalf(num));
		}
	}
}
