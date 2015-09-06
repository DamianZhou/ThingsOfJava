package Practice.HeadToOffice;

import java.util.Arrays;

public class P03_findInMatrix {

	/**
	 * 降维处理
	 * 时间复杂度为O(m+n)
	 * @param nums
	 * @param target
	 * @return
	 */
	private String findTarget(int[][] nums, int target){

		if(nums == null)
			return null;
		
		int m = nums.length;
		int n = m>0 ? nums[0].length:0;
		if(m==0 || n==0)
			return null;

		int min = nums[0][0];
		int max = nums[m-1][n-1];
		if(target<min || target>max)
			return null;

		int i=0;
		int j=n-1;
		while(i<m && j>=0){
			if(nums[i][j]==target)
				return i+","+j;
			else if(nums[i][j]>target)
				j--;
			else
				i++;
		}//while
		return null;
	}


	public static void main(String[] args) {

		P03_findInMatrix test = new P03_findInMatrix();

		int[][] nums = {
				{1,2,8,9},
				{2,4,9,2},
				{4,7,10,13},
				{6,8,11,15}
		};

		System.out.println( test.findTarget(nums, 9) );
		System.out.println( test.findTarget(nums, 7) );
		System.out.println( test.findTarget(nums, 11) );
		System.out.println( test.findTarget(nums, 14) );
		System.out.println( test.findTarget(null, 1) );
	}

}
