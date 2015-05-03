package com.easy;

import java.util.HashSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/happy-number/
 */
public class P202_Happy_Number {

	/**
	 * 2015/04/30
	 * @param n
	 * @return
	 */
    public boolean isHappy(int n) {
    	if(n==1) return true;
    	HashSet<Integer> set = new HashSet<Integer>();
    	set.add(n);
    	set.add(1);
    	int t = getNewSum(n);
    	while(!set.contains(t)){
    		System.out.println(t);
    		set.add(t);
    		t=getNewSum(t);
    	}
    	if(t==1) 
    		return true;
    	else
    		return false;
    }
    
    public int getNewSum(int n){
    	int k=n;
    	int left=0;
    	int sum=0;
    	while(k>9){
    		left = k%10;
    		k = (k-left)/10;
    		sum+=left*left;
    	}
    	sum+=k*k;
    	return sum;
    }
    
	public static void main(String[] args) {
		P202_Happy_Number test = new P202_Happy_Number();
		test.isHappy(81);

	}

}
