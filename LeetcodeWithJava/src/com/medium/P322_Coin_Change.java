package com.medium;

import java.util.Arrays;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/coin-change/
 */
public class P322_Coin_Change {

	/**
	 * 使用动态规划
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if(coins==null || coins.length==0 || amount<0)
			return 1;
		if(amount==0)
			return 0;
		int[] cache = new int[amount+1];
		Arrays.fill(cache,-1);
		Arrays.sort(coins);
		for(int i=0;i<coins.length && coins[i]<=amount;i++)
			cache[coins[i]]=1;

		for(int i=coins[0];i<=amount;i++){
			int min=Integer.MAX_VALUE;
			for(int j=coins.length-1;j>=0;j--){
				if( coins[j]>=i )				//硬币大于数值
					continue;
				else if(cache[i-coins[j]]<0)	//没有对应的分解方式
					continue;
				else{
					min = min<cache[i-coins[j]]?min:cache[i-coins[j]];
				}
			}
			if(min!=Integer.MAX_VALUE)
				if(cache[i]==-1)
					cache[i]=min+1;
				else
					cache[i]=Math.min(cache[i], min+1);
		}


		return cache[amount];

	}

	public static void main(String[] args) {
		P322_Coin_Change test = new P322_Coin_Change();
//		int[] coins  = {1,2,5};
//		int amount = 11;

		int[] coins  = {2,5};
		int amount = 3;
		int result = test.coinChange(coins, amount);
		System.out.println(result);
	}

}
