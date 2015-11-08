package com.hard;

import java.util.HashMap;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class P128_Longest_Consecutive_Sequence {

	/**
	 * 
	 * @param nums
	 * @return
	 * @see https://leetcode.com/discuss/18886/my-really-simple-java-o-n-solution-accepted
	 */
	public int longestConsecutive_ref(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : nums) {
			if (!map.containsKey(n)) {
				int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;   //表示左边已有的连续数字的长度
				int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
				
				// sum: length of the sequence n is in
				int sum = left + right + 1;
				map.put(n, sum);

				// keep track of the max length 
				res = Math.max(res, sum);

				// extend the length to the boundary(s) of the sequence will do nothing if n has no neighbors
				map.put(n - left, sum);   //直接确保首位置为最大长度，保证潜在连接的准确
				map.put(n + right, sum);
			}
			else {
				// duplicates 忽略重复的数字
				continue;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		P128_Longest_Consecutive_Sequence test = new P128_Longest_Consecutive_Sequence();
		int[] nums = {1,2,3,4,17,18,19,200,201};
		int result  = test.longestConsecutive_ref(nums);
		System.out.println(result);

	}

}
