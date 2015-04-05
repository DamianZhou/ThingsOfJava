package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/gas-station/
 */
public class P134_Gas_Station {
	/**
	 * 我的解题思路：
	 * 计算到达各个站点的油量剩余情况，
	 * 然后找出剩余最多的一片，取其起点
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit_UnDone(int[] gas, int[] cost) {
		int len = gas.length;
		if(len==1) return 0;
		int[] left = new int[len];	//从上个位置到当前位置，所剩的油
		int i;
		int count=0;
		left[0]=gas[len-1]-cost[len-1];
		count+=left[0];
		for(i=0;i<len-1;i++){
			left[i+1] = gas[i]-cost[i];
			count+=left[i+1];
		}
		if(count<0) return -1;

		int start=0;

		return start;

	}
	
	/**
	 * reference
	 * 存储每个加油站的需求，依次遍历
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 * @see https://leetcode.com/discuss/21577/my-o-n-time-o-1-extra-space-solution
	 */
	public static int canCompleteCircuit1(int[] gas, int[] cost) {
	    for(int i = 0; i < gas.length; i++) {
	        gas[i] -= cost[i];
	    }
	    int sum = 0;
	    int result = 0;
	    int n = gas.length;
	    
	    for(int i = 0; i < n ; i++) {	//从0开始一次测试每个加油站点
	        sum += gas[i % n];
	        if(sum < 0) {
	            result = i + 1;
	            if(result == n) {
	                return -1;
	            }
	            sum = 0;
	        }
	    }
	    return result;
	}

	/**
	 * reference
	 * 从一个点向后遍历，如果能完整的走完，就返回当前点
	 * @param gas
	 * @param cost
	 * @return
	 * @see https://leetcode.com/discuss/25341/fully-commented-solution-enabled-single-observation-mine
	 */
	private static int canCompleteCircuit(int[] gas, int[] cost) {
		int i, j, n = gas.length;

		/*
		 * If start from i, stop before station x -> no station k from i + 1 to x - 1 can reach x.
		 * Bcoz if so, i can reach k and k can reach x, then i reaches x. Contradiction.
		 * Thus i can jump directly to x instead of i + 1, bringing complexity from O(n^2) to O(n).
		 */

		// start from station i
		for (i = 0; i < n; i += j) {
			int gas_left = 0;

			// 向后遍历（i+j-1）所有加油站
			for (j = 1; j <= n; j++) {
				int k = (i + j - 1) % n;				//取余数来进行循环
				gas_left += gas[k] - cost[k];
				if (gas_left < 0)
					break;
			}
			if (j > n)  return i; //成功遍历
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] gas={1,2,-4,3,6,-8,7};
		int[] cost={0,0,0,0,0,0,0};
		System.out.println(canCompleteCircuit(gas, cost));
		System.out.println(canCompleteCircuit1(gas, cost));

	}

}
