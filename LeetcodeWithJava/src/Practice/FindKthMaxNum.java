package Practice;

/**
 * 查找两个有序数组中的第k大
 * @author DamianZhou
 * @see http://www.cnblogs.com/XjChenny/p/3161592.html
 */
public class FindKthMaxNum {

	int findKthMinInTwoArrays(int[] a,int[] b,int k){
		return subFindKthMin(a, 0, a.length-1, b, 0, b.length-1, k);
	}
	
	/**
	 * 使用二分查找，取两个有序数组的第k小。注意：
	 * 1. 只有当删除较小部分的数据时，k才减少
	 * 2. 当 k ＝＝ t 的时候，不一定t位置的就是第k大（两数组分布不均的时候） 
	 * 
	 * @param 数组a
	 * @param 起始位置sa
	 * @param 结束位置ea
	 * @param 数组b
	 * @param 起始位置sb
	 * @param 结束位置eb
	 * @param k
	 * @return
	 */
	int subFindKthMin(int[] a,int sa,int ea,int[] b,int sb,int eb,int k){
		
		if(ea<sa)
			return b[k-1-sa]; //减去a已经匹配的部分
		if(eb<sb)
			return a[k-1-sb]; //减去b已经匹配的部分
		
		int m = sa+(ea-sa)/2;
		int n = sb+(eb-sb)/2;
		
		if(a[m]>b[n])
			return subFindKthMin(b, sb, eb, a, sa, ea, k); // 保证 a 数组一直是较小的位置
		
		int t = m+n+1; //t 指向 两个数组的较小的中间值
		if(k<=t){
			//不能用k==t来跳出
			//e.g. a={1,3,5,7,9} b={2,4} k=3
			return subFindKthMin(a, sa, ea, b, sb, n-1, k); //剔除较大数，即删除b的右半部分。右半部分肯定序列>k
		}else{
			return subFindKthMin(a, m+1, ea, b, sb, eb, k); //剔除较小数，即删除a的左半部分。左半部分肯定序列<k
		}
	}
	
	/**
	 * 在两个有序数组中查找第k小的数
	 * 
	 * 每次比较 k/2 位置，然后剔除 k/2 大小的部分数组，动态调整k的值
	 * @param nums1
	 * @param start1 当前起始位置 
	 * @param nums2
	 * @param start2 当前起始位置 
	 * @param k 当前所求的第k小
	 * @return
	 * 
	 * @see http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
	 */
	public static double findKth(int[] nums1, int start1 , int[] nums2,int start2, int k){
		//确保 nums1代表的是 待计算数值长度 较小的一个
		if (nums1.length-start1 > nums2.length-start2)
			return findKth(nums2, start2, nums1, start1 , k);

		if (nums1.length-start1 == 0) //nums1 为空的情况
			return nums2[k - 1+start2];

		if (k == 1) //递归退出条件 k=1
			return Math.min(nums1[start1], nums2[start2]);

		//divide k into two parts
		int pa = Math.min(k / 2, nums1.length-start1);
		int pb = k - pa;
		
		int midpos1 = start1+pa-1;
		int midpos2 = start2+pb-1;
		
		if (nums1[midpos1] < nums2[midpos2])
			return findKth(nums1, midpos1+1, nums2, start2, k - pa);
		else if (nums1[midpos1] > nums2[midpos2])
			return findKth(nums1, start1, nums2, midpos2+1, k - pb);
		else
			return nums1[midpos1];
	}


	public static void main(String[] args) {
		FindKthMaxNum test = new FindKthMaxNum();
		
		
		int[] a = {1,3,5,7,9};
//		int[] b = {2,4,6,8,10};
//		int[] a = {15,222};
		int[] b = {2,4,6};
		int k = 4;
		int result  =  test.findKthMinInTwoArrays(a, b, k);
		System.out.println(result);

	}

}
