package com.Basic.Algorithm;

/**
 * 两个有序数组求第K小
 * @author DamianZhou
 */
public class KthNum {
	
	int getKthNum(int[] na,int[] nb,int k){
		if(na == null || nb == null || k<1)
			return 0;
		return subGetKthNum(na, 0, na.length-1, nb, 0, nb.length-1, k);
	}
	/**
	 * 指定na中间值较小
	 * @param na
	 * @param sa
	 * @param ea
	 * @param nb
	 * @param sb
	 * @param eb
	 * @param k
	 */
	int subGetKthNum(int[] na,int sa,int ea,int[] nb,int sb,int eb,int k){
		if(sa>ea)
			return nb[sb+k-1];
		if(sb>eb)
			return na[sa+k-1];
		
		int mid1 = (sa+ea)/2;
		int mid2 = (sb+eb)/2;
		
		//确保na为中间值较小的数组
		if(na[mid1]>nb[mid2])
			return subGetKthNum(nb, sb, eb,na, sa, ea, k);
		
		if(mid1-sa+mid2-sb+1==k){ // k是相对距离
			return na[mid1];
		}else if(mid1-sa+mid2-sb+1>k){
			return subGetKthNum(na, sa, ea, nb, sb, mid2-1, k);
		}else{
			return subGetKthNum(na, mid1+1,ea, nb, sb, eb, k-(mid1+1-sa));
		}
	}
	

	public static void main(String[] args) {
		KthNum test = new KthNum();
		int[] na = {1,3,5,7,9};
		int[] nb = {2,4,6,8,10,100};
		int k = 5;
		int result = test.getKthNum(na, nb, k);
		System.out.println(result);

	}

}
