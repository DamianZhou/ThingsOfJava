package com.Basic.Algorithm;

public class Sort_InsertSort extends CommonUtil {
	
	static void InsertSort(int a[], int n)  
	{  
		for(int i= 1; i<n; i++){  
			if(a[i] < a[i-1]){               //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入  
				int j= i-1;   
				int x = a[i];        
				a[i] = a[i-1];           //先后移一个元素  
				while(x < a[j]){  //查找在有序表的插入位置  
					a[j+1] = a[j];  
					j--;         //元素后移  
					if(j<0)
						break;
				}  
				a[j+1] = x;      //插入到正确位置  
			}  
			printArray(a,n,i);           //打印每趟排序的结果  
		}  

	}  

	public static void main(String[] arsgs){  
		int[] a = {3,1,5,7,2,4,9,6};  
		InsertSort(a,8);  
		printArray(a,8,8);  
	} 

}
