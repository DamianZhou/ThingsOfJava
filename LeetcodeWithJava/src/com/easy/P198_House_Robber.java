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
    
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6};
		int k=rob(num);
		System.out.println(k);
 
	}

}
