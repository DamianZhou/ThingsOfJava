package com.medium;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class P122_Best_Time_to_Buy_and_Sell_Stock_II {
    
	/**
	 * 多次交易，每次一股
	 * 每天只能有一次交易
	 *  You must sell the stock before you buy again
	 *  
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
        	
        }
		
		
		return 0;
        
    }
	public static void main(String[] args) {
		int[] prices1 = {1,2,3,4,5,6,7};
		int[] prices2 = {7,6,5,4,3,2,1};
		System.out.println( maxProfit(prices1));
	}

}
