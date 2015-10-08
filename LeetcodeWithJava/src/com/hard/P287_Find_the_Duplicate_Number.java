package com.hard;
/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/find-the-duplicate-number/
 */
public class P287_Find_the_Duplicate_Number {

	/**
	 * 不允许修改原数组、辅助空间为O(1)、重复只有一个，但是可能重复多次
	 * 
	 * 不能使用的方式：排序、BitSet
	 * 
	 * @param nums
	 * @return
	 */
    public int findDuplicate(int[] nums) {
     
    	return 0;
    }

    
    /**
     * 使用二分查找，一共n个槽位，判断 mid 左右槽位是否满载
     * @param nums
     * @return
     * @see https://leetcode.com/discuss/60830/solutions-explanation-space-without-changing-input-array
     */
    public int findDuplicate_ref1(int[] nums) {
    	
    	if(nums == null || nums.length<2)
    		return 0;
    	int n = nums.length-1;
    	return sub_findDuplicate_ref1(nums, 1, n);
    }

    public int sub_findDuplicate_ref1(int[] nums , int start , int end) {
    	if( end == start )
    		return start;
    	int mid = (start+end)>>1;
    	int smallCuunt = 0;
    	int bigCount = 0;
    	for(int value : nums){
    		if( value > mid ) bigCount++;
    		if( value < mid ) smallCuunt++;
    	}
    	
    	if(bigCount+smallCuunt<nums.length-1) //当前值重复，左右的数量会变少
    		return mid;
    	else if(bigCount > nums.length-1-mid) //大数的数量多于槽位
    		return sub_findDuplicate_ref1(nums, mid+1, end);
    	else
    		return sub_findDuplicate_ref1(nums, start, mid-1);
    }
    
	public static void main(String[] args) {
		
		P287_Find_the_Duplicate_Number test = new P287_Find_the_Duplicate_Number();
		int[] nums = {1,2,3,4,5,1};
		int result = test.findDuplicate_ref1(nums);
		System.out.println(result);
		
		nums = new int[]{9,4,9,5,7,2,8,9,3,9}; // test exception 1
		result = test.findDuplicate_ref1(nums);
		System.out.println(result);

		nums = new int[]{1,3,4,2,1}; // test exception 2
		result = test.findDuplicate_ref1(nums);
		System.out.println(result);
	}

}
