package com.easy;

/**
 * 不能连续获得两个值
 * @author DamianZhou
 * @see https://leetcode.com/problems/house-robber/
 */
public class P198_House_Robber {

	
    public static int rob(int[] num) {
    	if(num.length==0) return 0;
    	int[] maxt = new int[num.length+1];
    	maxt[0]=0;
    	maxt[1]=num[0];
    	int i;
    	for(i=2;i<maxt.length;i++){
    		maxt[i]=Math.max(maxt[i-2]+num[i-1], maxt[i-1]);
    	}
    	for(i=0;i<maxt.length;i++)	
    		System.out.print(maxt[i]+"->");
		return maxt[maxt.length-1];
    }
    
	/**
	 * 2015/05/21
	 * 动态规划,区分奇偶
	 * @param nums
	 * @return
	 * @see https://leetcode.com/discuss/30079/c-1ms-o-1-space-very-simple-solution
	 */
	public int rob_ref(int[] nums) {
		int a = 0;
	    int b = 0;

	    for (int i=0; i<nums.length; i++) {
	        if (i%2==0)
	            a = Math.max(a+nums[i], b);
	        else
	            b = Math.max(a, b+nums[i]);
	        
	        System.out.println("a="+a+" ,b="+b);
	    }

	    return Math.max(a, b);
	}
    
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6};
		int k=rob(num);
		System.out.println(k);
 
	}

}
