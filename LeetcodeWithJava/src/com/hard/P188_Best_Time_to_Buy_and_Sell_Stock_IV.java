package com.hard;

/**
 * k笔交易，根据已知的股价，获取最大利润
 * @author DamianZhou
 * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class P188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public static int maxProfit(int k, int[] prices) {
    	int len = prices.length;
    	if(prices.length<2)
    		return 0;
    	
    	
    	
		return k;
    }
    
    /**
     * 
     * @param k
     * @param prices
     * @return
     * @see https://leetcode.com/discuss/25603/a-concise-dp-solution-in-java
     */
    public int maxProfit_ref(int k, int[] prices) {
        int len = prices.length;
        if (k >= len>>1) 
        	return quickSolve(prices);

        int[][] matrix = new int[k + 1][len]; 
        
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                matrix[i][j] = Math.max(matrix[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, matrix[i - 1][j - 1] - prices[j]);
            }
        }
        return matrix[k][len - 1];
    }

    /**
     * 避免超时添加的函数
     * @param prices
     * @return
     */
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
    
	public static void main(String[] args) {

	}

}
