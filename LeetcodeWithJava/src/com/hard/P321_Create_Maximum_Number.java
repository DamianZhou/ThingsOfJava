package com.hard;
/**
 * 未完成
 * @author DamianZhou
 * @see https://leetcode.com/problems/create-maximum-number/
 * 
 */
public class P321_Create_Maximum_Number {

	/**
	 * 参考链接 https://leetcode.com/discuss/75668
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int get_from_nums1 = Math.min(nums1.length, k);
		int[] ans = new int[k];
		for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
			int[] res1 = new int[i];
			int[] res2 = new int[k - i];
			int[] res = new int[k];
			res1 = solve(nums1, i);
			res2 = solve(nums2, k - i);
			int pos1 = 0, pos2 = 0, tpos = 0;

			while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
				if (compare(res1, pos1, res2, pos2))
					res[tpos++] = res1[pos1++];
				else
					res[tpos++] = res2[pos2++];
			}
			while (pos1 < res1.length)
				res[tpos++] = res1[pos1++];
			while (pos2 < res2.length)
				res[tpos++] = res2[pos2++];

			if (!compare(ans, 0, res, 0))
				ans = res;
		}

		return ans;
	}

	/**
	 * 向后比较；数组局部一致，优先取较长的数组
	 * @param nums1
	 * @param start1
	 * @param nums2
	 * @param start2
	 * @return
	 */
	public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
		for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
			if (nums1[start1] > nums2[start2]) return true;
			if (nums1[start1] < nums2[start2]) return false;
		}
		return start1 != nums1.length;
	}

	public int[] solve(int[] nums, int k) {
		int[] res = new int[k];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
				len--;
			}
			if (len < k)
				res[len++] = nums[i];
		}
		return res;
	} 


	//-----------------------------------------

	/*
	 * 我的思路：
	 * 1. 保证剩余k个数，分别查找nums1和nums2所能提供的最大的值，取其中的最大值，k-1再继续寻找
	 * 2. 当两个数组的最大值相等的时候，就需要比较不同场景下两种选择的优劣。
	 *    一般情况下是向后比较，保留有较大后续值得数组；
	 *    当两个最大值都是最后一个数的时候，需要向前比较，获取较大的值。
	 */

	public int[] maxNumber_to__be__done(int[] nums1, int[] nums2, int k) {
		if(nums1==null && nums2 == null || k<1)
			return null;
		if(nums1.length+nums2.length<k)
			return null;

		int[] result = new int[k];

		subMaxNumber(nums1, 0, nums2, 0, k, result);


		return result;

	}

	public void subMaxNumber(int[] nums1, int s1,int[] nums2, int s2, int k,int[] result) {

		if(k<=0)
			return;
		else if(s1>=nums1.length){
			fillArray(nums2, s2, k, result);
			return;
		}else if (s2>=nums2.length){
			fillArray(nums1, s1, k, result);
			return;
		}
		int m1 = findMaxPos(nums1, s1, nums2, s2, k);
		int m2 = findMaxPos(nums2, s2, nums1, s1, k);

		if(nums1[m1]>nums2[m2]){
			result[result.length-k] = nums1[m1];
			s1=m1+1;
		}else if(nums1[m1]<nums2[m2]){
			result[result.length-k] = nums2[m2];
			s2=m2+1;
		}else{
			//如果当前两个数相等，需要比较后续的数值以及可能影响到的前续数值

			if(m1==nums1.length-1 && m2==nums2.length-1){
				//同时取到最后一个数，向前比较
				if(compareBiggerBefore(nums1, s1, m1-1, nums2, s2, m2-1)){
					result[result.length-k] = nums2[m2];
					s2=m2+1;
				}else{
					result[result.length-k] = nums1[m1];
					s1=m1+1;
				}

			}else{
				int i=0;
				while(m1+i<nums1.length && m2+i<nums2.length && nums1[m1+i]==nums2[m2+i] ){
					i++;
				}
				if(m1+i==nums1.length){
					result[result.length-k] = nums2[m2];
					s2=m2+1;
				}else if(m2+i==nums2.length){
					result[result.length-k] = nums1[m1];
					s1=m1+1;
				}else if(nums1[m1+i]>nums2[m2+i]){
					result[result.length-k] = nums1[m1];
					s1=m1+1;
				}else{
					result[result.length-k] = nums2[m2];
					s2=m2+1;
				}
			}
		}
		k--;
		subMaxNumber(nums1, s1, nums2, s2, k, result);
	}

	int findMaxPos(int[] nums1,int s1,int[] nums2,int s2,int k){

		int start = s1;
		int end;
		int distance = Math.max(k-(nums2.length-s2),0);
		if(distance==0)
			end = nums1.length-1 - distance;
		else
			end = nums1.length-distance;

		int max = Integer.MIN_VALUE;
		int pos = -1;
		for(int i=start;i<=end;i++){
			if(nums1[i]>max){
				max = nums1[i];
				pos=i;
			}
		}

		return pos;
	}

	void fillArray(int[] nums,int s,int k,int[] result){
		if(k<=0)
			return;
		if(nums.length-s==k){
			for(int i=s;i<nums.length;i++)
				result[result.length-k+i-s]=nums[i];
		}else{
			int max = Integer.MIN_VALUE;
			int pos = -1;
			for(int i=s;i<=nums.length-k;i++){
				if(nums[i]>max){
					max = nums[i];
					pos=i;
				}
			}
			result[result.length-k]=nums[pos];
			k--;
			fillArray(nums, pos+1, k, result);
		}
	}

	boolean compareBiggerBefore(int[] nums1,int s1,int e1,int[] nums2,int s2,int e2){
		int limit = 1+Math.min(e1-s1, e2-s2);
		int i;
		for(i=0;i<limit;i++){
			if(nums1[e1-i]==nums2[e2-i]){
				continue;
			}else if(nums1[e1-i]>nums2[e2-i])
				return true;
			else
				return false;
		}
		if(e1-i<s1)
			return false;
		else
			return true;
	}

	//-----------------------------------------

	public static void main(String[] args) {
		P321_Create_Maximum_Number test = new P321_Create_Maximum_Number();
		//		int[] nums1 = {1,3,5,7,9};
		//		int[] nums2 = {2,4,6,8,5};
		//		int[] result = test.maxNumber(nums1, nums2, 10);

		//		int[] nums1 = {1,2};
		//		int[] nums2 = {1,2,4};
		//		int[] result = test.maxNumber(nums1, nums2, 5);

		int[] nums1 = {3,9};
		int[] nums2 = {8,9};
		int[] result = test.maxNumber(nums1, nums2, 3);		

		for(int e:result)
			System.out.print(e);

	}

}
