package com.medium;
/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class P121_Best_Time_to_Buy_and_Sell_Stock {
	
	/**
	 * 只买入&卖出一次
	 * 2015/04/21
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)
        	return 0;
        int tempMin=prices[0];
        int profit=0;
        for(int i=1;i<len;i++){
        	tempMin=Math.min(tempMin, prices[i-1]);	//记录历史最低价
        	profit=Math.max(profit, prices[i]-tempMin);
        }
        
    	return profit;
    }
	public static void main(String[] args) {
		int[] prices1 = {1,2,3,4,5,6,7};
		int[] prices2 = {7,6,5,4,3,2,1};
		System.out.println( maxProfit(prices1));

	}

}
