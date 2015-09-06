package Practice;

/**
 * 已经有序的数组中，二分查找
 * @author Damian
 */
public class MidFind {
	
	/**
	 * 递增数组查找
	 * @param nums
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	private int midfind(int[] nums,int target,int left,int right){
		if(left>right || nums[left]>target || nums[right]<target)
			return -1;
		int mid = (left+right)>>1;
		if(nums[mid]==target)
			return mid;
		else if(nums[mid]>target){
			return midfind(nums, target, left, mid-1);
		}else{
			return midfind(nums, target, mid+1, right);
		}		
	}

	
	/**
	 * 先递减再递增数组，求波谷的位置
	 * @param nums
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	private int midFindComplexMin(int[] nums,int left,int right){
		if(right-left<2)
			return -1;
		else if(right-left==2){
			//只剩三个元素，需要指定计算
			int mid = left+1;
			if(nums[mid]<nums[left] && nums[mid]<nums[right]){
				return mid;
			}else{
				return nums[left]<nums[right]?left:right;
			}
		}
		
		// 不少于4个元素的数组
		int mid = (left+right)>>1;
		if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])
			return mid;
		else if(nums[mid]<nums[mid-1] && nums[mid]>nums[mid+1]){
			return midFindComplexMin(nums,mid,right);
		}else{
			return midFindComplexMin(nums, left, mid);
		}		
	}
	
	
	private int midFindComplex(int[] nums,int target){
		
		int min = midFindComplexMin(nums, 0,nums.length-1);
		
		System.out.println(min);
		
		if(min==-1)
			return midfind(nums, target, 0, nums.length);
		else{
			int leftResult = midfind(nums, target, 0, min);
			int rightResult = midfind(nums, target, min, nums.length-1);
			
			return leftResult!=-1 ? leftResult:rightResult;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		MidFind test = new MidFind();
		
//		int[] nums = {1,2,3,4,5,6,7,8,16,22};
//		System.out.println( test.midfind(nums, 0, 0, nums.length-1) );
//		System.out.println( test.midfind(nums, 9, 0, nums.length-1) );
//		System.out.println( test.midfind(nums, 11, 0, nums.length-1) );
		
		int[] nums = {12,7,4,3,1,5,9,10};
		System.out.println( test.midFindComplex(nums, 11) );
		System.out.println( test.midFindComplex(nums, 9) );
		
	}

}
