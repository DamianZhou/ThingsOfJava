package bestcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class dd_t2 {
	
	//用map实现桶排序
	void findMaxLength(int[] sum)
	{
		HashMap<Integer, LinkedList<Integer>> bucket = new HashMap<Integer, LinkedList<Integer>>();

		int max = -1;
		int maxKey=Integer.MAX_VALUE;
	    for(int i=0; i<sum.length; i++){
	    	if(!bucket.containsKey(sum[i])){
	    		LinkedList<Integer> temp = new LinkedList<Integer>();
	    		temp.add(i);
	    		bucket.put(sum[i], temp);
	    	}else{
	    		LinkedList<Integer> temp = bucket.get(sum[i]);
	    		if(temp.size()==1){
	    			temp.add(i);
	    		}else{
	    			temp.pollLast();
	    			temp.add(i);
	    		}
	    		//更新
	    		if(temp.get(1)-temp.get(0)>max){
	    			max = temp.get(1)-temp.get(0);
	    			maxKey = sum[i];
	    		}
	    	}
	    }
	    LinkedList<Integer> temp = bucket.get(maxKey);
	    System.out.println(temp.get(0)+" "+temp.get(1));
	}

	void subArraySum(int[] nums)
	{
	    if(nums == null)
	        return ;
	    int[] sum = new int[nums.length];

	    sum[0] = nums[0];
	    for(int i=1; i<nums.length; ++i)
	        sum[i] = sum[i-1]+nums[i];
	    
	   findMaxLength(sum);
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		dd_t2 test = new dd_t2();
		int[] nums = {1,2,3,4,-1,-2,-4,-3,1,2};
		test.subArraySum(nums);
		
	}

}
