package bestcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 简易版之最短距离
 * @author Damian
 * @see http://acm.acmcoder.com/showproblem.php?pid=2083
 */
public class P2083_MinLength {

	public static int getMinLength(Object[] nums,int start , int end){
		int len = end+1-start;

		if(len==1)
			return calDIstince(nums, start);
		else if(len==2){
			return Math.min(calDIstince(nums, start), calDIstince(nums, end));
		}else{
			int mid = len >>1;

			int midDistance = calDIstince(nums, mid);
			int leftDistance = calDIstince(nums, mid-1);
			int rightDistance = calDIstince(nums, mid+1);

			if(leftDistance<rightDistance)
				return getMinLength(nums, start, mid-1);
			else if(leftDistance>rightDistance)
				return getMinLength(nums, mid+1, end);
			else
				return midDistance;
		}
	}

	public static int calDIstince(Object[] nums,int start){

		int distance = 0;
		for(int i =0;i<nums.length;i++){
			distance+=Math.abs((int)nums[i]-(int)nums[start]);
		}
		return distance;
	}	

	public static void main(String[] args) {

		//		int[] nums = {1,2,4,80,6 };
		//		System.out.println( P2083_MinLength.getMinLength(nums, 0, nums.length-1) );

		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		String str= null ;
		while( m-- > 0 ){
			int n = in.nextInt();
			
			ArrayList<Integer> numslist = new ArrayList<Integer>(n);
//			int[] nums = new int[n];
//			for(int i=0;i<nums.length;i++)
//				nums[i] = in.nextInt();

			for(int i=0;i<n;i++)
				numslist.add( in.nextInt());

			Collections.sort(numslist);
			Object[] nums = numslist.toArray();
			
			int result = P2083_MinLength.getMinLength(nums, 0, nums.length-1);
			System.out.println( result );

		}//while
	}
}
