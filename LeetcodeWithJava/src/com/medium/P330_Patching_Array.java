package com.medium;
/**
 * 
 * @author Administrator
 * @see https://leetcode.com/problems/patching-array/
 */
public class P330_Patching_Array {

    public int minPatches(int[] nums, int n) {
    	
    	
    	
		return n;
        
    }
	
    /**
     * https://leetcode.com/discuss/82822
     * Let miss be the smallest sum in [0,n] that we might be missing. 
     * Meaning we already know we can build all sums in [0,miss).
     * @param nums
     * @param n
     * @return
     */
    int minPatches_s1(int[] nums, int n) {
        int miss = 1;  //��С�Ӽ�֮��
        int added = 0; //�����ֵ�ĸ���
        int i = 0;
        while (miss <= n) {
        	
            if (i < nums.length && nums[i] <= miss) { 
            	//������ǰ��ֵ��ֱ������
                miss += nums[i++];
            } else {
            	//���������û���µ��� || ��ǰ��ֵ�ϴ�������miss��С��������С����
                miss += miss;
                added++;
            }
            
        }
        return added;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
