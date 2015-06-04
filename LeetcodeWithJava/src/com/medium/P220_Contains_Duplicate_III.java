package com.medium;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/contains-duplicate-iii/
 */
public class P220_Contains_Duplicate_III {

	/**
	 * 2015/06/03
	 * 思路：维护一个长度为k的窗口，记录窗口中的最大值和最小值；然后移动窗口，判断条件是否成立。
	 * 缺点：每次对新增的值，都需要重新计算最大最小值。
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		return false;   
	}


	//---------------------------------------------------------------------------------------------


	public boolean containsNearbyAlmostDuplicate_ref(int[] nums, int k, int t) {
		if (nums == null || nums.length<=1 || k==0){
			return false;
		}
		
		TreeSet<Number> set = new TreeSet<Number>( new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				return (int) (o1.val - o2.val);
			}
		});
		
		LinkedList<Number> list = new LinkedList<Number>();

		for (int i=0;i<nums.length;i++){
			
			if (list.size()>k){
				Number toRemove = list.pollFirst(); //获取最小值
				set.remove(toRemove);
			}

			Number num = new Number(nums[i],i);

			if (set.isEmpty() == false){
				java.util.NavigableSet<Number> s1 = set.tailSet(num, true); //最后一个
				if (s1.isEmpty() == false && s1.first().val - num.val <= t){
					return true;
				}

				java.util.NavigableSet<Number> s2 = set.headSet(num, true); //第一个
				if (s2.isEmpty() == false && num.val - s2.last().val <= t){
					return true;
				}
			}
			list.add(num);
			set.add(num);
		}


		return false;
	}

	/**
	 * TreeSet 带有index的复合节点
	 * @author DamianZhou
	 */
	class Number{
		long val;
		int index;
		
		public Number(long val,int index){
			this.val=val;
			this.index=index;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
