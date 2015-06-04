package newcode;

public class PrintRectangular {

	void printRect(int[][] nums){
		if(nums==null) return;

		int m = nums.length;
		if(m==0) return; //没有元素

		int n = nums[0].length;
		if(n==0) return;//只有空元素

		int midm = m>>1;
		int midn = n>>1;


	}

	void printSubRect(int[][] nums, int m, int n){
		int xlen = nums[0].length - 2*m;
		int ylen = nums.length - 2* n;
		
		int i=m;
		int j=n;

		if(xlen==1){
			for(i=m;j<m+ylen;i++)
				System.out.print(nums[i][j]+" , ");
		}else if(ylen==1){
			for(j=n;j<n+xlen;j++)
				System.out.print(nums[i][j]+" , ");
		}else{
			i=m;
			for(j=n;j<xlen+n;j++)
				System.out.print(nums[i][j]+" , ");

			j=xlen+n-1;
			for(i=m+1;i<ylen+m;i++)
				System.out.print(nums[i][j]+" , ");

			i=m+ylen-1;
			for(j=n+xlen-1-1;j>=n;j--)
				System.out.print(nums[i][j]+" , ");

			j=n;
			for(i=m+ylen-1-1;i>m;i--)
				System.out.print(nums[i][j]+" , ");
		}
	}

	public static void main(String[] args) {
		PrintRectangular test = new PrintRectangular();

//		int[][] nums = {{1,2,3}};
				int[][] nums = {{1},{2},{3}};
		//		int[][] nums = {{1,2},{4,3}};
		//		int[][] nums = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		//		int[][] nums = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7},{17,18,19,20}};


		//		test.printRect(nums);

		test.printSubRect(nums,0,0);
	}

}
