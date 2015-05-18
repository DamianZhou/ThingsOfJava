package Others.dp;

import java.util.Arrays;

public class MaxSubSum {
	/**
	 * 子数组最大的和，输出子数组
	 * @param nums
	 * @return
	 */
	int[] getmaxsubsum(int nums[]){
		if(nums == null || nums.length==0) return null;

		int currentSum=nums[0],maxSum=nums[0];
		int i=0,temp=0,start=0,end=0;
		for(i=1;i<nums.length;i++){
			if(currentSum+nums[i]>nums[i]){
				currentSum+=nums[i];
			}else{
				temp=i;
				currentSum=nums[i];
			}

			if(currentSum>maxSum){
				maxSum=currentSum;
				start=temp;
				end=i;
			}
			
			System.out.println("start="+start+"   "+"end="+end);
		}	
		return Arrays.copyOfRange(nums, start, end+1);
	}

	public static void main(String[] args) {
		MaxSubSum test = new MaxSubSum();
		
//		int[] nums = {1,2,3,-4,3,1,1};
		int[] nums = {1};
 		int[] result = test.getmaxsubsum(nums);
 		
 		System.out.println(Arrays.toString(result));

	}

}
