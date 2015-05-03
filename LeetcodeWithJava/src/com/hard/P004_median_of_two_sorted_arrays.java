package com.hard;

import java.util.Arrays;

/**
 * O(log (m+n))
 * @author Damian
 * @see https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class P004_median_of_two_sorted_arrays {


	/**
	 * 二分查找
	 * @param p
	 * @param n
	 * @param x
	 * @return
	 */
	static int findPos(int[] p,int n,int x){
		int low=0,high=n-1,mid;
		while(low<=high){
			mid=(low+high)>>1;
		if(p[mid]<=x)
			low=mid+1;
		else 
			high=mid-1;
		}
		return low;
	}
	/**
	 * 查找第K个
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 * @param k
	 * @return
	 * @see http://blog.csdn.net/cklsoft/article/details/40841637
	 */
	static double findK(int a[], int m, int b[], int n,int k){
		int mid1,mid2;
		int low1=0, low2=0;
		int high1=m-1,high2=n-1;
		int x;

		while(low1<=high1&&low2<=high2){
			mid1=((high1+low1)>>1);
			mid2=((high2+low2)>>1);
			System.out.println(Arrays.toString(Arrays.copyOfRange(a,low1, high1+1)));
			System.out.println(Arrays.toString(Arrays.copyOfRange(b,low2, high2+1)));
			System.out.println("mid1="+mid1);
			System.out.println("mid2="+mid2);
			System.out.println("-----------------------------");
			if(a[mid1]<b[mid2]){
				if(mid1+mid2+2==k){
					low1=mid1+1;
					high2=mid2;
				}else if(mid1+mid2+2<k){
					low1=mid1+1;		//删除最小的区间
				}else 
					high2=mid2-1;		// 删除最大的区间
			}else{
				if(mid1+mid2+2==k){
					low2=mid2+1;
					high1=mid1;
				}else if(mid1+mid2+2<k){ 
					low2=mid2+1;
				}else 
					high1=mid1-1;
			}
		}

		if(low1<=high1){
			//	if(low1==high1)return a[low1];
			while(low1<=high1){
				mid1=((low1+high1)>>1);
				x=findPos(b,n,a[mid1]);
				if(x+mid1+1==k)
					return a[mid1];
				else if(x+mid1<k)
					low1=mid1+1;
				else 
					high1=mid1-1;
			}
			return low1>=m?a[m-1]:a[low1];
		}else {
			//		if(low2==high2)return b[low2];
			while(low2<=high2){
				mid2=((low2+high2)>>1);
				x=findPos(a,m,b[mid2]);
				if(x+mid2+1==k)return b[mid2];
				else if(x+mid2<k)low2=mid2+1;
				else high2=mid2-1;
			}
			return low2>=n?a[n-1]:b[low2];
		}
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		int k= A.length+B.length;
		if((k&1)==1){
			return findK(A,A.length,B,B.length,k/2+1);
		}
		else{
			return (findK(A,A.length,B,B.length,k/2)+findK(A,A.length,B,B.length,k/2+1))/2.0;
		}
	}



	public static void main(String[] args) {
		int[] A = {1,3,5,7,9,11};
		int[] B = {2,4,6,8,10};
		System.out.println(findMedianSortedArrays(A, B));
	}

}