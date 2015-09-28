package Practice.HeadToOffice;

public class P20_printRect {

	private void printRect(int[][] nums){
		if(nums == null)
			return;
		int m=nums.length;
		if(nums[0]==null)
			return;
		int n = nums[0].length;
		
		subPrintRect(nums, 0, 0, m-1, n-1);
	}
	
	/**
	 * 回型打印
	 * @param nums
	 * @param ll
	 * @param lr
	 * @param rl
	 * @param rr
	 */
	private void subPrintRect(int[][] nums, int ll, int lr ,int rl ,int rr){
		
		if(ll>rl || lr>rr)
			return;
		int temp=-1;
		if(ll == rl){
			//单行
			temp=lr;
			while(temp<=rr){
				System.out.print(nums[ll][temp]+",");
				temp++;
			}
		}else if(lr==rr){
			//单列
			temp = rl;
			while(temp>=ll){
				System.out.print(nums[temp][rr]+",");
				temp--;
			}
		}else{
			//多行多列
			temp = lr;
			while(temp<=rr){
				System.out.print(nums[ll][temp]+",");	
				temp++;
			}
			temp = ll+1;
			while(temp<=rl){
				System.out.print(nums[temp][rr]+",");	
				temp++;
			}
			temp = rr-1;
			while(temp>=lr){
				System.out.print(nums[rl][temp]+",");	
				temp--;
			}
			temp = rl-1;
			while(temp>ll){
				System.out.print(nums[temp][ll]+",");	
				temp--;
			}
			subPrintRect(nums, ll+1, lr+1, rl-1, rr-1);
		}
	}
	
	public static void main(String[] args) {
		
		P20_printRect test = new P20_printRect();
		
//		int[][] nums = {
//				{1,2,8,9},
//				{2,4,9,2},
//				{4,7,10,13},
//				{6,8,11,15}
//		};

//		int[][] nums = {
//				{1,2,8,9}
//		};

		int[][] nums = {
				{1},
				{2},
				{8},
				{9}
		};
		
		test.printRect(nums);

	}

}
