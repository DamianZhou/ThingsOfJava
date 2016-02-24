package com.medium;

import java.util.Arrays;

/**
 * 
 * @author Damian
 * @see https://leetcode.com/problems/h-index/
 */
public class P274_H_Index {
	
	/**
	 * 使用排序，时间复杂度为O( nlog(n) )
	 * h最大为已发表论文的个数citations.length，
	 * 依照排序后的数组，依次寻找满足条件的最大h
	 * @param citations
	 * @return
	 */
    public int hIndex(int[] citations) {
    	
    	if(citations==null || citations.length<1)
    		return 0;
    	
    	Arrays.sort(citations);
    	
    	int cite = citations.length;
    	int i=0;
    	for(;i<citations.length;i++){
    		if(citations[i]>=(cite-i))
    			break;
    	}
    	return cite-i;
    }
    
    /**
     * 时间复杂度为O(n)
     * @param citations
     * @return
     * @see https://leetcode.com/discuss/55952
     */
    public int hIndex_s1(int[] citations) {
        int L = citations.length;
        if(L<1) 
        	return 0;
        
        //用数组的下标直接表示论文的引用数,数值表示论文数
        int[] counts = new int[L+1];
        for(int i : citations) {
            if(i>L) 
            	counts[L]++;
            else 
            	counts[i]++;
        }
        int res = 0;
        for(int k=L; k>=0; k--) {
            res += counts[k];
            if(res>=k) 
            	return k;
        }
        return 0;
    }

	public static void main(String[] args) {
		P274_H_Index test = new P274_H_Index();
		int[] nums={4,0,6,4,5};
		int result = test.hIndex(nums);
		System.out.println(result);
	}

}
