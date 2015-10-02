package com.medium;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/house-robber-ii/
 * @see https://leetcode.com/problems/house-robber/
 */
public class P213_House_Robber_II {


	/**
	 * 2015/09/28 采用截断的方式，转化为两个直线
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if(nums == null || nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		else if(nums.length==2)
			return Math.max(nums[0], nums[1]);

		// nums >= 3

		int[] values = new int[nums.length];
		//打劫第一家,放弃最后一家
		values[0] = nums[0];
		values[1] = nums[0];
		for(int i =2;i<nums.length-1;i++){
			values[i] = Math.max(values[i-2]+nums[i], values[i-1]);
		}
		int value1 = values[nums.length-2];

		//放弃第一家,保留最后一家
		Arrays.fill(values, 0);
		values[0] = 0;
		values[1] = nums[1];
		for(int i =2;i<nums.length;i++){
			values[i] = Math.max(values[i-2]+nums[i], values[i-1]);
		}
		int value2 = values[nums.length-1];
		return Math.max(value1, value2);
	}

	/**
	 * 2015/05/21 未完成
	 * 不能盗取连续两家、环形数组
	 */
	public int rob_fail(int[] nums) {
		int len = nums.length;
		if(len<1) 
			return 0;
		else if(len==1)
			return nums[0];
		else if(len==2)
			return Math.max(nums[0], nums[1]);

		//确保 len>=3
		int[] bigNums = Arrays.copyOf(nums, len*2);
		System.arraycopy(nums, 0, bigNums, len, len);

		int maxSum=0;


		return maxSum;
	}


	/**
	 * 简单的直线盗窃
	 * @param nums
	 * @return
	 */
	int oldRob(int[] nums){
		int len = nums.length;
		if(len<1) 
			return 0;
		else if(len==1)
			return nums[0];
		else if(len==2)
			return Math.max(nums[0], nums[1]);

		int sub1=nums[0];
		int sub2=Math.max(nums[0], nums[1]);
		int temp=0;
		System.out.println(sub1+" , "+sub2);

		for(int i=2;i<nums.length;i++){
			temp=Math.max(sub2,sub1+nums[i] );
			sub1=sub2;
			sub2=temp;

			System.out.println(sub1+" , "+sub2);
		}
		return sub2;
	}

	/**
	 * 2015/05/21
	 * 对于任一个节点，可以分为两种情况：盗窃 和 不盗窃
	 * 因而可以从第一个节点开始考虑：盗窃0 和 放弃 0。
	 * 盗窃 0 的时候，len-1 位置必须放弃
	 * 放弃 0 的时候，len-1 可以被盗窃
	 * @param nums
	 * @return
	 * @see https://leetcode.com/discuss/36544/simple-ac-solution-in-java-in-o-n-with-explanation
	 */
	public int rob_ref(int[] nums) {
		if (nums.length == 1) return nums[0];
		return Math.max(rob_helper(nums, 0, nums.length - 2), rob_helper(nums, 1, nums.length - 1)); //比较是否添加第一个节点
	}

	int rob_helper(int[] num, int lo, int hi) {
		int include = 0, exclude = 0;
		for (int j = lo; j <= hi; j++) {
			int i = include, e = exclude;

			include = e + num[j]; //添加当前点,忽略上一个点
			exclude = Math.max(e, i); //比较 添加当前点 和 添加上一个点 的得失
		}
		return Math.max(include, exclude);
	}


	/**
	 * 
	 * @param nums
	 * @return
	 * @see https://leetcode.com/discuss/36456/twice-pass-solution-c
	 */
	public int rob_ref2(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];

		//rob nums[0] && do not rob nums[len-1]
		int pre1 = 0, cur1 = 0;
		for(int i = 0; i < nums.length - 1; ++i ) {
			int temp = pre1;
			pre1 = cur1;
			cur1 = Math.max(temp + nums[i], pre1);
		}

		//not rob nums[0] && rob nums[len-1]
		int pre2 = 0, cur2 = 0;
		for(int i = 1; i < nums.length; ++i ) {
			int temp = pre2;
			pre2 = cur2;
			cur2 = Math.max(temp + nums[i], pre2);
		}

		return Math.max(cur1, cur2);
	}

	public static void main(String[] args) {
		P213_House_Robber_II test = new P213_House_Robber_II();

		int[] nums = {3,4,5,1,2};

		//		int result = test.oldRob(nums);

		int result = test.rob_ref(nums);
		System.out.println(result);
		result = test.rob(nums);
		System.out.println(result);
	}

}
