package com.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/permutation-sequence/
 */
public class P60_Permutation_Sequence {

	/**
	 * Note: Given n will be between 1 and 9 inclusive.
	 * 9!=362880
	 * 使用LinkedList保存数字，使返回值只与n的序列有关！
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation(int n, int k) {
		if(n<1) return "";
		int i;
		StringBuilder str =  new StringBuilder("");
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		int[] stage = new int[n];
		stage[0]=1;
		for(i=1;i<n;i++){
			list.add(i+1);
			stage[i]=(i+1)*stage[i-1];
		}
		
		if(stage[n-1]<k) return "";

		// k-1 = (n-1)!A[0] + (n-2)!A[1] + ... + 2!A[n-3] + 1!A[n-2] + 0!*A[n-1]
		
		int temp=k -1 ; //重要！！！换成0开始的序列,便于计算首位
		int index=-1;
		
		//从 n-2 由高向低计算
		for(i=n-2;i>=0;i--){
			index=temp/stage[i];
			temp=temp-index*stage[i];
			str.append(list.remove(index));
		}
		str.append(list.remove(0));

		System.out.println(str.toString());


		return str.toString();
	}

	/**
	 * @see https://leetcode.com/discuss/16064/an-iterative-solution-for-reference
	 */
	public String getPermutation_ref(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		getPermutation(3,1);
		getPermutation(3,2);
		getPermutation(3,3);
		getPermutation(3,4);
		getPermutation(4,5);

	}

}
