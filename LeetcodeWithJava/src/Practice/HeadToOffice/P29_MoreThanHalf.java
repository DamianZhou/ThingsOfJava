package Practice.HeadToOffice;

public class P29_MoreThanHalf {
	
	/**
	 * 数组中出现次数超过一半的数字
	 * @param nums
	 * @return
	 */
	int getMoreThanHalf( int[] nums ){
		if ( nums ==  null || nums.length==0)
			return -1;
		int value = nums[1];
		int times = 1;
		
		for(int i =1;i<nums.length;i++){
			if(value!=nums[i])
				times--;
			else
				times++;
			
			if(times==0){
				value=nums[i];
				times=1;
			}
		}
		
		
		
		if(checkNumMoreThenHalf(nums, value))
			return value;
		else
			return -1;
	}
	
	boolean checkNumMoreThenHalf(int[] nums , int target){
		System.out.println( "value="+target );
		int times = 0;
		for (int i=0;i<nums.length;i++){
			if(nums[i]==target)
				times++;
		}
		
		if(times > nums.length>>1 )
			return true;
		else
			return false;
	}
	

	public static void main(String[] args) {
		P29_MoreThanHalf test = new P29_MoreThanHalf();
		int[] nums  = { 1,1,1,0,2,0,0,1,1 };
		
		System.out.println(test.getMoreThanHalf(nums));
		

	}

}
