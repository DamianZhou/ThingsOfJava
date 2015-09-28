package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/3sum/
 */
public class P015_3Sum {

	/**
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(nums==null || nums.length<3)
			return result;

		Arrays.sort(nums);

		int start = 0;
		int end = nums.length-1;

		//剔除左右两边 过大||过小 的值
		boolean hasChanged = true;
		while(end-start>2 && hasChanged){
			if( nums[start]+nums[end-1]+nums[end]<0 ){
				start++;
				continue;
			}
			if( nums[start]+nums[start+1]+nums[end]>0 ){
				end--;
				continue;
			}
			hasChanged=false;
		}
		if(end-start<3){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int sum=0;
			for(int i = start;i<=end;i++){
				sum+=nums[i];
				temp.add(nums[i]);
			}
			if(sum==0)
				result.add(temp);
			return result;
		}

		//		getListResult(result, nums, start, end); //超时

		for(int i = start;i<end-2;i++){
			if(i>start && nums[i]==nums[i-1])
				continue;//跳过重复的
			int target = 0-nums[i];
			sub2Sum(result, nums, i+1, end, target);
		}

		return result;
	}

	/**
	 * 使用两个指针查找target
	 * @see http://www.cnblogs.com/tenosdoit/p/3649607.html
	 * 
	 * @param result
	 * @param nums
	 * @param start
	 * @param end
	 * @param target
	 */
	void sub2Sum(List<List<Integer>> result , int[] nums , int start,int end,int target){

		int tmp = 0 ;
		while(end>start){
			tmp = nums[start]+nums[end];
			if(tmp<target)
				start++;
			else if(tmp>target)
				end--;
			else{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(-target);
				temp.add(nums[start]);
				temp.add(nums[end]);
				result.add(temp);

				//跳过重复的元素，在中间继续查找
				int k = start+1;
				while(k<end && nums[k] == nums[start])
					k++;
				start = k;

				k=end-1;
				while(k>start && nums[k]==nums[end])
					k--;
				end = k;
			}
		}	
	}



	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * 使用两重循环，Time Limit Exceeded 
	 * 2015/09/25
	 * @param result
	 * @param nums
	 * @param start
	 * @param end
	 */
	void getListResult(List<List<Integer>> result, int[] nums ,int start , int end){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = start;i<=end;i++){
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				hashMapAdd(map, nums[i]);
		}

		int old=nums[start]-1;
		for(int i=start;i<end-1;i++){
			hashMapMinus(map, nums[i]);
			if(old == nums[i])
				continue;
			else
				old = nums[i];

			for(int j=i+1;j<end;j++){
				hashMapMinus(map, nums[j]);
				int val = -(nums[i]+nums[j]);    			
				if(map.containsKey(val) && map.get(val)>0){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(val);
					result.add(temp);
				}
			}
			for(int j=i+1;j<end;j++)
				hashMapAdd(map, nums[j]); // nums[j] 恢复到之前的状态

			// nums[i] 使用以后，就剔除
		}
	}

	void hashMapAdd(HashMap<Integer, Integer> map , int key){
		int val = map.get(key);
		val++;
		map.put(key, val);
	}

	void hashMapMinus(HashMap<Integer, Integer> map , int key){
		int val = map.get(key);
		val--;
		map.put(key, val);
	}
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//	/**
	//	 * 2015/05/09 未完成
	//	 * @param nums
	//	 * @return
	//	 * 
	//	 * 非递减数列（(ie, a ≤ b ≤ c)）、每个元素不超过2个
	//	 */
	//	public List<List<Integer>> threeSum(int[] nums) {
	//		List<List<Integer>> result = new LinkedList<List<Integer>>();
	//		int len = nums.length;
	//		if(len <= 3) return result;    	
	//
	//		Arrays.sort(nums);
	//		System.out.println(Arrays.toString(nums));
	//
	//		if(nums[0]>=0 || nums[len-1]<=0) return result; //无法获取到0
	//
	//		int changepos = findChangePoint(nums, 0, len-1);
	//		int left = 0 , right = len-1;
	//		int a,b,sum,pos;
	//
	//		while(right>changepos && left<changepos){
	//			a=nums[left];
	//			b=nums[right];
	//			sum = a+b;
	//			pos= changepos;
	//			if(sum==0)
	//				if(nums[pos]==0) 
	//					result.add(new ArrayList<Integer>( Arrays.asList(a,nums[pos],b) ) );
	//				else if(nums[pos]<0){
	//					while(pos<=right){
	//						if(nums[pos]+a+b == 0) 
	//							result.add(new ArrayList<Integer>( Arrays.asList(a,nums[pos],b) ) );
	//						pos++;
	//					}
	//				}else{
	//					while(pos>=left){
	//						if(nums[pos]+a+b == 0) 
	//							result.add(new ArrayList<Integer>( Arrays.asList(a,nums[pos],b) ) );
	//						pos--;
	//					}  				
	//				}
	//			right--;
	//			left++;
	//
	//		}
	//
	//		//找到正负的分界点
	//		System.out.println(findChangePoint(nums, 0, len-1));
	//
	//		return result;
	//
	//	}
	//
	//	/**
	//	 * 2015/05/09
	//	 * 正负的分界点
	//	 * @param nums
	//	 * @param start
	//	 * @param end
	//	 * @return
	//	 */
	//	int findChangePoint(int[] nums, int start, int end){
	//
	//		if(end ==  start) 
	//			return start;
	//		else if( (end-start)==1) 
	//			return start; //取较小的数
	//
	//		int mid = (start+end)>>1;
	//				if(nums[mid]==0) 
	//					return mid;
	//				else if(nums[mid]>0) 
	//					return findChangePoint(nums, start, mid);
	//				else 
	//					return findChangePoint(nums, mid, end);
	//
	//	}
	//
	//	
	//	/**
	//	 * 
	//	 * @param nums
	//	 * @return
	//	 */
	//	public List<List<Integer>> threeSum_ref(int[] nums) {
	//		return null;
	//		
	//	}

	public static void main(String[] args) {
		P015_3Sum test = new P015_3Sum();
		int[] nums = {-1,1,2 ,-1, -4,0};

		List<List<Integer>>  result = test.threeSum(nums);

		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.toString(result.get(i).toArray()));
		}

	}

}
